package com.tree.www.leetCode;

import java.util.Arrays;

/**
 * 合并k个链表
 * <p>
 * Created by pysh on 2019-05-14.
 */
public class MergeKList {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        int mid = lists.length / 2;

        ListNode[] l1 = Arrays.copyOf(lists, mid);
        ListNode[] l2 = Arrays.copyOfRange(lists, mid, lists.length);
        return merge2Lists(mergeKLists(l1), mergeKLists(l2));
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head;
        if (l1.val <= l2.val) {
            head = l1;
            head.next = merge2Lists(l1.next, l2);
        } else {
            head = l2;
            head.next = merge2Lists(l1, l2.next);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        ListNode[] listNodes = {node1, node2, node3};

        ListNode result = new MergeKList().mergeKLists(listNodes);
        do {
            System.out.print(result.val + ",");
            result = result.next;
        } while (result != null);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
