package leetcode;
/**
 ``````````````````````````````````题目描述```````````````````````````````````
 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 ````````````````````````````````````例子`````````````````````````````````````
 输入: [[1,1],[2,2],[3,3]]
 输出: 3
 解释:
 ^
 |
 |        o
 |     o
 |  o
 +------------->
 0  1  2  3  4
 ````````````````````````````````````链接`````````````````````````````````````
 https://leetcode-cn.com/problems/max-points-on-a-line/submissions/
 ``````````````````````````````````解题思路```````````````````````````````````
 方法：
 描述：
 处理3个问题
 1.斜率是浮点型不能精确比较。可求最小公约数
 2.斜率不存在的情况。
 3.重复的点的情况。
 ````````````````````````````````````思考`````````````````````````````````````
 
 `````````````````````````````````````````````````````````````````````````````
 data：2019/4/9
 author:abiao
 `````````````````````````````````````````````````````````````````````````````
 * **/
import java.util.HashMap;
import java.util.Map;

public class MaxPoints {
     static class Point {
         int x;
         int y;
         Point() { x = 0; y = 0; }
         Point(int a, int b) { x = a; y = b; }
     }

    //处理3个问题
    //1.斜率是浮点型不能精确比较。可求最小公约数
    //2.斜率不存在的情况。
    //3.重复的点的情况
    public static int maxPoints(Point[] points) {
        int len = points.length;
        if(len == 1) return 1;
        int max = 0;
        for(int i = 0; i < len; i++){
            Map<String,Integer> map = new HashMap();
            int x1 = points[i].x;
            int y1 = points[i].y;
            int c  = 0;//记录重复点的个数
            for(int j = 0; j < len; j++){
                if (i == j) continue;
                int x2 = points[j].x;
                int y2 = points[j].y;

                //处理同一个点
                if(x1 == x2 && y1 == y2){
                    c++;
                    continue;
                }

                //处理斜率不存在的情况
                if(x1 - x2 == 0){
                    map.put("NULL",map.getOrDefault("NULL",1)+1);
                    continue;
                }

                int d1 = x2 - x1;
                int d2 = y2 - y1;

                int d = minCommonDivisor(d2,d1);
                String val = d1/d + "" + d2/d;
                map.put(val,map.getOrDefault(val,1)+1);


            }
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                max = Math.max(max,entry.getValue()+c);
            }
            max = Math.max(max,c+1);

        }

        return max;
    }


    public static int minCommonDivisor(int a, int b){
        while(a % b != 0){
            int t = a % b;
            a = b;
            b = t;
        }
        return b;
    }

    public static void main(String[] args){
        Point[] points = new Point[]{new Point(0,0),new Point(0,0)};

        System.out.println(maxPoints(points));
    }

}
