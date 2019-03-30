package offer;
/**
 ``````````````````````````````````题目描述```````````````````````````````````
 二叉搜索树的后序遍历序列
 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 ````````````````````````````````````例子`````````````````````````````````````
 
 ````````````````````````````````````链接`````````````````````````````````````
 https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd?tpId=13&tqId=11176&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：后序遍历：左-右-中。二叉搜索树 左<中<右。 后序遍历能确定中间节点，即为最后的节点。
 描述：找到最后节点，将数组分为2个部分。分别对应左子树和右子树。
        如何分？从前往后遍历，找到一个大于最后节点的位置。即为分界点。
        左边为左子树。然后再判断一下右边的数组是否都大于最后节点。若是则为右子树。否则结果返回false。
        如果找到左子树和右子树再看左子树和右子树的后序遍历序列是否是二叉搜索树序列。
 ````````````````````````````````````思考`````````````````````````````````````
 递归函数的参数设置为。start：序列开始位置，end：序列结束位置。sequence：原序列。
 递归的终止条件为：当序列没有元素，只有一个元素，只有两个元素（两个元素肯定可以组成二叉搜索树）的时候返回true。

 注意递归到某一终止条件。从递归树往上一层一层返回。如果为true。就沿着递归树一直往下递归。如果为false。就沿着递归树往上返回。
 二叉搜索树的前序遍历序列？
 `````````````````````````````````````````````````````````````````````````````
 data：2019/3/30
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
public class VerifySquenceOfBST {
    public static boolean verifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) return false;
        return verify(sequence,0,sequence.length-1);
    }
    public static boolean verify(int[] sequence,int start, int end){
        if (end - start <= 1) return true;
        int rootValue = sequence[end];
        int pos = start;
        while (pos < end && sequence[pos] <= rootValue) pos++;
        for (int i = pos; i < end; i++){
            if (sequence[i] <= rootValue) return false;
        }
        if(!verify(sequence,start,pos-1)) return false;
        if(!verify(sequence,pos,end-1)) return false;
        return true;
    }
}
