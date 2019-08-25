package offer.math;
/**
 ``````````````````````````````````题目描述```````````````````````````````````
 数字以 0123456789101112131415... 的格式序列化到一个字符串中，求这个字符串的第 index 位。
 ````````````````````````````````````例子`````````````````````````````````````
 数字以01234567891011121314...的格式排列。在这个序列中，第5位（从0开始计）是5，第13位是1，第19位是4。求任意第n为对应的数字。
 ````````````````````````````````````链接`````````````````````````````````````
 
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：数学规律题
 描述：位数为1的数字有10个，占10个字符。位数为2的数字有90个，占180个字符。位数为3的位置有900个，占2700个字符。
 所以有区间[0-10),[10-180+10),[180+10,2700+180+10)

 看index位于哪个区间？可以计算出。index位于某个区间的第i位。

 可以计算第多少个数。最后定位到这个数的第几位。
 ````````````````````````````````````思考`````````````````````````````````````
 
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/5
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
public class GetDigitAtIndex {
    public int getDigitAtIndex(int index) {
        if (index < 0)
            return -1;
        int place = 1;  // 1 表示个位，2 表示 十位...
        while (true) {
            int amount = getAmountOfPlace(place);//代表一共有多少个数
            int totalAmount = amount * place;//代表place位的数一共占多少位
            if (index < totalAmount)        //如果小于就在这个区间中找。
                return getDigitAtIndex(index, place);
            index -= totalAmount;//将index减去区间所占的位数。从下一个区间的开始位置开始找
            place++;
        }
    }

    /**
     * place 位数的数字组成的字符串长度
     * 10, 90, 900, ...
     */
    private int getAmountOfPlace(int place) {
        if (place == 1)
            return 10;
        return (int) Math.pow(10, place - 1) * 9;
    }

    /**
     * place 位数的起始数字
     * 0, 10, 100, ...
     */
    private int getBeginNumberOfPlace(int place) {
        if (place == 1)
            return 0;
        return (int) Math.pow(10, place - 1);
    }

    /**
     * 在 place 位数组成的字符串中，第 index 个数
     */
    private int getDigitAtIndex(int index, int place) {
        int beginNumber = getBeginNumberOfPlace(place);
        int shiftNumber = index / place;
        String number = (beginNumber + shiftNumber) + "";
        int count = index % place;
        return number.charAt(count) - '0';
    }

}
