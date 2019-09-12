package company.kuaishou;

import java.util.HashSet;
import java.util.Scanner;

public class SqrtSum {
    public static int sqrtSum(int n) {
        int ret = 0;
        while (n != 0) {
            int a = n % 10;
            ret += (a * a);
            n = n / 10;
        }
        return ret;
    }

    public static boolean judge(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            if (n == 1) {
                return true;
            }
            n = sqrtSum(n);
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        while (m-- > 0) {
            int a = scanner.nextInt();
            System.out.println(judge(a));
        }
    }
}