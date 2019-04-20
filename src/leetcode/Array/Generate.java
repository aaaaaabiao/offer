package leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generate {

    public List<List<Integer>> generate(int numRows) {
        List ret = new ArrayList();
        int[] arr = new int[]{1};
        ret.add(Arrays.asList(arr));
        for(int i = 2; i <= numRows; i++){
            int[] buf = new int[i];
            int len = arr.length;
            for(int j = 0; j < i; j++){
                if(j-1 < 0){ buf[j] = arr[j]; continue;}
                if(j >= len){ buf[j] = arr[j-1]; continue;}
                buf[j] = arr[j-1]+arr[j];
            }
            ret.add(Arrays.asList(buf));
            arr = buf;
        }

        return ret;
    }

    public static void main(String[] args){
        Generate generate = new Generate();
        generate.generate(5);

        List ls = Arrays.asList(new Integer[]{1,2,3});
                                                                                                                                                            int a = 0;
    }
}
