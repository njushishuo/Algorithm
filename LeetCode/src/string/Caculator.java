package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Caculator {

    public static void main(String args[]){

        String input1 = "a+b*c + (d * e + f) * g";
        System.out.println("inOrder:"+input1);
        System.out.println("postOrder:"+inOrder2PostOrder(input1));


        String input2 = "10 + 7*21 + (41 * 23 + 5)* 27";
        System.out.println("inOrder:"+input2);
        List<String> result = inOrder2PostOrderV2(input2);
        for(String temp : result){
            System.out.print(temp+" ");
        }
    }


    /**
     * 输入的数字用的单个字母表示 e.g.  a + b * c
     * @param input
     * @return
     */
    public static String inOrder2PostOrder(String input){

        HashMap<Character,Integer> map = new HashMap<>();
        map.put('+',1);
        map.put('-',1);
        map.put('*',2);
        map.put('/',2);
        map.put('(',3);
        map.put(')',3);
        input = input.trim();
        StringBuilder result = new StringBuilder();
        Stack<Character> opStack = new Stack();

        for(int i =0 ; i<input.length(); i++){
            while(i<input.length()&&Character.isLetter(input.charAt(i))){
                result.append(input.charAt(i));
                i++;
            }
            if(i<input.length()&&map.containsKey(input.charAt(i))){
                if( input.charAt(i)!=')' && (opStack.isEmpty() || map.get(input.charAt(i)) > map.get(opStack.peek())) ){
                    opStack.push(input.charAt(i));
                }else{
                    if(input.charAt(i)!=')'){
                        while(!opStack.isEmpty() && opStack.peek()!='('
                                && map.get(input.charAt(i)) <= map.get(opStack.peek())){
                            result.append(opStack.pop());
                        }
                        opStack.push(input.charAt(i));
                    }else{
                        while(!opStack.isEmpty() && opStack.peek()!='('){
                            result.append(opStack.pop());
                        }
                        opStack.pop();
                    }
                }
            }
        }
        while(!opStack.isEmpty()){
            result.append(opStack.pop());
        }
        return result.toString();
    }



    /**
     * 输入的数字用的多个字母表示 e.g.  12 + 301 * 2
     * @param input
     * @return
     */
    public static List<String> inOrder2PostOrderV2(String input){

        HashMap<Character,Integer> map = new HashMap<>();
        map.put('+',1);
        map.put('-',1);
        map.put('*',2);
        map.put('/',2);
        map.put('(',3);
        map.put(')',3);
        input = input.trim();
        List<String> result = new ArrayList();
        Stack<Character> opStack = new Stack();

        for(int i =0 ; i<input.length(); i++){
            if(Character.isDigit(input.charAt(i))){
                StringBuilder temp = new StringBuilder();
                while(i<input.length()&&Character.isDigit(input.charAt(i))){
                    temp.append(input.charAt(i));
                    i++;
                }
                i--;
                result.add(temp.toString());
            }else if(i<input.length()&&map.containsKey(input.charAt(i))){

                if( input.charAt(i)!=')' && (opStack.isEmpty() || map.get(input.charAt(i)) > map.get(opStack.peek())) ){
                    opStack.push(input.charAt(i));
                }else{
                    if(input.charAt(i)!=')'){
                        while(!opStack.isEmpty() && opStack.peek()!='('
                                && map.get(input.charAt(i)) <= map.get(opStack.peek())){
                            result.add(opStack.pop()+"");
                        }
                        opStack.push(input.charAt(i));
                    }else{
                        while(!opStack.isEmpty() && opStack.peek()!='('){
                            result.add(opStack.pop()+"");
                        }
                        if(opStack.peek()=='('){
                            opStack.pop();
                        }
                    }
                }
            }
        }
        while(!opStack.isEmpty()){
            result.add(opStack.pop()+"");
        }
        return result;
    }

//    public static int calculate(String postOrder){
//
//    }


}
