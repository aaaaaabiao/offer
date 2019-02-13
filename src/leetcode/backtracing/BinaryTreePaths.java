package leetcode.backtracing;

import java.util.ArrayList;
import java.util.List;
/**
 * @version: V1.0
 * @author: abiao
 * @className: BinaryTreePaths
 * @packageName: leetcode.backtracing
 * @description: 树的路径
 * @data: 2019/2/13
 **/
public class BinaryTreePaths {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
      }
    public static List<String> binaryTreePaths(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        if (root.left == null && root.right == null){
            List<String> ret = new ArrayList<>();
            ret.add(root.val+"");
            return ret;
        }


        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);

        List<String> ret = new ArrayList();

        for (String str : left){
            str = root.val + "->" + str;
            ret.add(str);
        }

        for (String str : right){
            str = root.val + "->" + str;
            ret.add(str);
        }

        return ret;
    }


    public static void main(String[] args){
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.right = treeNode5;

        List<String> ret = binaryTreePaths(treeNode1);

        int a = 0;
    }
}
