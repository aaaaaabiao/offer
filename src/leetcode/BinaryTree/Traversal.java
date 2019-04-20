package leetcode.BinaryTree;

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
        TreeNode lastVisit = null;
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }

            TreeNode node = stack.peek();
            //如果右子树为空或者右子树已经访问过了。就可以出栈。
            if (!stack.isEmpty() && (node.right == null || node.right == lastVisit)){
                TreeNode t = stack.pop();
                System.out.println(t.val);
                lastVisit = node;
                root = null;
            }else{
                root = node.right;
            }
        }
    }
}
