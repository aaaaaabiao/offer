package leetcode.BinaryTree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * @version: V1.0
 * @author: abiao
 * @className: LevelOrder
 * @packageName: leetcode.BinaryTree
 * @description: 树层次遍历序列
 * @data: 2019/2/21
 **/
public class LevelOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        int nextCount = 1;//下一层的数量
        List<Integer> ls = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            count++;
            ls.add(node.val);
            if (node.left != null){
                queue.add(node.left);
            }

            if (node.right != null){
                queue.add(node.right);
            }

            if (count == nextCount){
                ret.add(new ArrayList<>(ls));
                ls.clear();
                count = 0;
                nextCount = queue.size();
            }
        }

        return ret;
    }
}
