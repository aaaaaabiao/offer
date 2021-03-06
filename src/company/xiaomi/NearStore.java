package company.xiaomi;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * 附近的零售店
 *
 * @author hubiao
 * @date 2019/8/26
 */
public class NearStore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            TreeSet<Integer> s = new TreeSet<>();
            int n = sc.nextInt(), m = sc.nextInt();
            for (int i = 0; i < n; i++) {
                s.add(sc.nextInt());
            }
            int res = 0;
            for (int i = 0; i < m; i++) {
                int now = sc.nextInt();
                Integer r = s.ceiling(now), l = s.floor(now)    ;
                int min = Integer.MAX_VALUE;
                if (r != null) {
                    min = Math.min(min, r - now);
                }
                if (l != null) {
                    min = Math.min(min, now - l);
                }
                res += min;
            }
            System.out.println(res);
        }
    }
}
