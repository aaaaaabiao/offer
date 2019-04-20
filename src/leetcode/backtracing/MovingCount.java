package leetcode.backtracing;

/**
 * Created by 73681 on 2019/3/6.
 */
public class MovingCount {
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] visit = new boolean[rows][cols];
        return backtracing(threshold,0,0,rows,cols,visit);
    }

    //其实是DFS的思想，可达性问题
    public int backtracing(int threshold,int p,int q,int rows,int cols,boolean[][] visit){
        if(p >= rows || p < 0 || q >= cols || q < 0 || visit[p][q] ||
                sum(p)+sum(q) > threshold){
            return 0;
        }
        visit[p][q] = true;
        int res = 1 + backtracing(threshold,p+1,q,rows,cols,visit)
                + backtracing(threshold,p-1,q,rows,cols,visit)
                + backtracing(threshold,p,q+1,rows,cols,visit)
                + backtracing(threshold,p,q-1,rows,cols,visit);


        return res;
    }

    public int sum(int val){
        int res = 0;
        while(val != 0){
            int p = val % 10;
            val = val / 10;
            res += p;
        }
        return res;
    }

    public static void main(String[] args){
        MovingCount movingCount = new MovingCount();

        System.out.println(movingCount.movingCount(5,5,10));
    }
}
