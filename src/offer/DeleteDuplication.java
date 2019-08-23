package offer;


import java.util.concurrent.ConcurrentHashMap;

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
        //边界条件
        if (pHead == null) return null;
        //当前节点
        ListNode cur = pHead;
        //前一个节点
        ListNode pre = new ListNode(0);
        pre.next = cur;
        //后一个节点
        ListNode post = cur.next;

        while (cur != null && (post = cur.next) != null){
            if (cur.val != post.val){
                pre = cur;
            }else {
                //找到第一个与当前节点不相等的节点
                while (post != null && cur.val == post.val){
                    post = post.next;
                }


                if (pre.next == pHead){
                    //说明第一个元素就是重复元素
                    pHead = post;
                }

                pre.next = post;
            }

            cur = post;
        }

        return pHead;
    }

    //递归解法
    public static ListNode deleteDuplication1(ListNode pHead) {

        if (pHead == null || pHead.next == null) return pHead;
        ListNode next = pHead.next;
        if (pHead.val == pHead.val){
            while (next != null && pHead.val == next.val){
                next = next.next;
            }
            return deleteDuplication1(next);
        }else{
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
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
        ConcurrentHashMap map = new ConcurrentHashMap();
        ListNode res = deleteDuplication1(l1);

        int a = 0;

    }
}
