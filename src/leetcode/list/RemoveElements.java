package leetcode.list;

/**
 * @version: V1.0
 * @author: abiao
 * @className: RemoveElements
 * @packageName: leetcode.list
 * @description: 删除链表中指定元素
 * @data: 2019/2/12
 **/
public class RemoveElements {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    //这个题目一下几点
    //1.要有一个哨兵元素。要保存当前元素的前一个元素
    public ListNode removeElements(ListNode head, int val) {
        ListNode dumb = new ListNode(0);
        ListNode cur = head;
        ListNode pre = dumb;
        pre.next = cur;
        while (cur != null){
            ListNode next = cur.next;
            if (cur.val == val){
                pre.next = cur.next;
            }else {
                pre = pre.next;
            }
            cur = next;
        }
        return dumb.next;
    }
}
