package offer;
/**
 * @version: V1.0
 * @author: abiao
 * @className: GetNextInTree
 * @packageName: offer
 * @description: 给定一个二叉树和其中的一个结点，
 *               请找出中序遍历顺序的下一个结点并且返回。
 *               注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针
 *               1.右子树为空,下一个节点为右子树最左节点
 *               2.右子树为空
 *                  1.如果是父节点的左子树，则下一个节点其是父节点
 *                  2.如果是父节点的右子树，则向上找到第一个为左节点的节点
 * @data: 2019/1/8
 **/
public class GetNextInTree {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
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
}
