package offer;
/**
 * @version: V1.0
 * @author: abiao
 * @className: GetUglyNumber
 * @packageName: offer
 * @description: 丑数
 * @data: 2018/12/20
 **/
public class GetUglyNumber {
    public static int getUglyNumber(int index) {

        if (index == 0){
            return 0;
        }
        if (index == 1){
            return 1;
        }
        int[] ret = new int[index];
        ret[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for (int i = 1; i < index; i++){
            int min = Math.min(ret[p2]*2, Math.min(ret[p3]*3, ret[p5]*5));
            if (min == ret[p2] * 2) p2++;
            if (min == ret[p3] * 3) p3++;
            if (min == ret[p5] * 5) p5++;
            ret[i] = min;
        }
        return ret[index-1];
    }

    public static void main(String[] args){
        System.out.println(getUglyNumber(3));
        System.out.println(getUglyNumber(4));
        System.out.println(getUglyNumber(5));
        System.out.println(getUglyNumber(6));
        System.out.println(getUglyNumber(7));
    }
}
