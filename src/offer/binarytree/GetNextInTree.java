package offer.binarytree;
/**
 * @version: V1.0
 * @author: abiao
 * @className: GetNextInTree
 * @packageName: offer
 * @description: 给定一个二叉树和其中的一个结点，
 *               请找出中序遍历顺序的下一个结点并且返回。
 *               注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针
 *               1.右子树为空,下一个节点为右子树最左节点。左中（左中右）
 *               2.右子树为空：
 *                  1.如果是父节点的左子树，则下一个节点其是父节点。（左中x）中右
 *                  2.如果是父节点的右子树，则向上找到第一个为左节点不为空的父节点。（左中（左中x）中
 * @data: 2019/1/8
 **/

/**
 ``````````````````````````````````题目描述```````````````````````````````````
 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 ````````````````````````````````````例子`````````````````````````````````````
        1
       / \
      2  3
    / \
   4   5
  /
 6

 中序遍历的序列为:6 4 2 5 1 3
 先序遍历的序列为:1,2,4,6,5,3
 后序遍历的序列为:6,4,5,6,3,1
 ````````````````````````````````````链接`````````````````````````````````````
 https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&tqId=11210&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking

 ``````````````````````````````````解题思路```````````````````````````````````
 方法：
 描述：
 1.右子树为空,下一个节点为右子树最左节点
 2.右子树为空
    1.如果是父节点的左子树，则下一个节点其是父节点
    2.如果是父节点的右子树，则向上找到第一个为左节点的节点。
 如果是最
 ````````````````````````````````````思考`````````````````````````````````````
 先序遍历的下一个节点呢？
 先序遍历：中左右
    1.如果节点的有左子树，下一个为左子树
    2.如果节点有右子树，下一个节点为右子树
    3.中（中xx）右，parent.right == null 继续找
        中左（中xx）parent.right == parent 继续找
    向上找，找到第一个有右子树的节点的右子树。

 后序遍历的下一个节点呢？
 后序遍历：左右中
 两种情况：
 1.（左右中）右中
 如果位于父节点的左子树
    1.如果父节点右子树为空,那么下一个节点为父节点
    2.如果父节点左子树不空，那么下一个节点为父节点右子树的最左节点（左右中）（左中右）中
 2.左(左右中)中。
 如果位于父节点的右子树，那么下一个节点为父节点。
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/3
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
public class GetNextInTree {

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    //得到中序遍历的下一个节点
    public static TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        TreeLinkNode next = null;
        if (pNode.right != null){
            //右子树不为空,下一个节点为右子树最左的节点
            TreeLinkNode node = pNode.right;
            while (node.left != null){
                node = node.left;
            }
            next = node;

        }else{
            //如果右子树为空
            TreeLinkNode cur = pNode;
            TreeLinkNode parent = pNode.next;

            while (parent != null && parent.right == cur){
                //如果是父节点的右子树，需要向上找到第一个有左子树的节点
                cur = parent;
                parent = parent.next;
            }
            //如果是父节点的左节点，那么父节点就是其下一个节点
            next = parent;
        }

        return next;
    }

    //得到先序遍历的下一个节点
    public static TreeLinkNode GetNextpre(TreeLinkNode pNode) {
        if(pNode.left != null) return pNode.left;
        if(pNode.right != null) return pNode.right;
        TreeLinkNode parent = pNode.next;
        while (parent != null && (parent.right == null || parent.right == pNode)) parent = parent.next;
        if (parent == null) return null;
        return parent.right;
    }


    //得到后序遍历的先
    public static TreeLinkNode GetnextPost(TreeLinkNode pNode){
        TreeLinkNode parent = pNode.next;
        if(parent == null) return null;
        if(parent.left == pNode){
            if(parent.right == null){
                return parent;
            }else{
                TreeLinkNode node = parent.right;
                while (node.left != null) node = node.left;
                return node;
            }
        }else{
            return parent;
        }
    }


    public static void test(){
        TreeLinkNode r1 = new TreeLinkNode(1);
        TreeLinkNode r2 = new TreeLinkNode(2);
        TreeLinkNode r3 = new TreeLinkNode(3);
        TreeLinkNode r4 = new TreeLinkNode(4);
        TreeLinkNode r5 = new TreeLinkNode(5);
        TreeLinkNode r6 = new TreeLinkNode(6);

        r1.left = r2;
        r1.right = r3;
        r2.next = r1;
        r3.next = r1;

        r2.left = r4;
        r2.right = r5;
        r4.next = r2;
        r5.next = r2;

        r4.left = r6;
        r6.next = r4;

//        preOrder(r1);
//        inOrder(r1);
        postOrder(r1);


    }


    public static void preOrder(TreeLinkNode root){
        if(root == null) return ;
        TreeLinkNode node = GetNextpre(root);
        System.out.println(node == null ? "Null" : node.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(TreeLinkNode root){
        if(root == null) return ;
        inOrder(root.left);
        TreeLinkNode node = GetNext(root);
        System.out.println(node == null ? "Null" : node.val);
        inOrder(root.right);
    }


    public static void postOrder(TreeLinkNode root){
        if(root == null) return ;
        postOrder(root.left);
        postOrder(root.right);
        TreeLinkNode node = GetnextPost(root);
        System.out.println(node == null ? "Null" : node.val);
    }


    public static void main(String[] args){
        test();
    }
}
