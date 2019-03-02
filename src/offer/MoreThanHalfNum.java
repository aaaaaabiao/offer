package offer;
import java.util.HashMap;
import java.util.Map;
/**
 * @version: V1.0
 * @author: abiao
 * @className: MoreThanHalfNum
 * @packageName: offer
 * @description: 数组中次数超过一半的数字
 * @data: 2018/12/17
 **/
public class MoreThanHalfNum {

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

    public static void main(String[] args){
        int[] array = new int[]{1,2,3,2,2,2,5,4,2};
        moreThanHalfNum(array);
    }
}
