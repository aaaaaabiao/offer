package leetcode.backtracing;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList();
        generateCore(ret,"",n,n);
        return ret;
    }

    public void generateCore(List<String> ret, String str,
                             int left,int right){
        if(left == 0 && right == 0){
            ret.add(str);
            return;
        }
        if(left < 0 || right < 0) return;


        generateCore(ret,str+"(",left-1,right);
        generateCore(ret,str+")",left,right-1);
    }

    public static void main(String[] args){
        GenerateParenthesis g = new GenerateParenthesis();
        g.generateParenthesis(3);
    }
}
