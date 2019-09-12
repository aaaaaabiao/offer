package company.pdd;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SpaceTopK {
    public static int topK(int n, int m, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k+1);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                queue.add(i*j);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(topK(n, m, k));
    }
}
