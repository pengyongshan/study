package com.tree.www.zk.lock;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;

import java.util.concurrent.TimeUnit;

/**
 * 读写锁
 *
 * Created by pysh on 2017/8/22.
 */
public class ExampleClientReadWriteLocks {
    private final InterProcessMutex readLock;
    private final InterProcessMutex writeLock;
    private final FakeLimitedResource resource;
    private final String clientName;

    public ExampleClientReadWriteLocks(CuratorFramework client, String lockPath, FakeLimitedResource resource, String clientName) {
        InterProcessReadWriteLock lock = new InterProcessReadWriteLock(client, lockPath);
        this.readLock = lock.readLock();
        this.writeLock = lock.writeLock();
        this.resource = resource;
        this.clientName = clientName;
    }

    public void doWork(long time, TimeUnit timeUnit) throws Exception {
        // 一个拥有写锁的线程可重入读锁，但是读锁却不能进入写锁。2个if交换成立
        if(!readLock.acquire(time, timeUnit)) {
            throw new IllegalStateException(clientName + " could not acquire the readLock.");
        }
        System.out.println(clientName + " has the readLock");

        if(!writeLock.acquire(time, timeUnit)) {
            throw new IllegalStateException(clientName + " could not acquire the writeLock.");
        }
        System.out.println(clientName + " has the writeLock too.");

        try{
            resource.use();
        } finally {
            System.out.println(clientName + " releasing the lcok");
            readLock.release();
            writeLock.release();
        }
    }
}
