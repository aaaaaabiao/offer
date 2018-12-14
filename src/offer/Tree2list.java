package offer;

/**
 * @version: V1.0
 * @author: abiao
 * @className: 将二叉搜索树转成一个排序的双向链表
 * @packageName: offer
 * @description: 
 * @data: 2018/12/14
 **/
public class Tree2list {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public TreeNode Convert(TreeNode pRootOfTree) {

        if (pRootOfTree == null) return null;

        if (pRootOfTree.left != null){
            TreeNode left = Convert(pRootOfTree.left);
            //找到最右节点
            while (left.right != null){
                left = left.right;
            }
            left.right = pRootOfTree;
            pRootOfTree.left = left;
        }

        if (pRootOfTree.right != null){
            TreeNode right = Convert(pRootOfTree.right);
            //找到最左节点
            while (right.left != null){
                right = right.left;
            }
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }

        while (pRootOfTree.left != null){
            pRootOfTree = pRootOfTree.left;
        }
        return pRootOfTree;
    }
}
