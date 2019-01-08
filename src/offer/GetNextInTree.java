package offer;
/**
 * @version: V1.0
 * @author: abiao
 * @className: GetNextInTree
 * @packageName: offer
 * @description: 二叉树的下一个节点
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
                //如果是父节点的右子树，需要向上找到第一个为左节点的节点
                cur = parent;
                parent = parent.next;
            }
            //如果是父节点的左节点，那么父节点就是其下一个节点
            next = parent;
        }

        return next;
    }
}
