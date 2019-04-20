/**
 ``````````````````````````````````题目描述```````````````````````````````````
 给定一个二叉树，找出其最小深度。
 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 ````````````````````````````````````例子`````````````````````````````````````
 示例:

 给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
 /     \
 15     7
 返回它的最小深度  2
 ````````````````````````````````````链接`````````````````````````````````````
 https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/submissions/
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：先序遍历+全局min记录最小值。depth代表遍历的深度
 描述：
 ````````````````````````````````````思考`````````````````````````````````````
 
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/8
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
package leetcode.BinaryTree;

public class MinDepth {


    private int min = Integer.MAX_VALUE;
    public int run(TreeNode root) {
        if(root == null) return 0;
        backtracing(root,0);
        return min;
    }


    public void backtracing(TreeNode root,int depth){
        if(root == null) return;
        depth++;
        if(root.left == null && root.right == null){
            min = Math.min(min,depth);
            return;
        }
        backtracing(root.left,depth);
        backtracing(root.right,depth);
    }


    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if(root.left == null) return minDepth(root.right) + 1;
        if(root.right == null) return  minDepth(root.left) + 1;
        return Math.min(minDepth(root.left) + 1, minDepth(root.right) + 1);
    }


    public static void main(String[] args){
        MinDepth depth = new MinDepth();

        TreeNode root = TreeNode.deSerialStr2Tree("1 2 4 # # 5 # # 3 # #");

        System.out.println(depth.run(root));
    }
}
