package offer;
/**
 * @version: V1.0
 * @author: abiao
 * @className: TreeIsBalanced
 * @packageName: offer
 * @description: 判断一棵树是不是平衡二叉树
 * @data: 2018/12/24
 **/
public class TreeIsBalanced {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public boolean isBalanced(TreeNode root) {

        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        return isBalanced(root.left) && isBalanced(root.right)
                && Math.abs(left - right) <= 1;
    }

    public static int treeDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);

        return leftDepth > rightDepth ? leftDepth+1:rightDepth+1;
    }
}
