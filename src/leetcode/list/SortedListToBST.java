package leetcode.list;

/**
 * @version: V1.0
 * @author: abiao
 * @className: SortedListToBST
 * @packageName: leetcode.list
 * @description: 将排序链表转成平衡二叉树
 * @data: 2019/2/12
 **/
public class SortedListToBST {

     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public TreeNode sortedListToBST(ListNode head) {
         if (head == null) return null;
         return toBST(head,null);
    }


    public TreeNode toBST(ListNode start, ListNode end){
        ListNode p1 = start;
        ListNode p2 = start;
        if (start == end){
            return null;
        }
        while (p2 != end && p2.next != end){
            p1 = p1.next;
            p2 = p2.next.next;
        }

        TreeNode root = new TreeNode(p1.val);

        root.left = toBST(start,p1);
        root.right = toBST(p1.next,end);
        return root;
    }
}
