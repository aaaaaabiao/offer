package leetcode.list;

/**
 * @version: V1.0
 * @author: abiao
 * @className: ReverseBetween
 * @packageName: leetcode.list
 * @description: 反转链表2
 * @data: 2019/2/12
 **/
public class ReverseBetween {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode p = new ListNode(-1);//代表m-1位置的节点
        ListNode pre = null;//代表第m位置的节点。
        ListNode l = head;
        int c = 1;
        while (l != null){
            if (c > n) break;
            ListNode tmp = l;
            if (c == m){
                pre = l;
            }
            if (m > 1 && c == m-1){
                p = tmp;
            }
            l = l.next;
            if (c >= m && c <= n){
                pre.next = tmp.next;
                tmp.next = p.next;
                p.next = tmp;
            }
            c++;
        }
        return head;
    }


    public static ListNode reverseBetween1(ListNode head, int m, int n){
        ListNode dumb = new ListNode(0);
        dumb.next = head;
        ListNode p = head;
        int c = 1;
        ListNode pre = dumb;
        ListNode post = p.next;
        while (p != null){
            if (c == n) break;
            ListNode next = p.next;
            if (c < m){
                pre = p;
            }
            c++;
            p = next;
            post = p.next;
        }
        p = pre.next;
        ListNode l = p.next;
        p.next = post;
        for (int i = m; i < n; i++){
            ListNode tmp = l.next;
            l.next = p;
            p = l;
            l = tmp;
        }

        pre.next = p;

        return dumb.next;
    }


    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode l = reverseBetween1(l1,1,5);

        int a = 0;
    }
}
