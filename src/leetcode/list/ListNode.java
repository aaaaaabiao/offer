package leetcode.list;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val){this.val = val;}


    public static ListNode creatList(int... vals){
        ListNode dump = new ListNode(0);
        ListNode node = dump;
        for (int val : vals){
            ListNode listNode = new ListNode(val);
            node.next = listNode;
            node = node.next;
        }
        return dump.next;
    }
}
