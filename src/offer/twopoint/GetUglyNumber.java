package offer.twopoint;
/**
 ``````````````````````````````````题目描述```````````````````````````````````
 把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。例如 6、8 都是丑数，但 14 不是，因为它包含因子 7。习惯上我们把 1 当做是第一个丑数。求按从小到大的顺序的第 N 个丑数。
 ````````````````````````````````````例子`````````````````````````````````````
 
 ````````````````````````````````````链接`````````````````````````````````````
 https://www.nowcoder.com/practice/6aa9e04fc3794f68acf8778237ba065b?tpId=13&tqId=11186&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：丑数*丑数 = 丑数。用堆来实现，每次取出堆顶元素val。将val*2,val*3,val*5的元素依次入堆。在这个过程中判断堆的大小的是不是为n。如果为n就取出堆顶元素返回。

 描述：用三个指针。
 方法：动态规划
 描述：用一个dp数组来存第i个丑数的大小。dp[i]代表第i个丑数的大小。
 使用三个指针，分别记录乘2、3、5得出的目前最大丑陋数。而新的丑数就是这三个目前最大丑数中最小的那个，那么就需要更新被选中的丑数的指针，获得新的三个目前最大丑数，依次类推，从而得到最终结果。
 ````````````````````````````````````思考`````````````````````````````````````
 
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/5
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
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
