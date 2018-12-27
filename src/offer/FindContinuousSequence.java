package offer;

import java.util.ArrayList;
import java.util.List;
/**
 * @version: V1.0
 * @author: abiao
 * @className: FindContinuousSequence
 * @packageName: offer
 * @description: 连续正数序列的和为sum。找出这种序列。
 * @data: 2018/12/27
 **/
public class FindContinuousSequence {
    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();

        int start = 1;
        int end = 2;

        while (start != end){
            int total = (start+end)*(end-start+1)/2;
            if (total == sum){
                ArrayList ls = new ArrayList();
                for (int i = start; i <= end; i++){
                    ls.add(i);
                }
                arrayLists.add(ls);
                start++;
            }else if (total < sum){
                end++;
            }else{
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
