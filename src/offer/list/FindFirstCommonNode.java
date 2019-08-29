package offer.list;



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
        ListNode l1 = pHead1;
        ListNode l2 = pHead2;
        while (l1 != null && l2 != null){
            if (l1 == l2){
                return l2;
            }
            l1 = l1 == null ? pHead2 : l1;
            l2 = l2 == null ? pHead1 : l2;
        }
        return null;
    }


    public static void main(String[] args){

    }
}
