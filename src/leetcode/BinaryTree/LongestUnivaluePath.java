package leetcode.BinaryTree;

/**
 ``````````````````````````````````题目描述```````````````````````````````````
 最长同值路径

 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 注意：两个节点之间的路径长度由它们之间的边数表示。
 ````````````````````````````````````例子`````````````````````````````````````
 输入:

    5
   / \
   4  5
  / \  \
 1  1  5
 输出:2
 ````````````````````````````````````链接`````````````````````````````````````
 https://leetcode-cn.com/problems/longest-univalue-path/
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：递归
 描述：如何求包含根节点的最大同值路径？
 如果根节点和父节点相同。则为max(root.left,root.right)+1
 如果根节点和父节点不同。则为0
 在递归的过程中找到max-value
 ````````````````````````````````````思考`````````````````````````````````````

 `````````````````````````````````````````````````````````````````````````````
 data：2019/3/29
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/

public class LongestUnivaluePath {

    private int maxL = 0;
    public int longestUnivaluePath(TreeNode root) {
        /**
         解题思路类似于124题, 对于任意一个节点, 如果最长同值路径包含该节点, 那么只可能是两种情况:
         1. 其左右子树中加上该节点后所构成的同值路径中较长的那个继续向父节点回溯构成最长同值路径
         2. 左右子树加上该节点都在最长同值路径中, 构成了最终的最长同值路径
         需要注意因为要求同值, 所以在判断左右子树能构成的同值路径时要加入当前节点的值作为判断依据
         **/
        if(root == null) return 0;
        getMaxL(root, root.val);
        return maxL;
    }

    private int getMaxL(TreeNode r, int val) {
        if(r == null) return 0;
        int left = getMaxL(r.left, r.val);
        int right = getMaxL(r.right, r.val);
        maxL = Math.max(maxL, left+right); // 路径长度为节点数减1所以此处不加1
        if(r.val == val) // 和父节点值相同才返回以当前节点所能构成的最长通知路径长度, 否则返回0
            return Math.max(left, right) + 1;
        return 0;
    }


    public static void main(String[] args){
        TreeNode root = TreeNode.deSerialStr2Tree("555###55###");
        LongestUnivaluePath longestUnivaluePath = new LongestUnivaluePath();
        System.out.println(longestUnivaluePath.longestUnivaluePath(root));
    }
}
