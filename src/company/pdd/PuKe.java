package company.pdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PuKe {
    public static void backtracing(List<List<String>> ret, List<String> ls, int start, String src, String dst, String target) {
        int len = src.length();
        if (target.equals(dst)) {
            ret.add(new ArrayList<>(ls));
        }
        if (start < len) {
            ls.add("d");
            backtracing(ret, ls, start + 1, src, dst, target);
            ls.remove(ls.size() - 1);

            ls.add("l");
            backtracing(ret, ls, start + 1, src, dst, src.charAt(start) + target);
            ls.remove(ls.size() - 1);

            ls.add("r");
            backtracing(ret, ls, start + 1, src, dst, target + src.charAt(start));
            ls.remove(ls.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n-- > 0) {
            String src = scanner.next();
            String dst = scanner.next();

            List<List<String>> ret = new ArrayList<>();
            List<String> ls = new ArrayList<>();

            backtracing(ret, ls, 0, src, dst, "");

            for (List<String> strs : ret) {

                System.out.println(strs);

            }
        }
    }
}
