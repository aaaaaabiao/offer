package offer;

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

}
