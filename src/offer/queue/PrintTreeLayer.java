package offer.queue;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 ``````````````````````````````````题目描述```````````````````````````````````
 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 ````````````````````````````````````例子`````````````````````````````````````

 ````````````````````````````````````链接`````````````````````````````````````
 https://www.nowcoder.com/practice/445c44d982d04483b04a54f298796288?tpId=13&tqId=11213&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：树的层次遍历
 描述：用队列来实现树的层次遍历
 ````````````````````````````````````思考`````````````````````````````````````
 如何判断每一层的节点？
 得到队列的大小n，每次连续出n个元素。对应的就是处理完一层。
 这题好像没有要判断在那一层？
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/4
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
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
        while (!queue.isEmpty()){
            ArrayList<Integer> arrayList = new ArrayList<>();
            int n = queue.size();
            while (n-- > 0){
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) queue.offer(treeNode.left);
                if (treeNode.right != null)queue.offer(treeNode.right);
                arrayList.add(treeNode.val);
            }
            ret.add(arrayList);
        }
        return ret;
    }
}
