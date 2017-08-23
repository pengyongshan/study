package com.tree.www.zk.lock;

import com.google.common.collect.Lists;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMultiLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.test.TestingServer;
import org.omg.CORBA.StringHolder;

import java.util.concurrent.TimeUnit;

/**
 * 多锁对象
 *
 * Created by pysh on 2017/8/23.
 */
public class InterProcessMultiLockExample {
    private static final String PATH1 = "/example/lock1";
    private static final String PATH2 = "/example/lock2";

    public static void main(String[] args) throws Exception {
        FakeLimitedResource resource = new FakeLimitedResource();
        try(TestingServer server = new TestingServer()) {
            CuratorFramework client  = CuratorFrameworkFactory.newClient(server.getConnectString(),
                    new ExponentialBackoffRetry(1000, 3));
            client.start();

            // InterProcessMultiLock multiLock = new InterProcessMultiLock(client, Lists.newArrayList(PATH1, PATH2))
            InterProcessLock lock1 = new InterProcessMutex(client, PATH1);
            InterProcessLock lock2 = new InterProcessSemaphoreMutex(client, PATH2);
            InterProcessMultiLock multiLock = new InterProcessMultiLock(Lists.newArrayList(lock1, lock2));

            if(!multiLock.acquire(10, TimeUnit.SECONDS)) {
                throw new IllegalStateException("could not acquire the lock");
            }
            System.err.println("has the lock");

            System.err.println("has the lock1: " + lock1.isAcquiredInThisProcess());
            System.err.println("has the lock2: " + lock2.isAcquiredInThisProcess());

            try{
                resource.use();
            } finally {
                System.err.println("releasing the lock");
                multiLock.release();
            }

            System.err.println("has the lock1:" + lock1.isAcquiredInThisProcess());
            System.err.println("has the lock2:" + lock2.isAcquiredInThisProcess());
        }
    }
}
