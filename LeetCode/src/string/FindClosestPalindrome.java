package string;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-the-closest-palindrome/description/
 * 输入一个整数，将其看作字符串，寻找与之相近最近的整数，该整数的字符串形式是对称的
 */
public class FindClosestPalindrome {


    public static void main(String args[]){
        FindClosestPalindrome fcp = new FindClosestPalindrome();
        System.out.println(fcp.nearestPalindromic("1213"));
        //System.out.println(fcp.bigAddOne("9"));
    }

    public String nearestPalindromic(String num) {
        if (num.length() == 1) {
            if(num.equals("0")){
                return "1";
            }

            return String.valueOf(num.charAt(0)-'0'-1);
        }


        long value = Long.parseLong(num);
        int midIndex = (num.length() - 1) / 2;
        String halfS = num.substring(0,midIndex+1);

        String sresult,temp;
        if(halfS.equals("1")){
            sresult = "9";
        }else{
            temp = this.bigSubOne(halfS);
            sresult = createPalindrome( temp, num.length()-1 - midIndex);
        }

        String sresult1 = createPalindrome(halfS , num.length()-1 - midIndex);

        temp = this.bigAddOne(halfS);
        String sresult2 = createPalindrome(temp , num.length()-1 - midIndex);

        long gap = Math.abs(Long.parseLong(sresult) - value);
        long gap1 = Math.abs(Long.parseLong(sresult1) - value);
        long gap2 = Math.abs(Long.parseLong(sresult2) - value);

        long [] array = {gap,gap1,gap2};
        Arrays.sort(array);

        long minGap;
        if(array[0] == 0){
            minGap = array[1];
        }else{
            minGap = array[0];
        }

        if (minGap == gap) {
            return sresult;
        } else if (minGap == gap1) {
            return sresult1;
        } else {
            return sresult2;
        }
    }


    public String createPalindrome(String a , int step){
        StringBuilder s = new StringBuilder(a);
        int i = step < a.length() ? step-1 : a.length()-1;
        while( step >0 ){
            s.append(s.charAt(i));
            if(i>=1){
                i--;
            }
            step--;
        }
        return s.toString();
    }


    public String bigAddOne(String a ){

        StringBuilder s = new StringBuilder(a);
        int temp = s.charAt(s.length()-1)-'0';
        int result = (temp+1)%10;
        int addOn = (temp+1)/10;
        s.setCharAt(s.length()-1 , (char) (result+'0'));
        int i = s.length()-2;
        while(i>=0){
            temp = s.charAt(i)-'0';
            result = (temp+addOn)%10;
            addOn = (temp+addOn)/10;
            s.setCharAt(i , (char) (result+'0'));
            i--;
        }
        if(addOn != 0){
            s.insert(0,(char)('0'+addOn));
        }
        return s.toString();
    }


    public String bigSubOne(String a){
        StringBuilder s = new StringBuilder(a);
        int temp = s.charAt(s.length()-1)-'0';
        int result; int borrawBit = 0;
        if(temp >= 1){
            result = temp - 1;
        }else{
            result = temp + 9;
            borrawBit = 1;
        }
        s.setCharAt(s.length()-1 , (char) (result+'0'));

        int i = a.length()-2;
        while(i >= 0 && borrawBit != 0){
            temp = s.charAt(i)-'0';
            if(temp >= borrawBit){
                result = temp -1;
                borrawBit = 0;
            }else{
                result = temp + 10 -1;
                borrawBit = 1;
            }
            s.setCharAt(i , (char) (result+'0'));
            i--;
        }

        while(s.charAt(0)=='0'){
            s.deleteCharAt(0);
        }
        return s.toString();
    }
}
