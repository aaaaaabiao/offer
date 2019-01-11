package offer;
/**
 * @version: V1.0
 * @author: abiao
 * @className: KthNode
 * @packageName: offer
 * @description: 二叉搜索树的第K个节点
 * @data: 2019/1/11
 **/

public class KthNode {

    private int index = 0;
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public TreeNode kthNode(TreeNode pRoot, int k) {
        if (pRoot != null){
            TreeNode left = kthNode(pRoot.left,k);
            if (left != null) return left;
            index++;
            if (k == index) return pRoot;
            TreeNode right = kthNode(pRoot.right,k);
            if (right != null) return right;
        }
        return null;
    }
    public static TreeNode order(TreeNode root){
        if (root == null) return null;
        TreeNode left = order(root.left);
        if (left != null) return left;
        System.out.println(root.val);
        if (root.val == 3) return root;
        TreeNode right = order(root.right);
        if (right != null) return right;
        return null;
    }

    public static void order1(TreeNode root){
        if (root == null) return;
        order1(root.left);
        System.out.println(root.val);
        order1(root.right);
    }


    public static void main(String[] args){
        TreeNode t1 = new TreeNode(6);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(8);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.right = t5;

        TreeNode ret = order(t1);

        int a = 0;

    }
}
