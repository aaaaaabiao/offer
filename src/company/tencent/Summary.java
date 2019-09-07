package company.tencent;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Summary {
    public static int maxSum(int[] scores) {
        int max = 0;
        int len = scores.length;
        for (int i = 0; i < len; i++) {
            int sum = scores[i];
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            queue.add(scores[i]);
            for (int j = i+1; j < len; j++) {
                queue.add(scores[j]);
                sum += scores[j];
                int min = queue.peek();
                max = Math.max(max, min * sum);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }
        int max = maxSum(scores);
        System.out.println(max);
    }
}
