package leetcode.list;

public class IsPalindrome {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) return true;
        //找到中点

        ListNode p1 = head;
        ListNode p2 = head;

        while (p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }

        //判断链表的元素是奇数个还是偶数个
        if (p2 != null){
            p1 = p1.next;
        }
        //翻转中点后的链表
        ListNode cur = p1;
        cur = cur.next;
        p1.next = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = p1;
            p1 = cur;
            cur = next;
        }

        //比较俩链表值是不是相等
        while (p1 != null){
            if (head.val != p1.val) return false;
            head = head.next;
            p1 = p1.next;
        }

        return true;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        System.out.println(isPalindrome(l1));
    }

}
