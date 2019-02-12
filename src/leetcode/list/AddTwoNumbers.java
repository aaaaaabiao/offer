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
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //翻转l1,l2
        l1 = reverse(l1);
        l2 = reverse(l2);
        //res = l1+l2

        ListNode dumb = new ListNode(0);
        ListNode p = dumb;
        int n = 0;
        while (l1 != null && l2 != null){
            int sum = l1.val + l2.val + n;
            int val = 0;
            if (sum >= 10){
                val = sum - 10;
                n = 1;
            }else {
                val = sum;
                n = 0;
            }
            ListNode node = new ListNode(val);
            p.next = node;
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null){
            while (l1 != null){
                int sum = l1.val + n;
                int val = 0;
                if (sum >= 10){
                    val = sum - 10;
                    n = 1;
                }else {
                    val = sum;
                    n = 0;
                }
                ListNode node = new ListNode(val);
                p.next = node;
                p = p.next;
                l1 = l1.next;
            }
        }

        if (l2 != null){
            while (l2 != null){
                int sum = l2.val + n;
                int val = 0;
                if (sum >= 10){
                    val = sum - 10;
                    n = 1;
                }else {
                    val = sum;
                    n = 0;
                }
                ListNode node = new ListNode(val);
                p.next = node;
                p = p.next;
                l2 = l2.next;
            }
        }

        if (n == 1){
            p.next = new ListNode(1);
        }
        //翻转res
        return reverse(dumb.next);
    }


    //反转链表
    public  static ListNode reverse(ListNode head){
        if (head == null) return null;
        ListNode res = head;
        ListNode p = head.next;
        res.next = null;
        while (p != null){
            ListNode next = p.next;
            p.next = res;
            res = p;
            p = next;
        }

        return res;
    }


    public static void main(String[] args){
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(3);
        l1.next = l2;

        ListNode p1 = new ListNode(0);


        ListNode l = addTwoNumbers(l1,p1);
        int a = 0;
    }
}
