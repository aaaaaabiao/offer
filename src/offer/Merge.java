package offer;
/**
 * @version: V1.0
 * @author: abiao
 * @className: Merge
 * @packageName: offer
 * @description: 合并两个单调递增的链表
 * @data: 2018/12/4
 **/
public class Merge {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode res = new ListNode(0);
        ListNode p = res;
        while (true){
            if (list1 == null){
                p.next = list2;
                break;
            }
            if (list2 == null){
                p.next = list1;
                break;
            }

            if (list1.val > list2.val){
                p.next = list2;
                p = p.next;
                list2 = list2.next;
            }else if (list1.val < list2.val){
                p.next = list1;
                p = p.next;
                list1 = list1.next;
            }else {
                p.next = list2;
                p = p.next;
                list2 = list2.next;
                p.next = list1;
                p = p.next;
                list1 = list1.next;
            }
        }

        return res.next;
    }
}
