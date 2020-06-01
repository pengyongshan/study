package com.tree.www.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by pysh on 2020-03-30.
 */
public class MaxQueue {

    public static void main(String[] args) {
        MaxQueue obj = new MaxQueue();
        obj.push_back(1);
        obj.push_back(2);
        obj.max_value();
        obj.pop_front();
        obj.pop_front();
        obj.pop_front();
        obj.max_value();
    }

    private Queue<Integer> queue;
    private Deque<Integer> deque;

    public MaxQueue() {
        this.queue = new LinkedBlockingQueue<>();
        this.deque = new ArrayDeque<>();
    }

    public int max_value() {
        if (deque.isEmpty()) return -1;
        return deque.getFirst();
    }

    public void push_back(int value) {
        while (!deque.isEmpty() && deque.getLast() < value) {
            deque.removeLast();
        }
        deque.addLast(value);
        queue.add(value);
    }

    public int pop_front() {
        if (queue.isEmpty())
            return -1;
        int ans = queue.poll();
        if (ans == deque.getFirst()) {
            deque.pop();
        }
        return ans;
    }
}
