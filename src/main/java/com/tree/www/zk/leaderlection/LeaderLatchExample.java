package com.tree.www.zk.leaderlection;

import com.google.common.collect.Lists;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.test.TestingServer;
import org.apache.curator.utils.CloseableUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by pysh on 2017/8/15.
 */
public class LeaderLatchExample {

    private static final int CLIENT_QTY = 10;

    private static final String PATH = "/examples/leader";

    public static void main(String[] args) throws Exception {
        List<CuratorFramework> clients = Lists.newArrayList();
        List<LeaderLatch> examples = Lists.newArrayList();
        TestingServer server = new TestingServer();
        try {
            for (int i = 0; i < CLIENT_QTY; ++i) {
                CuratorFramework client = CuratorFrameworkFactory.newClient(server.getConnectString(), new ExponentialBackoffRetry(1000, 3));
                clients.add(client);
                LeaderLatch example = new LeaderLatch(client, PATH, "Clent #" + i);
                examples.add(example);
                client.start();
                example.start();
            }
            TimeUnit.SECONDS.sleep(20);
            System.out.println("current leader is " + examples.get(0).getLeader().getId());
            LeaderLatch currentLeader = null;
            for (int i = 0; i < CLIENT_QTY; ++i) {
                LeaderLatch example = examples.get(i);
                if (example.hasLeadership()) {
                    currentLeader = example;
                    break;
                }
            }
            System.out.println("current leader is " + currentLeader.getId());
            System.out.println("current leader is " + currentLeader.getLeader().getId());
            System.out.println("release the leader " + currentLeader.getId());
            currentLeader.close();
            examples.get(0).await(2, TimeUnit.SECONDS);
            System.out.println("Client #0 maybe is elected as the leader or not although is want to be");
            System.out.println("the new leader is " + examples.get(0).getId());
            System.out.println("the new leader is " + examples.get(0).getLeader().getId());
            System.out.println("Press enter/return to quit\n");
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("shutting down...");
            for (LeaderLatch leaderLatch: examples) {
                CloseableUtils.closeQuietly(leaderLatch);
            }
            for (CuratorFramework client: clients) {
                CloseableUtils.closeQuietly(client);
            }
            CloseableUtils.closeQuietly(server);
        }
     }
}
