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
}
