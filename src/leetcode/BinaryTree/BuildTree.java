package leetcode.BinaryTree;
/**
 * @version: V1.0
 * @author: abiao
 * @className: BuildTree
 * @packageName: leetcode.BinaryTree
 * @description: 重建二叉树
 * @data: 2019/2/18
 **/
public class BuildTree {
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
          return core(preorder,0,preorder.length - 1,inorder,0,inorder.length-1);
    }

    public TreeNode core(int[] preorder,int s1,int e1,
                         int[] inorder,int s2,int e2){
          if (s1 > e1) return null;

          int p = s2;
          int val = preorder[s1];
          while (p <= e2){
              if (val == inorder[p]){
                  break;
              }
              p++;
          }

          int left = p-s2;
          TreeNode node = new TreeNode(val);
          node.left = core(preorder,s1+1,s1+left,inorder,s2,p-1);
          node.right = core(preorder,s1+left+1,e1,inorder,p+1,e2);

          return node;
    }
}
