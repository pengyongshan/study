package com.tree.www.leetcode;

import java.util.HashMap;

/**
 * 146. LRU缓存机制
 * <p>
 * Created by pysh on 2020-05-25.
 */
public class LRUCache {

    private HashMap<Integer, LinkedNode> CACHE = new HashMap<>();

    private int capacity;
    private LinkedNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new LinkedNode();
        tail = new LinkedNode();

        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        final LinkedNode node = CACHE.get(key);
        if (node != null) {
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (value <= 0) {
            return;
        }
        LinkedNode node = CACHE.get(key);
        if (node == null) {
            node = new LinkedNode(key, value);
            CACHE.put(key, node);
        } else {
            node.val = value;
            removeNode(node);
        }
        addToHead(node);
        if (CACHE.size() > capacity) {
            removeTail();
        }
    }

    private void removeTail() {
        LinkedNode toDel = tail.pre;
        CACHE.remove(toDel.key);
        removeNode(toDel);
    }

    private void removeNode(LinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addToHead(LinkedNode node) {
        node.next = head.next;
        node.pre = head;
        node.next.pre = node;
        head.next = node;
    }

    private void moveToHead(LinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    class LinkedNode {
        private int key;
        private int val;
        private LinkedNode pre;
        private LinkedNode next;

        public LinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public LinkedNode() {
        }
    }
}
