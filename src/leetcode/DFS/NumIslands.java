package leetcode.DFS;
/**
 * @version: V1.0
 * @author: abiao
 * @className: NumIslands
 * @packageName: leetcode.DFS
 * @description: 矩阵中的连通分量数目
 * @data: 2019/1/17
 **/
public class NumIslands {
    public int numIslands(char[][] grid) {
        int ret = 0;
        if (grid == null || grid.length == 0) return 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length;j++){
                if (grid[i][j] == '1'){
                    dfs(grid,i,j);
                    ret++;
                }
            }
        }
        return ret;
    }

    public void dfs(char[][] grid,int x,int y){
        if (x < 0 || x >= grid.length
                || y < 0 || y >= grid[0].length
                ||grid[x][y] == '0') return;
        grid[x][y] = '0';
        dfs(grid,x-1,y);
        dfs(grid,x+1,y);
        dfs(grid,x,y-1);
        dfs(grid,x,y+1);
    }
}
