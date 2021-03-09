package com.youngmate.leetcode;

/**
 * @author ZhaoYanqi
 * @date 2021/3/9 0009
 */
public class DemoAddTwoNumbers {
    /**
     * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
     * 
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 
     * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
     *
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode currentNode = null;
        int temp = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + temp;
            temp = sum / 10;
            sum = sum % 10;
            ListNode tempNode = new ListNode(sum);
            if (result == null) {
                result = tempNode;
                currentNode = tempNode;
            } else {
                currentNode.next = tempNode;
                currentNode = currentNode.next;
            }
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (temp > 0) {
            currentNode.next = new ListNode(temp);
        }
        return result;
    }

    /** Definition for singly-linked list. */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(6)));
        ListNode listNode = addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
