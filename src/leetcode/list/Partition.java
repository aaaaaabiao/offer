package leetcode.list;

/**
 * @version: V1.0
 * @author: abiao
 * @className: Partition
 * @packageName: leetcode.list
 * @description: 将链表分为2个部分 link:https://leetcode.com/problems/partition-list/
 * @data: 2019/2/7
 **/
public class Partition {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);

        ListNode t1 = l1;
        ListNode t2 = l2;
        while (head != null) {
            if (head.val < x) {
                t1.next = head;
                t1 = t1.next;
            } else {
                t2.next = head;
                t2 = t2.next;
            }
            head = head.next;
        }

        t2.next = null;
        t1.next = l2.next;
        return l1.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(1);
        l1.next = l2;
        int a = 0;
    }
}
