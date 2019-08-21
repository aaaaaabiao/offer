package offer.twopoint;

import java.util.ArrayList;
import java.util.List;
/**
 ``````````````````````````````````题目描述```````````````````````````````````
 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)
 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 ````````````````````````````````````例子`````````````````````````````````````
 
 ````````````````````````````````````链接`````````````````````````````````````
 https://www.nowcoder.com/practice/c451a3fd84b64cb19485dad758a55ebe?tpId=13&tqId=11194&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：双指针，滑动窗口
 描述：
 ````````````````````````````````````思考`````````````````````````````````````
 最后的判断条件为end < sum。如果end == sum。再累加无意义。
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/6
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
public class FindContinuousSequence {
    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();

        int start = 1;
        int end = 2;
        int curSum = 3;
        while (end < sum){
            if (curSum == sum){
                ArrayList ls = new ArrayList();
                for (int i = start; i <= end; i++){
                    ls.add(i);
                }
                arrayLists.add(ls);
                curSum -= start;
                start++;
                end++;
                curSum += end;
            }else if (curSum < sum){
                end++;
                curSum += end;
            }else{
                curSum -= start;
                start++;
            }
        }
        return arrayLists;
    }


    public static void main(String[] args){
        List ret = findContinuousSequence(100);
        int a = 0;
    }

}
