package offer.binarytree;

import java.util.Stack;

/**
 * @version: V1.0
 * @author: abiao
 * @className: Mirror
 * @packageName: offer
 * @description: 操作给定的二叉树，将其变换为源二叉树的镜像。
 * @data: 2018/12/10
 **/
public class Mirror {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public static void mirror(TreeNode root) {

        if (root == null) return;
        if (root.left == null && root.right == null) return;

        mirror(root.left);
        mirror(root.right);

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    /**
     * 非递归的方式实现
     * */
    public static void mirrorV1(TreeNode root) {
        if (root == null) {
            return ;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                TreeNode tmp = root.left;
                root.left = root.right;
                root.right = tmp;
                root = root.left;
            }

            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                root = node.right;
            }
        }
    }





    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);


        n1.left = n2;
        n2.left = n3;
        n2.right = n4;

        n1.right = n5;
        n5.left = n6;
        n5.right = n7;

        n6.right = n8;

        mirrorV1(n1);

        System.out.println(n1.left.val);
    }
}
