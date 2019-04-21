package leetcode.BinaryTree;

import java.util.Stack;

/**
 ``````````````````````````````````题目描述```````````````````````````````````
 将二叉树转换为链表
 ````````````````````````````````````例子`````````````````````````````````````
    1
   / \
  2   5
 / \   \
 3  4   6


 1
 \
  2
  \
   3
   \
    4
    \
     5
     \
      6
 ````````````````````````````````````链接`````````````````````````````````````
 https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：递归解法，后序遍历。非递归解法，使用栈。
 描述：
 ````````````````````````````````````思考`````````````````````````````````````

 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/21
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
public class Flatten {

    //非递归解法
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }

            if (!stack.isEmpty()){
                TreeNode node = stack.pop();
                TreeNode tmp = node.right;
                node.right = node.left;
                node.left = null;

                while(node.right != null) node = node.right;
                node.right = tmp;
                root = tmp;
            }
        }
    }


    //递归解法
    public void flatten1(TreeNode root) {
        if(root == null) return;
        flatten1(root.left);
        flatten1(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right != null) root = root.right;
        root.right = tmp;
    }

}
