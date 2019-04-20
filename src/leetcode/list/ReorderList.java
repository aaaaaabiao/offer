package leetcode.list;

public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null && head.next == null) return;;

        //使用快慢指针找到中点
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;

        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;

        //翻转后面一部分链表
        ListNode h2 = new ListNode(0);
        ListNode h = slow;
        while(h != null){
            ListNode next = h.next;
            h.next = h2.next;
            h2.next = h;
            h = next;
        }
        h2 = h2.next;


        //交叉插入

        ListNode dump = new ListNode(0);
        ListNode node = dump;
        while(head != null && h2 != null){
            node.next = head;
            node = node.next;
            head = head.next;

            node.next = h2;
            node = node.next;
            h2 = h2.next;
        }

        if(head != null) node.next = head;
        if(h2 != null) node.next = h2;
    }

    public static void main(String[] args){
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(ListNode.creatList(new int[]{1,2,3,4}));
    }
}
