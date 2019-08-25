package company.kuaishou;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MergeDataStream {

    public static String merge(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        String[] strs1 = s1.split(" ");
        String[] strs2 = s2.split(" ");
        Queue<String> q1 = null;
        Queue<String> q2 = null;
        if (strs1.length > strs2.length){
            q1 = new LinkedList<>(Arrays.asList(strs1));
            q2 = new LinkedList<>(Arrays.asList(strs2));
        }else {
            q1 = new LinkedList<>(Arrays.asList(strs2));
            q2 = new LinkedList<>(Arrays.asList(strs1));
        }

        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.size() >= 4) {
                for (int i = 0; i < 4; i++) {
                    sb.append(q1.poll() + " ");
                }
                sb.append(q2.poll() + " ");
            }else {
                while (!q1.isEmpty()) {
                    sb.append(q1.poll() + " ");
                }
            }
        }

        if (!q1.isEmpty()) {
            sb.append(q1.poll() + " ");
        }

        if (!q2.isEmpty()) {
            sb.append(q2.poll() + " ");
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            System.out.println(merge(s1, s2));
        }
    }
}
