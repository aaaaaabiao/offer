package offer.list;

import java.util.ArrayList;

public class PrintListFromTailToHead {


    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null){
            return new ArrayList<>();
        }
        ListNode head = null;
        //逆序数组
        while (listNode != null){
            ListNode tmp = listNode;
            listNode = listNode.next;
            tmp.next = head;
            head = tmp;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        while (head != null){
            ret.add(head.val);
            head = head.next;
        }
        return ret;
    }

    public ArrayList<Integer> recursive(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode == null) {
            return ret;
        }

        while (listNode != null) {
            ret.addAll(recursive(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }
}
