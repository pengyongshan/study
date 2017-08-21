package com.tree.www.zk.lock;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

import java.util.concurrent.TimeUnit;

/**
 * 请求锁，使用资源，释放锁
 * <p>
 * Created by pysh on 2017/8/21.
 */
public class ExampleClientThatLocks {
    private final InterProcessMutex lock; // 可重入锁
    //private final InterProcessSemaphoreMutex lock; // 不可重入锁
    private final FakeLimitedResource resource;
    private final String clientName;

    public ExampleClientThatLocks(CuratorFramework client, String lockPath, FakeLimitedResource resource, String clientName) {
        this.lock = new InterProcessMutex(client, lockPath);
        //this.lock = new InterProcessSemaphoreMutex(client, lockPath);
        this.resource = resource;
        this.clientName = clientName;
    }

    public void doWork(long time, TimeUnit unit) throws Exception {
        if (!lock.acquire(time, unit)) {
            throw new IllegalStateException(clientName + " could not acquire the lock");
        }
        System.out.println(clientName + " has the lock");
        if (!lock.acquire(time, unit)) {
            throw new IllegalStateException(clientName + " could not acquire the lock");
        }
        System.out.println(clientName + " has the lock again");
        try {
            resource.use();
        } finally {
            System.out.println(clientName + " releasing the lock");
            lock.release();
            lock.release();
        }
    }

}
