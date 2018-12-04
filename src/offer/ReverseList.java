package offer;

public class ReverseList {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode p = head;
        head = head.next;
        p.next = null;
        while (head != null){
            ListNode q = head;
            head = head.next;
            q.next = p;
            p = q;
        }
        return p;
    }

    public static void main(String[] args){
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);

        p1.next = p2;
        p2.next = p3;
        p3.next = p4;

        ReverseList.reverseList(p1);
    }
}
