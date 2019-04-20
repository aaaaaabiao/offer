package offer;

/**
 ``````````````````````````````````题目描述```````````````````````````````````
 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 ````````````````````````````````````例子`````````````````````````````````````
 
 ````````````````````````````````````链接`````````````````````````````````````
 https://www.nowcoder.com/practice/ef068f602dde4d28aab2b210e859150a?tpId=13&tqId=11215&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：全局变量加中序遍历。
 描述：
 ````````````````````````````````````思考`````````````````````````````````````
 这种递归的过程可以想象成一棵递归树。
 结果就是在递归树中找到某个节点。
 找到了后就一层一层的返回。

 如果让他找到后一层一层返回呢？

 比如这一题就是，没有要求的节点就返回null。接着递归。
 找到了就一层一层的返回。没有继续递归了。
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/6
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/

public class KthNode {

    private int index = 0;
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public TreeNode kthNode(TreeNode pRoot, int k) {
        if (pRoot != null){
            TreeNode left = kthNode(pRoot.left,k);
            if (left != null) return left;
            index++;
            if (k == index) return pRoot;
            TreeNode right = kthNode(pRoot.right,k);
            if (right != null) return right;
        }
        return null;
    }
    public static TreeNode order(TreeNode root){
        if (root == null) return null;
        TreeNode left = order(root.left);
        if (left != null) return left;
        System.out.println(root.val);
        if (root.val == 3) return root;
        TreeNode right = order(root.right);
        if (right != null) return right;
        return null;
    }

    public static void order1(TreeNode root){
        if (root == null) return;
        order1(root.left);
        System.out.println(root.val);
        order1(root.right);
    }


    public static void main(String[] args){
        TreeNode t1 = new TreeNode(6);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(8);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.right = t5;

        TreeNode ret = order(t1);

        int a = 0;

    }
}
