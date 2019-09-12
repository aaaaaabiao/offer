package company.pdd;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
            max = Math.max(arr[i], max);
        }
        double res = 0;
        double pre = 0;
        for (int t = 1; t <= max; t++) {
            double p = 1.0;
            for (int i = 0; i < n; i++) {
                p *= t > arr[i] ? 1.0 : t * 1.0 / arr[i];
            }
            double tempPre = p;
            p = p - pre;
            res += p * t;
            pre = tempPre;
        }

        System.out.println(String.format("%.2f", res));
    }
}
