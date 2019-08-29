package offer;

/**
 * @version: V1.0
 * @author: abiao
 * @className: FindFirstCommonNode
 * @packageName: offer
 * @description: 链表的第一个公共节点
 * @data: 2018/12/21
 **/
public class FindFirstCommonNode {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = 0;
        int len2 = 0;
        ListNode tmp1 = pHead1;
        ListNode tmp2 = pHead2;
        while (tmp1 != null){
            len1++;
            tmp1 = tmp1.next;
        }
        while (tmp2 != null){
            len2++;
            tmp2 = tmp2.next;
        }


        if (len1 > len2){
            int val = len1 - len2;
            while (val > 0){
                pHead1 = pHead1.next;
                val--;
            }

            while (pHead1 != null){
                if (pHead1 == pHead2){
                    return pHead1;
                }
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
        }else{
            int val = len2 - len1;
            while (val > 0){
                pHead2 = pHead2.next;
                val--;
            }

            while (pHead2 != null){
                if (pHead1 == pHead2){
                    return pHead1;
                }
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }

        }

        return null;
    }

    public ListNode findFirstCommonNode1(ListNode pHead1, ListNode pHead2){

        ListNode l1 = pHead1;
        ListNode l2 = pHead2;
        if (l1 == null || l2 == null) {
            return null;
        }
        while (l1 != l2){
            l1 = l1.next == null ? pHead2 : l1.next;
            l2 = l2.next == null ? pHead1 : l2.next;
        }
        return l1;
    }

}
