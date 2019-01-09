package offer;

import java.util.ArrayList;
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

        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (pRoot == null) return new ArrayList<>();
        LinkedList<TreeNode> queue  = new LinkedList<>();
        queue.push(pRoot);
        int count = 1;
        int layer = 1;
        int num = 0;
        ArrayList<Integer> arrayList = new ArrayList();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            arrayList.add(node.val);
            count--;
            if (node.left != null){
                queue.offer(node.left);
                num++;
            }
            if (node.right != null){
                queue.offer(node.right);
                num++;
            }
            if (count == 0){
                if (layer % 2 == 0){
                    int i = 0;
                    int j = arrayList.size()-1;
                    while (i < j){
                        int tmp = arrayList.get(i);
                        arrayList.set(i,arrayList.get(j));
                        arrayList.set(j,tmp);
                        i++;
                        j--;
                    }
                }
                ret.add(arrayList);
                arrayList = new ArrayList();
                count = num;
                num = 0;
                layer++;
            }
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
