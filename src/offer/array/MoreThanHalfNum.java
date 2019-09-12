package offer.array;
import java.util.HashMap;
import java.util.Map;
/**
 ``````````````````````````````````题目描述```````````````````````````````````
 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 ````````````````````````````````````例子`````````````````````````````````````
 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 ````````````````````````````````````链接`````````````````````````````````````
 https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?tpId=13&tqId=11181&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：假设存在超过一半的数字m个数为n。如果拿一个其他不等于m的数字去抵消一个m。那么最后剩下的n的个数一定大于0。
 描述：
 ````````````````````````````````````思考`````````````````````````````````````
 题中最后并不是拿count>0作为找到的结果。例如[1,2,1,2,3],[1,2,1,2,1]
 因为按这种方法count最后肯定至少是大于0的。所以还得在遍历一次判断是不是数组中出现超过一半的数字
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/5
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
public class MoreThanHalfNum {


    //时间复杂度O(n)
    public int MoreThanHalfNum_Solution(int [] array) {
        int majority = array[0];
        int count = 1;
        for(int i = 1; i < array.length; i++){
            count = majority == array[i] ? count+1 : count-1;
            if(count == 0){
                majority = array[i];
                count = 1;
            }
        }

        int len = array.length / 2;
        count = 0;
        for(int val : array){
            if(majority == val){
                count++;
            }
        }

        return count > len ? majority : 0;
    }
    
    
    //利用hashmap来解。需要额外的辅助空间
    public static int moreThanHalfNum(int [] array) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : array){
            if (map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else {
                map.put(i,1);
            }
        }

        int value = array.length/2;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            if (entry.getValue() > value){
                return entry.getKey();
            }
        }

        return 0;
    }
    
    public static void main(String[] args){
        int[] array = new int[]{1,2,3,2,2,2,5,4,2};
        moreThanHalfNum(array);
    }
}
