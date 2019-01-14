import java.util.ArrayList;
import java.util.List;


/*
* 描述：求n对括号，能组成多少组合法的括号
*
* 思路：用递归来回溯
* left:代表左括号能用多少
* right:代表右括号能用多少
* 因为必须放一个左括号才能放一个右括号
* 所以每用一个左括号，left-1，right+1。
* 当左右括号都用完时，返回一个值。
* */
public class GenerateParenthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> ls = new ArrayList<>();
        backtrack(ls,n,0,"");
        return ls;
    }
    public static void backtrack(List ls, int left,int right,String tmp){
        if (left == 0 && right == 0){
            ls.add(tmp);
            return;
        }
        if (left > 0){
            backtrack(ls,left-1,right+1,tmp+"(");
        }
        if (right > 0){
            backtrack(ls,left,right-1,tmp+")");
        }
    }

    public static void main(String args[]){
        List<String> ls = generateParenthesis(3);

    }
}
