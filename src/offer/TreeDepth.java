package offer;


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
        int count = 0;
        int nextCount = 1;//下一层的数量
        int depth = 0;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            count++;

            if (node.left != null){
                queue.add(node.left);
            }

            if (node.right != null){
                queue.add(node.right);
            }

            if (count == nextCount){
                depth++;
                count = 0;
                nextCount = queue.size();
            }
        }
        return depth;
    }
}
