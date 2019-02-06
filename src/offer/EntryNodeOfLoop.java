package offer;

/**
 * @version: V1.0
 * @author: abiao
 * @className: EntryNodeOfLoop
 * @packageName: offer
 * @description: 链表中环的入口节点
 * @data: 2019/1/8
 **/
public class EntryNodeOfLoop {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode entryNodeOfLoop(ListNode pHead) {
        ListNode l1 = pHead;
        ListNode l2 = pHead;

        while (l2 != null && l2.next != null){
            l1 = l1.next;
            l2 = l2.next.next;
            if (l1 == l2){
                while (pHead != l1){
                    pHead = pHead.next;
                    l1 = l1.next;
                }
                return l1;
            }
        }
        return null;
    }


    public static ListNode foldList(ListNode head){
        ListNode p1 = head;
        ListNode p2 = head;

        //找出中点
        while (p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        if (p1 == p2){
            return head;
        }

        //翻转后半部分链表
        ListNode p = null;
        while (p1 != null){
            ListNode tmp = p1;
            p1 = p1.next;
            tmp.next = p;
            p = tmp;
        }

        ListNode h = head;
        ListNode res = new ListNode(-1);
        while (true){
            ListNode t1 = h;
            ListNode t2 = p;
            h = h.next;
            p = p.next;
            t1.next = t2;
            res.next = t1;
            res = t2;

            if (p.next == null){
                res.next = p;
                break;
            }
        }

        return head;
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

        ListNode res = foldList(l1);
        int a = 0;
    }
}
