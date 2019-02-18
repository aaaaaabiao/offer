package leetcode.backtracing;

/**
 * @version: V1.0
 * @author: abiao
 * @className: WordSearch
 * @packageName: leetcode.backtracing
 * @description: 单词搜索
 * @data: 2019/2/18
 **/
public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length;j++){
                if (backtracing(board,i,j,0,word)){
                    return true;
                }
            }
        }
        return false;

    }


    public static boolean backtracing(char[][] board,int x,int y,int p,String word){
        int xlen = board.length;
        int ylen = board[0].length;
        if (x >= 0 && x < xlen && y >= 0 && y < ylen) {
            if (board[x][y] == word.charAt(p)) {
                board[x][y] ^= 256;
                if (p == word.length() - 1) return true;
                boolean exist =  backtracing(board, x + 1, y, p + 1, word) ||
                        backtracing(board, x - 1, y, p + 1, word) ||
                        backtracing(board, x, y + 1, p + 1, word) ||
                        backtracing(board, x, y - 1, p + 1, word);
                board[x][y] ^= 256;
                return exist;
            }
        }
        return false;
    }


    public static void main(String[] args){
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] board1 = new char[][]{{'a','b'}};

        System.out.println(exist(board1,"ba"));
    }
}
