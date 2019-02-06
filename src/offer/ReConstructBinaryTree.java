package offer;

import java.util.Stack;

/**
 * @version: V1.0
 * @author: abiao
 * @className: ReConstructBinaryTree
 * @packageName: offer
 * @description: 已知前序和中序，重构二叉树(前序确定根节点，递归的求左子树和右子树)
 * @data: 2018/11/20
 **/
public class ReConstructBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return ConstructCore(pre,0,pre.length-1,in,0,in.length-1);
    }


    private static TreeNode ConstructCore(int[] pre, int preStart,int preEnd,
                                   int[] in, int inStart,int inEnd){
        if (preStart > preEnd) return null;

        int rootValue = pre[preStart];
        TreeNode root = new TreeNode(rootValue);
        //以rootValue为中点，拆分成2个部分。
        int inRootIndex = inStart;
        while (in[inRootIndex] != rootValue){
            inRootIndex++;
        }
        int leftc = inRootIndex - inStart;
        root.left = ConstructCore(pre,preStart+1,preStart+leftc,in,inStart,inRootIndex-1);
        root.right = ConstructCore(pre,preStart+leftc+1,preEnd,in,inRootIndex+1,inEnd);

        return root;
    }

    public static void main(String[] args){
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode root =  reConstructBinaryTree(pre,in);
        int a = 0;
    }
}
