package leetcode.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 ``````````````````````````````````题目描述```````````````````````````````````
 树的非递归遍历：先序，中序，后序
 ````````````````````````````````````例子`````````````````````````````````````

 ````````````````````````````````````链接`````````````````````````````````````
 https://leetcode-cn.com/problems/binary-tree-inorder-traversal/submissions/
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：用一个栈来实现。
 描述：用root来表示表示下一次进栈的节点。若为null就不进栈。
 ````````````````````````````````````思考`````````````````````````````````````
 root != null代表还有节点没有遍历完。
 !stack.isEmpty()代表还有节点没有输出完。
 后序遍历的时候需要判断栈顶元素的右节点有没有访问完。
 `````````````````````````````````````````````````````````````````````````````
 data：2019/3/31
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
public class Traversal {
    //非递归先序遍历二叉树
    public static void nonRecursivePreOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack();
        //一直变换root
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                System.out.println(root.val);
                root = root.left;
            }

            if (!stack.isEmpty()){
                TreeNode node = stack.pop();
                root = node.right;
            }
        }
    }

    //非递归中序遍历
    public static void nonRecursiveInOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }

            if (!stack.isEmpty()){
                TreeNode node = stack.pop();
                System.out.println(node.val);
                root = node.right;
            }
        }
    }

    //非递归后续遍历
    public static void nonRecursivePostOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack();
        //最后一个访问的节点
        TreeNode lastVisit = null;
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.peek();
            //如果右子树为空或者右子树已经访问过了。就可以出栈,否则先遍历右子树
            if (!stack.isEmpty() && (node.right == null || node.right == lastVisit)){
                TreeNode t = stack.pop();
                System.out.println(t.val);
                lastVisit = node;
            }else{
                root = node.right;
            }
        }
    }


    public static void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.left);

            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
        }
    }

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);


        n1.left = n2;
        n2.left = n3;
        n2.right = n4;

        n1.right = n5;
        n5.left = n6;
        n5.right = n7;

        n6.right = n8;
        nonRecursivePostOrder(n1);
    }
}
