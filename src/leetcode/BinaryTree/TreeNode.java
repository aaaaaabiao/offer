package leetcode.BinaryTree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode(int x){val = x;}

    /*
    * 反序列化二叉树
    * 例：124###3##先序遍历序列,null为#。
    *       1
    *     /   \
    *    2     3
    *   /
    *  4
    *
    * */
    private static int index = 0;
    private static TreeNode deserialization(String decode){
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

    public static TreeNode deSerialStr2Tree(String decode){
        TreeNode root = deserialization(decode);
        index = 0;
        return root;
    }

    public static void main(String[] args){
        TreeNode root = deSerialStr2Tree("1 2 4 # # # 3 # #");
        String res = Serialize(root);
        System.out.println(res);
        int a = 0;
    }
}
