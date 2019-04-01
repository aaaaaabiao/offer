package leetcode.BinaryTree;

/**
 ``````````````````````````````````题目描述```````````````````````````````````
 二叉树的最近公共祖先
 ````````````````````````````````````例子`````````````````````````````````````
 示例 1:

 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 输出: 3
 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 ````````````````````````````````````链接`````````````````````````````````````
 https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：p和q分别位root的两棵子树中。则root为最低公共祖先
 描述：
 ````````````````````````````````````思考`````````````````````````````````````
 递归树，找到p或q后往上传递（通过判断是不是null往上传递）。
 `````````````````````````````````````````````````````````````````````````````
 data：2019/3/31
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null) return root;
        if(left != null) return left;
        if(right != null) return right;
        return null;
    }
}
