package leetcode.list;

/**
 * @version: V1.0
 * @author: abiao
 * @className: AddTwoNumbers
 * @packageName: leetcode.list
 * @description: 两数相加
 * @data: 2019/2/12
 **/
public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dump = new ListNode(0);
        ListNode node = dump;
        int p = 0;

        while(l1 != null || l2 != null){
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + p;
            int val = sum % 10;
            p = sum >= 10 ? 1 : 0;
            ListNode l = new ListNode(val);
            node.next = l;
            node = node.next;
            l1 = (l1 != null ? l1.next : null);
            l2 = (l2 != null ? l2.next : null);
        }

        if(p == 1){
            node.next = new ListNode(1);
        }
        return dump.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(3);
        l1.next = l2;
        ListNode p1 = new ListNode(0);
        int a = 0;
    }
}
