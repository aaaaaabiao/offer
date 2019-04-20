import jdk.internal.util.xml.impl.Input;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by 73681 on 2019/3/7.
 */
public class Main {
    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {//注意while处理多个case
//            int n = in.nextInt();
//            String str = in.next();
//
//            System.out.println(minLen(str));
//        }

//        Main main = new Main();
//
//        int v = 40;
//        int w = 30;
//        int[][] datas = new int[][]{{10,10,10,10,1},{13,10,12,11,3},{3,4,6,5,3}};
//        System.out.println(main.maxValue(w,v,datas));


        HashMap<String,String> map = new HashMap<>();
        map.put("str1","123");
//        map.put("str","123");

        HashMap<String,String> map1 = new HashMap<>();
        map1.put("str","123");

        System.out.println(map.equals(map1));
    }



    public static int minLen(String str){
        Map<Character,Character> map = new HashMap<>();
        map.put('1','0');
        map.put('0','1');
        char[] arr = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++){
            if(!stack.isEmpty() && map.get(stack.peek()) == arr[i]) stack.pop();
            else stack.push(arr[i]);
        }
        return stack.size();
    }

    public static int minCount(int m, int[] data){
        int n = data.length;
        int[] dp = new int[m+1];//代表凑成(1-i)面值所需要的最少硬币
        dp[0] = 0;
        for (int i = 1; i <= m; i++){
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++){
                int val = data[j];
                if(i - val >= 0){
                    dp[i] = Math.min(dp[i],dp[i-val]+dp[i]);
                }
            }
            if (dp[i] == Integer.MAX_VALUE) return -1;
        }

        return dp[m];
    }




    public static boolean isSearchTree(int[] data,int s){
        if(data == null) return false;
        int len = data.length;
        if (s >= data.length) return true;
        int i = 2*s+1;
        int j = 2*s+2;
        if(i < len && data[i] >= data[s]) return false;
        if(j < len && data[j] <= data[s]) return false;
        return isSearchTree(data,i) && isSearchTree(data,j);
    }

    public static boolean check(int[] data, int i){
        int l = 0;//根据下标确定下标为i的为完全二叉树的第几层。
        int n = i+1;
        while (n != 0) {
            n = n >> 1;
            l++;
        }

        int c = 0;
        while (true){

        }
    }


    public static String countofOne(int n){
        String str = new String(new char[]{1,2,3});
        int c = 0;
        while (n != 0){
            n &= n-1;
            c++;
        }
        return c+"";
    }


    public void input(){
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            int v = in.nextInt();
            int m = in.nextInt();

            int[][] data = new int[n][4];

            for (int i = 0; i < n; i++){
                for (int j = 0; j < 4; j++){
                    data[i][j] = in.nextInt();
                }
            }
            System.out.println(maxValue(m,v,data));
        }
    }

    public int maxValue(int w,int v,int[][] datas){
        int[][] dp = new int[w+1][v+1];//dp[i][j]代表重量为i,体积为j的包裹能装的最大价值。
        int max = 0;
        for (int i = 1; i <= w; i++){
            for (int j = 1; j <= v; j++){
                int index = -1;
                int p = 0;
                for(int[] data : datas){
                    if(j - data[0] >= 0 && i - data[1] >= 0 && data[2] > 0){
                        int val = dp[i-data[1]][j-data[0]]+data[3];
                        if(val > dp[i][j]){
                            dp[i][j]  = val;
                            index = p;
                        }
                    }
                    p++;
                }
                if (index >= 0) datas[index][2] -= 1;

                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }

}
