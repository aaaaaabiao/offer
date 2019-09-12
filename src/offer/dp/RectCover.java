package offer.dp;
/**
 * @version: V1.0
 * @author: abiao
 * @className: RectCover
 * @packageName: offer
 * @description: 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个
 *               2*n的大矩形，总共有多少种方法？
 * @data: 2018/11/23
 **/
public class RectCover {
    public int RectCover(int target) {
        if (target == 1) return 1;
        if (target == 2) return 2;
        int a = 1;
        int b = 2;
        int c = 0;
        for (int i = 3; i <= target; i++){
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }
}
