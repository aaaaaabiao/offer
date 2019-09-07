package company.tencent;

import java.util.Scanner;

public class Precious {
    public static int maxPrecious(int[] boxes, int[] keys) {
        int boxesSize = boxes.length;
        int count = 0;
        boolean[] visit = new boolean[boxesSize];
        for (int i = 0; i < keys.length; i++) {
            for (int j = 0; j < boxesSize; j++) {
                int sum = boxes[j] + keys[i];
                if (!visit[j] && sum % 2 == 1) {
                    count++;
                    visit[i] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] boxes = new int[n];
        int[] keys = new int[m];
        for (int i = 0; i < n; i++) {
            boxes[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            keys[i] = scanner.nextInt();
        }
        int count = maxPrecious(boxes, keys);
        System.out.println(count);
    }
}
