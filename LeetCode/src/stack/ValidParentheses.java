package stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/description/
 */
public class ValidParentheses {

    public boolean isValid(String s) {

        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','('); map.put(']','[') ; map.put('}','{');

        Stack<Character>  stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if(temp == '(' || temp == '[' || temp == '{'){
                stack.push(temp);
            }else if(temp == ')' || temp == ']' || temp == '}'){
                if(stack.isEmpty()){
                    return false;
                }else {
                    if (stack.peek() != map.get(temp)) {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
