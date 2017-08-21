package com.tree.www.zk.leaderlection;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListenerAdapter;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by pysh on 2017/8/21.
 */
public class ExampleClient extends LeaderSelectorListenerAdapter implements Closeable {

    private final String name;
    private final LeaderSelector leaderSelector;
    private final AtomicInteger leadCount = new AtomicInteger();

    public ExampleClient(CuratorFramework client, String path, String name) {
        this.name = name;
        leaderSelector = new LeaderSelector(client, path, this);
        leaderSelector.autoRequeue();
    }

    // 成为leader执行 执行完释放leader. 需要一直持有加死循环
    @Override
    public void takeLeadership(CuratorFramework client) throws Exception {
        final int waitSeconds = (int) (5 * Math.random()) + 1;
        System.out.println(name + " is now the leader. Waiting " + waitSeconds + " seconds...");
        System.out.println(name + " has been leader " + leadCount.getAndIncrement() + " time(s) before.");
        try {
            TimeUnit.SECONDS.sleep(waitSeconds);
        } catch (InterruptedException e) {
            System.err.println(name + " was Interrupted");
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(name + " relinquishing leadership.\n");
        }
    }

    public void start() {
        leaderSelector.start();
    }

    @Override
    public void close() throws IOException {
        leaderSelector.close();
    }
}
