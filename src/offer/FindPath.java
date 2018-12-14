package offer;


import java.time.temporal.ValueRange;
import java.util.*;

/**
 * @version: V1.0
 * @author: abiao
 * @className: FindPath
 * @packageName: offer
 * @description: 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径(数组长度大的数组靠前)
 * @data: 2018/12/14
 **/
public class FindPath {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target){
        ArrayList<ArrayList<Integer>> ret = core(root,target);

        Collections.sort(ret, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o2.size() - o1.size();
            }
        });

        return ret;
    }

    public ArrayList<ArrayList<Integer>> core(TreeNode root, int target) {

        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        //尾巴节点判断一下路径是否符合
        if (root.left == null && root.right == null){
            if (target == root.val) {
                ArrayList<Integer> array = new ArrayList<>();
                array.add(root.val);
                ret.add(array);
                return ret;
            }else {
                return null;
            }
        }

        if (root.left != null){
            ArrayList<ArrayList<Integer>> leftRet = core(root.left,target-root.val);
            if (leftRet != null){
                for (ArrayList<Integer> arrayList : leftRet){
                    arrayList.add(0,root.val);
                }
                ret.addAll(leftRet);
            }
        }
        if (root.left != null){
            ArrayList<ArrayList<Integer>> rightRet = core(root.right,target-root.val);
            if (rightRet != null){
                for (ArrayList<Integer> arrayList : rightRet){
                    arrayList.add(0,root.val);
                }
                ret.addAll(rightRet);
            }
        }
        return ret;
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

