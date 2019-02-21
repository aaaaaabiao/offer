package leetcode.BinaryTree;
/**
 * @version: V1.0
 * @author: abiao
 * @className: MaxDepth
 * @packageName: leetcode.BinaryTree
 * @description: 树的深度
 * @data: 2019/2/21
 **/
public class MaxDepth {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return l > r ? l+1:r+1;
    }
}
