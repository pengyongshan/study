package com.tree.www.rmi.zk;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by pysh on 2018/9/28.
 */
public class ServiceConsumer {
    private final static Logger LOGGER = LoggerFactory.getLogger(ServiceConsumer.class);

    // 用于等待  SyncConnected 事件触发后继续执行当前线程
    private CountDownLatch latch = new CountDownLatch(1);
    // 定义一个 volatile 成员变量，用于保存最新的 RMI 地址（考虑到该变量或许会被其它线程所修改，一旦修改后，该变量的值会影响到所有线程）
    private volatile List<String> urlList = new ArrayList<>();

    public ServiceConsumer() {
        ZooKeeper zk = connectServer();
        if (zk != null) {
            watchNode(zk);
        }
    }

    public <T extends Remote> T lookUp() {
        T service = null;
        int size = urlList.size();
        if(size > 0) {
            String url;
            if(size == 1) {
                url = urlList.get(0);
                LOGGER.debug("using only url:{}", url);
            } else {
                url = urlList.get(ThreadLocalRandom.current().nextInt(size));
                LOGGER.debug("using random url:{}", url);
            }
            service = lookUpService(url);
        }
        return service;
    }

    // 观察 /registry 节点下所有子节点是否有变化
    private void watchNode(ZooKeeper zk) {
        try {
            List<String> nodeList = zk.getChildren(Constant.ZK_REGISTRY_PATH, event -> {
                if (event.getType() == Watcher.Event.EventType.NodeChildrenChanged) {
                    watchNode(zk);// 若子节点有变化，则重新调用该方法（为了获取最新子节点中的数据）
                }
            });
            List<String> dataList = new ArrayList<>();
            for (String node : nodeList) {
                byte[] data = zk.getData(Constant.ZK_REGISTRY_PATH + "/" + node, false, null);
                dataList.add(new String(data));
            }
            LOGGER.debug("node data:{}", dataList);
            urlList.addAll(dataList);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    private ZooKeeper connectServer() {
        ZooKeeper zk = null;
        try {
            zk = new ZooKeeper(Constant.ZK_CONNECTION_STRING, Constant.ZK_SESSION_TIMEOUT, event -> {
                if (event.getState() == Watcher.Event.KeeperState.SyncConnected) {
                    latch.countDown(); // 唤醒当前线程
                }
            });
            latch.await();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return zk;
    }

    @SuppressWarnings("unchecked")
    private <T> T lookUpService(String url) {
        T remote = null;
        try {
            remote = (T) Naming.lookup(url);
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return remote;
    }
}
