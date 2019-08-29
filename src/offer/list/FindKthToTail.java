package offer.list;

/**
 ``````````````````````````````````题目描述```````````````````````````````````
 输入一个链表，输出该链表中倒数第k个结点。
 ````````````````````````````````````例子`````````````````````````````````````
 
 ````````````````````````````````````链接`````````````````````````````````````
 https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&tqId=11167&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking

 ``````````````````````````````````解题思路```````````````````````````````````
 方法：
 描述：
 ````````````````````````````````````思考`````````````````````````````````````
 
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/4
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
public class FindKthToTail {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode ffindKthToTail(ListNode head,int k) {
        ListNode p1 = head;
        ListNode p2 = head;
        int c = 0;

        while (c < k && p1 != null){
            p1 = p1.next;
            c++;
        }

        if (p1 == null && k == c) return head;
        if (k > c) return null;
        while (p1 != null){
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;
    }

    public static ListNode ffindKthToTail2(ListNode head,int k) {
        ListNode p1 = head;
        ListNode p2 = head;
        int i = 0;
        for (; p1 != null; i++){
            if (i >= k){
                p2 = p2.next;
            }
            p1 = p1.next;
        }
        return k > i ? null : p2;
    }


    public static ListNode ffindKthToTail3(ListNode head,int k) {
        ListNode d = new ListNode(0);
        d.next = head;
        ListNode l1 = d;
        ListNode l2 = d;
        while (k > 0 && l1 != null){
            l1 = l1.next;
            k--;
        }
        if (k >= 0 && l1 == null) return null;
        while (l1 != null){
            l1 = l1.next;
            l2 = l2.next;
        }
        return l2;
    }
     public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
         ListNode listNode2 = new ListNode(2);
         ListNode listNode3 = new ListNode(3);
         ListNode listNode4 = new ListNode(4);
         ListNode listNode5 = new ListNode(5);

         listNode1.next = listNode2;
         listNode2.next = listNode3;
         listNode3.next = listNode4;
         listNode4.next = listNode5;

         ListNode ret = FindKthToTail.ffindKthToTail2(listNode1,5);
         int a = 0;
     }
}
