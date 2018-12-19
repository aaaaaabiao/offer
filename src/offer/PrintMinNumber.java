package offer;

/**
 * @version: V1.0
 * @author: abiao
 * @className: PrintMinNumber
 * @packageName: offer
 * @description: 把数组排成最小的数
 * @data: 2018/12/19
 **/
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrintMinNumber {
    public static String printMinNumber(int [] numbers) {
        int len = numbers.length;
        if (len == 0) return "";
        Integer[] integers = new Integer[len];
        for (int i = 0; i < len; i++){
            integers[i] = numbers[i];
        }

        List<Integer> ls = Arrays.asList(integers);

        Collections.sort(ls, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1+""+o2).compareTo(o2+""+o1);
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (int i : ls){
            stringBuilder.append(i);
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args){
        int[] numbers = new int[]{3,32,321};
        System.out.println(printMinNumber(numbers));
    }
}
