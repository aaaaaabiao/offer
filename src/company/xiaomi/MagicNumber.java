package company.xiaomi;

import java.util.Scanner;
/**
 * 神奇的数字
 *
 * @author hubiao
 * @date 2019/8/26
 */
public class MagicNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            for (int i = 1; i < n; i++) {
                int tmp = sc.nextInt();
                int f = (int)Math.sqrt(i);
                if (f * f == i) {
                    System.out.print(tmp + " ");
                }
            }
            System.out.println(sc.nextInt());
        }
    }
}
