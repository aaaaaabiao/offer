import java.util.HashMap;

import java.util.Stack;

/*
*合法括号
* */

public class VaildParentheses {
    public static boolean isValid(String s) {
        HashMap<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        if(s == null){
            return false;
        }
        if ("".equals(s)){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty()) {
                char top = stack.peek();
                if (map.containsKey(top) && map.get(top) == ch) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String args[]){
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("()"));

        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]}"));
        System.out.println(isValid("{[]}"));

    }
}
