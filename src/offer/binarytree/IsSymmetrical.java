package offer.binarytree;
/**
 * @version: V1.0
 * @author: abiao
 * @className: IsSymmetrical
 * @packageName: offer
 * @description: 对称的二叉树
 * @data: 2019/1/10
 **/
public class IsSymmetrical {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return false;
        return core(pRoot.left,pRoot.right);
    }

    boolean core(TreeNode n1,TreeNode n2){
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        return (n1.val == n2.val) && core(n1.left,n2.right) && core(n1.right,n2.left);
    }
}
