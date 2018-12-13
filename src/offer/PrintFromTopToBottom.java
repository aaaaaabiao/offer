package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @version: V1.0
 * @author: abiao
 * @className: PrintFromTopToBottom
 * @packageName: offer
 * @description: 从上往下打印出二叉树的每个节点，同层节点从左至右打印
 * 思路：用队列实现
 * @data: 2018/12/13
 **/
public class PrintFromTopToBottom {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (root == null) return ret;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            ret.add(node.val);
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
        return ret;
    }
}
