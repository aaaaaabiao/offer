package leetcode.list;

/**
 * @version: V1.0
 * @author: abiao
 * @className: SortList
 * @packageName: leetcode.list
 * @description: 链表排序
 * @data: 2019/2/8
 **/

public class SortList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode sortList(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }

        //1.找出中间节点

        ListNode p1 = head;
        ListNode p2 = head;
        ListNode pre = null;
        while (p2 != null && p2.next != null){
            pre = p1;
            p1 = p1.next;
            p2 = p2.next.next;
        }

        pre.next = null;
        //2.对左边部分排序
        ListNode left = sortList(head);
        //3.对右部分排序
        ListNode right = sortList(p1);
        //4.对左右部分merge操作
        return merge(left,right);
    }

    public static ListNode merge(ListNode l1,ListNode l2){
        ListNode dumb = new ListNode(0);
        ListNode p = dumb;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null){
            p.next = l1;

        }
        if (l2 != null){
            p.next = l2;

        }

        return dumb.next;
    }


    public static void main(String[] args){
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode res = sortList(l1);
        int a = 0;
    }
}
