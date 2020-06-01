package com.tree.www.leetcode;

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
        ListNode preHead = new ListNode(0);
        ListNode temp = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return preHead.next;
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
