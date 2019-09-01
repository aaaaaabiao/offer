package company.alibaba;

import java.util.Scanner;

public class IndexAndLongest {
    static String getIndexAndLongest(String users) {
        char[] chs = users.toCharArray();
        int len = chs.length;
        int maxBoy = 0;
        for (int i = 0 ; i < len; i++) {
            int p = i == 0 ? len - 1 : i - 1;
            int q = i == (len - 1) ? 0 : i++;
            char ch = chs[i];
            if (ch == 'g') continue;
            while (p < q || p >= 0 || q <= len - 1) {

            }
        }
        return "";
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _users;
        try {
            _users = in.nextLine();
        } catch (Exception e) {
            _users = null;
        }

        res = getIndexAndLongest(_users);
        System.out.println(res);
    }
}
