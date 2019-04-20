package leetcode.list;

public class SwapPairs {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        ListNode d1 = new ListNode(0);
        ListNode d2 = new ListNode(0);
        ListNode l1 = d1;
        ListNode l2 = d2;
        boolean flag = true;
        while (head != null) {
            if (flag) {
                l1.next = head;
                l1 = l1.next;
            } else {
                l2.next = head;
                l2 = l2.next;
            }
            flag = !flag;
            head = head.next;
        }

        if (l1 != null){
            l1.next = null;
        }

        if(l2 != null){
            l2.next = null;
        }
        flag = true;
        d1 = d1.next;
        d2 = d2.next;
        ListNode d = new ListNode(0);
        ListNode l = d;
        while (d1 != null && d2 != null) {
            if (flag) {
                l.next = d2;
                d2 = d2.next;
            } else {
                l.next = d1;
                d1 = d1.next;
            }
            l = l.next;
            flag = !flag;
        }

        if (d1 != null){
            l.next = d1;
        }
        if (d2 != null){
            l.next = d2;
        }
        return d.next;
    }


    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode ret = swapPairs(l1);
    }
}
