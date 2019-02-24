package offer;
/**
 * @version: V1.0
 * @author: abiao
 * @className: HasSubtree
 * @packageName: offer
 * @description: 判断树的子结构
 * @data: 2019/2/24
 **/
public class HasSubtree {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        return hasSubTreeWithRoot(root1,root2) || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
    }

    public boolean hasSubTreeWithRoot(TreeNode root1, TreeNode root2){
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val != root2.val) return false;
        return hasSubTreeWithRoot(root1.left,root2.left) && hasSubTreeWithRoot(root1.right,root2.right);
    }
}
