package com.tree.www.leetcode;

/**
 * 对链表进行插入排序
 *
 * https://leetcode-cn.com/problems/insertion-sort-list/
 * <p>
 * Created by pysh on 11/20/20.
 */
public class Leetcode147 {

    public ListNode insertionSortList(ListNode head) {
        ListNode result = new ListNode(head.val);
        head = head.next;
        while (head != null) {
            result = sort(result, head.val);
            head = head.next;
        }
        return result;
    }

    private ListNode sort(ListNode result, int val) {
        ListNode toInsert = new ListNode(val);
        if (val < result.val) {
            toInsert.next = result;
            return toInsert;
        }
        ListNode pre = result;
        ListNode curr = result.next;
        while (curr != null) {
            if (val <= curr.val) {
                toInsert.next = curr;
                break;
            } else {
                pre = curr;
                curr = curr.next;
            }
        }
        pre.next = toInsert;
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        new Leetcode147().insertionSortList(head);
    }
}
