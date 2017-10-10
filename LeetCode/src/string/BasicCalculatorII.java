package string;

/**
 * https://leetcode.com/problems/basic-calculator-ii/description/
 * 不考虑括号，只有 + - * /
 */
public class BasicCalculatorII {


    public static void main(String args[]){
        BasicCalculatorII bi = new BasicCalculatorII();
        int a = bi.calculate("0-1");
        System.out.println(a);
    }

    public int calculate(String s) {
        char curOp = '+';
        int curVal = 0 , result =0;
        int i=0;

        while(i<s.length()){
            char temp = s.charAt(i);
            if(temp == ' '){
                i++;
                continue;
            }

            if(Character.isDigit(temp)){
                int val =0;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    val = val * 10 + s.charAt(i)-'0';
                    i++;
                }
                if(curOp == '+'){
                    curVal = val;
                    result += curVal;
                }
                if(curOp == '-'){
                    curVal = 0-val;
                    result += curVal;
                }
                if(curOp == '*'){
                    result -= curVal;
                    curVal = curVal * val;
                    result += curVal;
                }
                if(curOp == '/'){
                    result -= curVal;
                    curVal = curVal / val;
                    result += curVal;
                }
            }else{
                curOp = temp;
                i++;
            }



        }

        return result;
    }

}
