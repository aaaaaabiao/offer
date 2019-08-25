package offer.array;
/*在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
* 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
* */

/*
* 思路：
* 1.和右上角值比较。
* 2.大于左上角的值就将右上角这一行去掉，小于就将右上角这一列去掉。等于就找到了。
* */

public class TwoDimensionalArraySearch {

    public static boolean Find(int target, int [][] array) {

        if (array == null && array.length == 0) return false;
        int x = 0;
        int y = array[0].length-1;
        while (x < array.length && y >= 0){
            if (target < array[x][y]){
                y--;
            }else if (target > array[x][y]){
                x++;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[][] array = new int[][]{{1,2,3},{4,5,6},{7,8,9}};

        System.out.println(Find(3,array));
    }
}
