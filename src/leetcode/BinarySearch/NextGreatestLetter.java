package leetcode.BinarySearch;
/**
 * @version: V1.0
 * @author: abiao
 * @className: NextGreatestLetter
 * @packageName: leetcode.BinarySearch
 * @description: 大于给定元素的最小元素
 * @data: 2019/1/21
 **/
public class NextGreatestLetter {
    public static char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int h = letters.length-1;
        while (l < h){
            int mid = l+(h-l)/2;

            if (target < letters[mid]){
                h = mid;
            }else {
                l = mid+1;
            }
        }
        return target < letters[letters.length-1] ? letters[l] : letters[0];
    }

    public static void main(String[] args){
        char[] letters = new char[]{'c','f','j'};
        System.out.println(nextGreatestLetter(letters,'c'));
    }
}
