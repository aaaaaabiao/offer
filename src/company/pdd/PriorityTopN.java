package company.pdd;

import java.util.*;

public class PriorityTopN {
    public static List<Integer> topN(List<Integer> data, int n) {
        //创建一个小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(n+1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 % 2 == 0 && o2 % 2 == 0) {
                    return o1 - o2;
                }else if (o1 % 2 == 0) {
                    return 1;
                }else if (o2 % 2 == 0) {
                    return -1;
                }else {
                    return o1 - o2;
                }
            }
        });

        for (int num : data) {
            queue.add(num);
            if (queue.size() > n) {
                queue.poll();
            }
        }
        List<Integer> ret = new ArrayList<>();

        while (!queue.isEmpty()) {
            ret.add(queue.poll());
        }

        Collections.reverse(ret);
        return ret;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String[] strs1 = str.split(";");
        int n = Integer.valueOf(strs1[1]);
        String[] nums = strs1[0].split(",");
        List<Integer> data = new ArrayList<>();
        for (String num : nums) {
            data.add(Integer.valueOf(num));
        }

        List<Integer> ret = topN(data, n);

        List<String> ls = new ArrayList<>();
        for (int num : ret) {
            ls.add(num + "");
        }
        System.out.println(String.join(",", ls));

    }
}
