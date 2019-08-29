package offer.backtracing;


import java.util.*;

/**
 ``````````````````````````````````题目描述```````````````````````````````````
 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 (注意: 在返回值的list中，数组长度大的数组靠前)
 ````````````````````````````````````例子`````````````````````````````````````
 
 ````````````````````````````````````链接`````````````````````````````````````
 https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=13&tqId=11177&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：回溯。
 描述：找到路径的条件为target==0 && root是叶子节点
 ````````````````````````````````````思考`````````````````````````````````````
 
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/4
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
public class FindPath {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();

        backtracing(ret,ls,root,target);
        return ret;
    }
    public void backtracing(ArrayList<ArrayList<Integer>> ret,List<Integer> ls,TreeNode root, int target){
        if (root == null) return;
        ls.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null){
            ret.add(new ArrayList<>(ls));
        }else {
            backtracing(ret,ls,root.left,target);
            backtracing(ret,ls,root.right,target);
        }
        ls.remove(ls.size()-1);
    }

    public static void main(String[] args){
        FindPath findPath = new FindPath();
        FindPath.TreeNode treeNode = findPath.new TreeNode(10);
        FindPath.TreeNode left = findPath.new TreeNode(5);
        FindPath.TreeNode right = findPath.new TreeNode(12);

        FindPath.TreeNode ll = findPath.new TreeNode(4);
        FindPath.TreeNode lr = findPath.new TreeNode(7);

        treeNode.left = left;
        treeNode.right = right;

        left.left = ll;
        left.right = lr;



        List ret = findPath.findPath(treeNode,22);

        int a = 0;
    }
}

