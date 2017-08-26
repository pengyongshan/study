package com.tree.www.zk.framework;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.transaction.CuratorTransaction;
import org.apache.curator.framework.api.transaction.CuratorTransactionFinal;
import org.apache.curator.framework.api.transaction.CuratorTransactionResult;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.test.TestingServer;

import java.util.Collection;

/**
 * 事务
 * <p>
 * Created by pysh on 2017/8/26.
 */
public class TransactionExample {

    public static void main(String[] args) throws Exception {
        TestingServer server = new TestingServer();
        CuratorFramework client = CuratorFrameworkFactory.newClient(server.getConnectString(),
                new ExponentialBackoffRetry(1000, 3));
        client.start();
        Collection<CuratorTransactionResult> results = transaction(client);
        for (CuratorTransactionResult result : results) {
            System.out.println(result.getForPath() + "-" + result.getType());
        }
    }

    public static Collection<CuratorTransactionResult> transaction(CuratorFramework client)
            throws Exception {
        // this example shows how to use ZooKeeper's new transactions
        return client.inTransaction().create()
                .forPath("/a/path", "some data".getBytes())
                .and().setData().forPath("/another/path", "other data".getBytes())
                .and().delete().forPath("/yet/another/path")
                .and().commit();
    }

    /*
     * These next four methods show how to use Curator's transaction APIs in a
	 * more traditional - one-at-a-time - manner
	 */
    public static CuratorTransaction startTransaction(CuratorFramework client) {
        // start the transaction builder
        return client.inTransaction();
    }

    public static CuratorTransactionFinal addCreateToTransaction(CuratorTransaction transaction) throws Exception {
        // add a create operation
        return transaction.create().forPath("/a/path", "some data".getBytes()).and();
    }

    public static CuratorTransactionFinal addDeleteToTransaction(CuratorTransaction transaction) throws Exception {
        // add a delete operation
        return transaction.delete().forPath("/another/path").and();
    }

    public static void commitTransaction(CuratorTransactionFinal transaction) throws Exception {
        // commit the transaction
        transaction.commit();
    }
}
