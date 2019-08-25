package offer.queue;
/**
 ``````````````````````````````````题目描述```````````````````````````````````
 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 ````````````````````````````````````例子`````````````````````````````````````

 ````````````````````````````````````链接`````````````````````````````````````
 https://www.nowcoder.com/practice/445c44d982d04483b04a54f298796288?tpId=13&tqId=11213&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：
 描述：用一个flag来记录是不是反转。每次遍历完一后取非(!),反转函数Collections.reverse(arrayList);
 ````````````````````````````````````思考`````````````````````````````````````

 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/4
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;


public class PrintZInTree {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public static ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        boolean flag = true;
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (pRoot == null) return ret;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()){
            ArrayList<Integer> arrayList = new ArrayList<>();
            int n = queue.size();
            while (n-- > 0){
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) queue.offer(treeNode.left);
                if (treeNode.right != null)queue.offer(treeNode.right);
                arrayList.add(treeNode.val);
            }
            if(!flag){
                Collections.reverse(arrayList);
            }
            flag = !flag;
            ret.add(arrayList);
        }
        return ret;
    }

    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;

        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;

        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;

        ArrayList ret = print(treeNode);

        int a = 0;
    }
}
