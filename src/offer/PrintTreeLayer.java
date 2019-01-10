package offer;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 * @version: V1.0
 * @author: abiao
 * @className: PrintTreeLayer
 * @packageName: offer
 * @description: 把二叉树打印成多行
 * @data: 2019/1/10
 **/
public class PrintTreeLayer {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (pRoot == null) return ret;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        int count = 1;
        int n = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            count--;
            arrayList.add(treeNode.val);
            if (treeNode.left != null){
                queue.offer(treeNode.left);
                n++;
            }

            if (treeNode.right != null){
                queue.offer(treeNode.right);
                n++;
            }

            if (count == 0){
                ret.add(arrayList);
                arrayList = new ArrayList<>();
                count = n;
                n = 0;
            }
        }
        return ret;
    }
}
