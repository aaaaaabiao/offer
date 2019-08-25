package offer.math;


/**
 * 快速幂
 *
 * @author hubiao
 */
public class Power {
    public static double power(double base, int exponent) {
        //递归基
        if(exponent == 0) return 1;
        if(exponent == 1) return base;

        //对负数进行处理

        double ret = power(base*base, exponent/2);
        if(exponent % 2 != 0){
            ret *= base;
        }
        return ret;
    }

    public static double recursive(double base, int exponent) {
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }
        double ret = 1;
        while (exponent > 1) {
            if (exponent % 2 == 1) {
                ret *= base;
            }

            base *= base;
            exponent /= 2;
        }
        return ret * base;
    }

    public static void main(String[] args){
        System.out.println(power(2,3));
        System.out.println(recursive(2,-3));
    }
}
