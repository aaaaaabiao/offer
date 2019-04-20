package leetcode.BinaryTree;
import java.util.*;


/**
 ``````````````````````````````````题目描述```````````````````````````````````

 ````````````````````````````````````例子`````````````````````````````````````

 ````````````````````````````````````链接`````````````````````````````````````

 ``````````````````````````````````解题思路```````````````````````````````````
 方法：递归可以想象成一课递归树。在递归的过程中找到结果就需要不断的返回。参考isSearchTree和path
 描述：
 ````````````````````````````````````思考`````````````````````````````````````

 `````````````````````````````````````````````````````````````````````````````
 data：2019/3/31
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/


public class Solution {

    //求二叉树的深度
    public static int maxDepth(TreeNode root){
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;
    }


    //求二叉树的最小深度?
    public static int minDepth(TreeNode root){
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.min(left,right)+1;
    }

    //求二叉树中节点个数
    public static int count(TreeNode root){
        if (root == null) return 0;
        return count(root.left) + count(root.right) + 1;
    }

    //求二叉树中叶子节点的个数
    //左子树叶子节点的个数加上右子树叶子节点的个数
    public static int leafCount(TreeNode root){
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return leafCount(root.left) + leafCount(root.right);
    }

    //求二叉树第K层的个数
    //第K层的个数等于左子树第K-1层的个数+右子树第K-1层的个数，当K等于1的时候等于1
    public static int countOfKLevel(TreeNode root,int k){
        if (root == null || k < 1) return 0;
        if (k == 1) return 1;
        int left = countOfKLevel(root.left,k-1);
        int right = countOfKLevel(root.right,k-1);
        return left + right;
    }

    //判断平衡二叉树
    public static boolean isBanlance(TreeNode root){
        if (root == null) return true;
        return isBanlance(root.left) && isBanlance(root.right) && Math.abs(maxDepth(root.left)-maxDepth(root.right)) <= 1;
    }

    //判断一棵树是否是完全二叉树
    public static boolean isCompleteTreeNode(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean hasNoChild = false;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (hasNoChild){
                if (node.left != null || node.right != null){
                    return false;
                }
            }
            if (node.left != null && node.right != null){
                queue.add(node.left);
                queue.add(node.right);
            }else if (node.left != null && node.right == null){
                queue.add(node.left);
            }else if (node.left == null && node.right != null){
                return false;
            }else{
                hasNoChild = true;
            }
        }
        return true;
    }

    //判断两颗二叉树是否相同
    public static boolean isSame(TreeNode n1,TreeNode n2){
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        return n1.val == n2.val && isSame(n1.left,n2.left) && isSame(n1.right,n2.right);
    }

    //判断两颗二叉树是否互为镜像
    public static boolean isMirror(TreeNode n1,TreeNode n2){
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        return n1.val == n2.val && isSame(n1.left,n2.right) && isSame(n1.right,n2.right);
    }


    //求二叉树的最近公共祖先

    public static TreeNode getLastCommonParent(TreeNode root,TreeNode n1,TreeNode n2){
        if (findNode(root.left,n1)){
            if (findNode(root.right,n2)){
                return root;
            }else{
                return getLastCommonParent(root.left,n1,n2);
            }
        }else{
            if (findNode(root.left,n2)){
                return root;
            }else{
                return getLastCommonParent(root.right,n1,n2);
            }
        }
    }

    //求二叉树的最近公共祖先

    public static TreeNode getLastCommonParent1(TreeNode root,TreeNode n1,TreeNode n2){
        ArrayList<TreeNode> l1 = getPath(root,n1);
        ArrayList<TreeNode> l2 = getPath(root,n2);
        int len = Math.min(l1.size(),l2.size());
        for (int i = 0; i < len; i++){
            if (l1.get(i) != l2.get(i)){
                return l1.get(i-1);
            }
        }

        return null;


    }

    //查找一个节点是否在树中
    public static boolean findNode(TreeNode root,TreeNode node){
        if (root == null || node == null) return false;
        if (root == node) return true;
        return findNode(root.left,node) || findNode(root.right,node);
    }

    //求根节点到某个节点的距离
    public static int getDistanceFromRoot(TreeNode root,TreeNode node){
        if (root == null || node == null) return -1;
        if (root == node)return 0;
        if (findNode(root.left,node)){
            return getDistanceFromRoot(root.left,node)+1;
        }else if (findNode(root.right,node)){
            return getDistanceFromRoot(root.right,node)+1;
        }else{
            return -1;
        }
    }

    //根节点到某节点的路径
    public static ArrayList<TreeNode> getPath(TreeNode root, TreeNode t){
        ArrayList<TreeNode> ret = new ArrayList<>();
        path(ret,root,t);
        return ret;
    }

    public static boolean path(ArrayList<TreeNode> ret, TreeNode root, TreeNode t){
        if (root == null) return false;
        ret.add(root);
        if (root == t ) return true;
        if(path(ret,root.left,t)) return true;
        if(path(ret,root.right,t)) return true;
        ret.remove(ret.size() - 1);
        return false;
    }

    public static int StrToInt(String str) {
        if(str == null || str.length() == 0) return 0;
        boolean isNegative = str.charAt(0) == '-';
        int res = 0;
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(i == 0 && (ch == '+' || ch == '-')) continue;
            if(ch < '0' || ch > '9') return 0;
            int check = res;
            res = res * 10 + (ch - '0');
            int a = (res-(ch-'0')) / 10;
            System.out.println(a);
            if ((res-(ch-'0')) / 10 != check) return 0;
        }
        return isNegative ? -res:res;
    }

    private static  int pre = Integer.MIN_VALUE;

    //判断一课树是不是平衡二叉树
    public static boolean isSearchTree(TreeNode root){
        if (root == null) return true;
        if(!isSearchTree(root.left)) return false;
        if(root.val <= pre) return false;
        pre = root.val;
        if(!isSearchTree(root.right)) return false;
        return true;
    }

    public static void testIsSearchTree(){
        TreeNode root = TreeNode.deSerialStr2Tree("6 4 1 # # 5 # # 10 # # ");
        System.out.println(isSearchTree(root));
    }

    private static int index = 0;
    public static String Serialize(TreeNode root) {
        if(root == null) return "#";
        return root.val + Serialize(root.left) + Serialize(root.right);
    }
    public static TreeNode Deserialize(String str) {
        if(index >= str.length()) return null;
        char ch = str.charAt(index);
        index++;
        if(ch == '#')return null;
        TreeNode root = new TreeNode(ch - '0');
        root.left = Deserialize(str);
        root.right = Deserialize(str);
        return root;
    }

    public static void main(String[] args){
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node6 = new TreeNode(6);
//
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
////        node4.left = node6;
//        node2.right = node5;

//        System.out.println(maxDepth(node1));
//        System.out.println(minDepth(node1));
//        System.out.println(count(node1));
//        System.out.println(leafCount(node1));
//        System.out.println(countOfKLevel(node1,2));
//        System.out.println(isBanlance(node1));
//        System.out.println(isCompleteTreeNode(node1));
//        System.out.println(isSame(node1,node2));
//        System.out.println(isMirror(node1,node2));

//        TreeNode res = getLastCommonParent(node1,node4,node5);

//        nonRecursivePreOrder(node1);
//        nonRecursiveInOrder(node1);
//        nonRecursivePostOrder(node1);

//        System.out.println(getDistanceFromRoot(node1,node5));

//        System.out.println(StrToInt("2147483648"));
//        List<TreeNode> ret = getPath(node1,node2);
//        TreeNode t = getLastCommonParent1(node1,node4,node3);
//        int a;

//        StringBuilder sb = new StringBuilder();
//
//        System.out.println(Serialize(node1));
//        TreeNode root = Deserialize(Serialize(node2));
//        testIsSearchTree();
    }

}


