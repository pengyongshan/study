package com.tree.www.leetcode;

/**
 * K 个一组翻转链表
 * <p>
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * <p>
 * Created by pysh on 2020-05-16.
 */
public class ReverseKGroup {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        //head.next.next.next.next.next.next = new ListNode(7);
        ListNode result = new ReverseKGroup().reverseKGroup(head, 2);
    }

    /**
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     * k 是一个正整数，它的值小于或等于链表的长度。
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * <p>
     * 你的算法只能使用常数的额外空间。
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode current = head;
        while (current != null) {
            len++;
            current = current.next;
        }
        return reverse(head, k, len / k);
    }

    public ListNode reverse(ListNode head, int k, int times) {
        ListNode result = null, curr = head, last = head;
        int size = k;
        for (int i = 0; i < times; i++) {
            ListNode prev = null, temp = curr;
            while (size-- != 0) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            if (i == 0) {
                result = prev;
            } else {
                last.next = prev;
                last = temp;
            }
            size = k;
        }
        last.next = curr;
        return result;
    }
}
