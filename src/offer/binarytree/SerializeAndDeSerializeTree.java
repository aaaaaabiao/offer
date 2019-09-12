package offer.binarytree;

/**
 ``````````````````````````````````题目描述```````````````````````````````````
 请实现两个函数，分别用来序列化和反序列化二叉树。
 ````````````````````````````````````例子`````````````````````````````````````

 ````````````````````````````````````链接`````````````````````````````````````
 https://www.nowcoder.com/practice/cf7e25aa97c04cc1a68c8f040e71fb84?tpId=13&tqId=11214&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：将二叉树按先序遍历的来序列化与反序列化，如
 1 2 3 # # # 40 # #
        1
      /  \
     2    40
    /
   3


 描述：序列化过程：空树用#表示，每个节点用" "分开。（因为可能节点可能占多位）。
      反序列化过程：
        1.用一个全局的index，代表处理到了序列化串的哪一位。
        2.通过以index开始的第一个空格位置来确定一个节点。（注意最后一个节点#后没有空格，代表最后一个节点了）
        3.按先序遍历的方式来还原二叉树。
 ````````````````````````````````````思考`````````````````````````````````````
 
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/5
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/

public class SerializeAndDeSerializeTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    private int index = 0;
    private TreeNode deserialization(String decode){
        if(index == decode.length()) return null;
        int spaceIndex = decode.indexOf(" ",index);
        spaceIndex = spaceIndex == -1 ? decode.length() : spaceIndex;
        String str = decode.substring(index,spaceIndex);
        index = spaceIndex+1;
        if(str.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(str));
        root.left = deserialization(decode);
        root.right = deserialization(decode);
        return root;
    }

    public static String Serialize(TreeNode root) {
        if(root == null) return "#";
        return root.val + " " +Serialize(root.left) +" "+Serialize(root.right);
    }
}
