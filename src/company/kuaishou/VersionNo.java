package company.kuaishou;

import java.util.Scanner;

public class VersionNo {

    public static boolean vertify(String v1, String v2) {

        if (v1 == null || v2 == null || v1.length() == 0 || v2.length() == 0) {
            return false;
        }
        String[] strs1 = v1.split("\\.");
        String[] strs2 = v2.split("\\.");
        int p = 0;
        int q = 0;
        int l1 = strs1.length;
        int l2 = strs2.length;
        while (p < l1 && q < l2) {
            int a = Integer.valueOf(strs1[p]);
            int b = Integer.valueOf(strs2[q]);

            if (a > b) {
                return false;
            }else if (a < b) {
                return true;
            }else {
                p++;
                q++;
            }
        }

        if (q < l2) {
            while (q < l2) {
                int val = Integer.valueOf(strs2[q]);
                if (val != 0) {
                    return true;
                }
                q++;
            }
        }
        return false;

    }

    public String getMinVersion(String[] list) {
        if (list == null || list.length == 0) {
            return null;
        }
        String min = list[0];
        for (int i = 1; i < list.length; i++) {
            String str = list[i];
            if (vertify(str,min)) {
                min = str;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int m = scanner.nextInt();
            while (m-- > 0) {
                String v1 = scanner.next();
                String v2 = scanner.next();

                System.out.println(vertify(v1, v2));
            }
        }
    }
}
