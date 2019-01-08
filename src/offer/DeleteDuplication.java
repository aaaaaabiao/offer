package offer;

/**
 * @version: V1.0
 * @author: abiao
 * @className: DeleteDuplication
 * @packageName: offer
 * @description: 删除链表中重复的元素
 * @data: 2019/1/8
 **/
public class DeleteDuplication {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) return null;
        ListNode cur = pHead;
        ListNode pre = new ListNode(0);
        pre.next = cur;
        ListNode post = cur.next;

        while (cur != null && (post = cur.next) != null){
            if (cur.val != post.val){
                pre = cur;
            }else {
                while (post != null && cur.val == post.val){
                    post = post.next;
                }

                if (pre.next == pHead){
                    pHead = post;
                }

                pre.next = post;
            }

            cur = post;
        }

        return pHead;
    }


    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(1);
        ListNode l6 = new ListNode(1);
        ListNode l7 = new ListNode(1);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = null;

        ListNode res = deleteDuplication(l1);

        int a = 0;

    }
}
