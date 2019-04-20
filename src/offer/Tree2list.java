package offer;

/**
 ``````````````````````````````````题目描述```````````````````````````````````
 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 ````````````````````````````````````例子`````````````````````````````````````

 ````````````````````````````````````链接`````````````````````````````````````
 https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5?tpId=13&tqId=11179&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：二叉搜索树的中序遍历即为一个从小到大的排序序列
 描述：pre来代表前一个节点。中序遍历。更新pre。
      head代表第一个节点，
 ````````````````````````````````````思考`````````````````````````````````````

 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/5
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
public class Tree2list {

    TreeNode pre = null;
    TreeNode head = null;

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        inOrder(pRootOfTree);
        return head;
    }

    public void inOrder(TreeNode root){
        if (root == null) return;
        inOrder(root.left);
        root.left = pre;
        if (pre != null){
            pre.right = root;
        }
        pre = root;
        if (head == null){
            head = root;
        }
        inOrder(root.right);
    }
}
