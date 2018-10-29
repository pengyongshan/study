package com.tree.www.rmi.zk;


import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.util.concurrent.CountDownLatch;

/**
 * Created by pysh on 2018/9/28.
 */
public class ServiceProvider {
    private final static Logger LOGGER = LoggerFactory.getLogger(ServiceProvider.class);

    // 用于等待  SyncConnected 事件触发后继续执行当前线程
    private CountDownLatch latch = new CountDownLatch(1);

    /**
     * 发布 RMI 服务并注册 RMI 地址到 zk
     *
     * @param remote
     * @param host
     * @param port
     */
    public void publish(Remote remote, String host, int port) {
        String url = publishService(remote, host, port);
        if (url != null) {
            ZooKeeper zk = connectServer();
            if (zk != null) {
                createNode(zk, url);
            }
        }
    }

    private String publishService(Remote remote, String host, int port) {
        String url = null;
        try {
            url = String.format("rmi://%s:%d/%s", host, port, remote.getClass().getName());
            LocateRegistry.createRegistry(port);
            Naming.rebind(url, remote);
            LOGGER.debug("publish rmi service (url: {})" , url );
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return url;
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

    private void createNode(ZooKeeper zk, String url) {
        try {
            byte[] data = url.getBytes();
            // 创建一个临时性且有序的 ZNode
            String path = zk.create(Constant.ZK_PROVIDER_PATH, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            LOGGER.debug("create zookeeper node ({} => {})", path, url);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
