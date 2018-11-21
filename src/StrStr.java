import javax.annotation.Resource;

public class StrStr {

    public static int strStr(String haystack, String needle) {

        if ("".equals(haystack) && !"".equals(needle)|| haystack == null) return -1;

        if ("".equals(needle)) return 0;

        if (haystack.equals(needle)) return 0;


        char[] s1 = haystack.toCharArray();
        char[] s2 = needle.toCharArray();

        int res = -1;
        for (int i = 0; i < s1.length; i++){
            boolean flag = true;
            int pos1 = i;
            int pos2 = 0;
            if (s1.length - i < s2.length) return -1;
            while (pos1 < s1.length && pos2 < s2.length){

                if (s1[pos1] != s2[pos2]) break;
                if (s1[pos1] == s2[pos2] && flag){
                    res = pos1;
                    flag = false;
                }
                if (pos2 == s2.length-1) return res;
                pos1++;
                pos2++;
            }
        }
        return res;
    }

    public static void main(String[] args){
//        System.out.println(strStr("hello","ll"));
//        System.out.println(strStr("aaaaa","bba"));
//        System.out.println(strStr("",""));
        System.out.println(strStr("aaa","aaa"));
        System.out.println(strStr("aaa","aaa"));
    }
}
