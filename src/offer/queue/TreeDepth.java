package offer.queue;

/**
 ``````````````````````````````````题目描述```````````````````````````````````
 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 ````````````````````````````````````例子`````````````````````````````````````
 
 ````````````````````````````````````链接`````````````````````````````````````
 https://www.nowcoder.com/practice/435fb86331474282a3499955f0a41e8b?tpId=13&tqId=11191&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：递归或层次遍历
 描述：
 ````````````````````````````````````思考`````````````````````````````````````
 递归的过程想象成一棵树。
 1.一种是找到某个点，然后一层一层返回
 2.每个节点都有返回值。可以将这个返回值一层一层的累计上去。这个时候要遍历所有的节点。
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/6
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
import java.util.LinkedList;
import java.util.Queue;

public class TreeDepth {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    //递归
    public static int treeDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);

        return leftDepth > rightDepth ? leftDepth+1:rightDepth+1;
    }

    //非递归
    //用队列层次遍历，用nextCount记录每一次的节点数。
    public static int treeDepthV2(TreeNode root){
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
