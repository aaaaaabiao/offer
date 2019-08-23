package offer;

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


    public static double power1(double base, int exponent) {
        boolean isNegative = false;
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        if (exponent < 0){
            exponent = -exponent;
            isNegative = true;
        }
        double ret = base;
        double n = 0;
        while (exponent != 1){
            if (exponent % 2 != 0){
                n = ret;
            }
            ret *= ret;
            exponent = exponent / 2;
        }
        ret *= n;
        return isNegative ? 1/ret : ret;
    }

    public static void main(String[] args){
        System.out.println(power1(2,-3));
    }
}
