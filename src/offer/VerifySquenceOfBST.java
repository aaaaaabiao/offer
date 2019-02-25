package offer;
/**
 * @version: V1.0
 * @author: abiao
 * @className: 判断一个序列是否是二叉搜索树的后序序列
 * @packageName: offer
 * @description:
 * @data: 2018/12/13
 **/
public class VerifySquenceOfBST {
    public static boolean verifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) return false;
//        return core(sequence,0,sequence.length-1);
        return verify(sequence,0,sequence.length-1);
    }

    public static boolean core(int[] sequence,int start, int end){
        if (start == end || start > end) return true;

        //判断倒数第二个元素是否大于end元素
        if (sequence[end-1] < sequence[end]){
            //如果小于，就要保证[start,end-1]所有的元素都小于end
            for (int i = end-2; i >= start; i--){
                if (sequence[i] > sequence[end]) return false;
            }
            //递归的求[start,end-1]是不是二叉搜索树的后序遍历序列
            return core(sequence,start,end-1);
        }else {
            //如果大于
            int p = end-2;
            boolean flag = false;
            for (int i = end-2; i >= start; i--){
                if (sequence[i] < sequence[end]){
                    p = i;
                    flag = true;
                    break;
                }
            }
            if (flag){
                //保证[start，p]小于end
                for (int i = p-1; i >= start; i--){
                    if (sequence[i] > sequence[end]) return false;
                }

                //[start，p]小于end，[p+1,end-1]元素都大于end，递归的求这两个序列是不是二叉搜索树的后序遍历序列
                return core(sequence,start,p) && core(sequence,p+1,end-1);
            }else {
                //递归的求[start,end-2]是不是二叉搜索树的后序遍历序列
                return core(sequence,start,p);
            }
        }
    }

    public static boolean verify(int[] sequence,int start, int end){
        if (end - start <= 1) return true;
        int rootValue = sequence[end];
        int pos = start;
        while (pos < end && sequence[pos] <= rootValue){
            pos++;
        }

        for (int i = pos; i < end; i++){
            if (sequence[i] <= rootValue){
                return false;
            }
        }

        return verify(sequence,start,pos-1) && verify(sequence,pos+1,end);
    }


    public static void main(String[] args){

    }
}
