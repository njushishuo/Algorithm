package back_tracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * 注意比较两种写法，一种采用局部变量string，每次return的时候自动回退长度；另一种采用成员变量需要手动控制长度； 前者在栈中，后者在堆中
 */
public class GenerateParentheses {


    public static void main(String args[]){
        GenerateParentheses gp = new GenerateParentheses();
        Solution solution = new Solution();

        int n = 3;
        System.out.println(gp.generateParenthesis(n));
        System.out.println(solution.generateParenthesis(n));
    }


    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }


    private static class Solution{


        List<String> result;
        StringBuilder builder;

        public Solution(){
            result = new ArrayList<>();
            builder = new StringBuilder();
        }


        public List<String> generateParenthesis(int n) {
            backtrack(n, 0, 0);
            return result;
        }

        public void backtrack(int n, int open, int close){

            if(builder.length() == n*2){
                result.add(builder.toString());
                return;
            }

            if(open < n){
                builder.append('(');
                backtrack(n,open+1, close);
                builder.deleteCharAt(builder.length()-1);
            }

            if(close < open){
                builder.append(')');
                backtrack(n, open, close+1);
                builder.deleteCharAt(builder.length()-1);
            }
        }


    }

}
