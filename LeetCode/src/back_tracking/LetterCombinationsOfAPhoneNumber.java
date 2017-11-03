package back_tracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    public static void main(String args []){
        LetterCombinationsOfAPhoneNumber lc = new LetterCombinationsOfAPhoneNumber();
        System.out.println(lc.letterCombinations("2"));
    }

    List<String> result;
    HashMap<Character, String> map;

    public LetterCombinationsOfAPhoneNumber(){
        result = new ArrayList<>();
        map = new HashMap<>();
        map.put('2',"abc"); map.put('3',"def"); map.put('4',"ghi");
        map.put('5',"jkl"); map.put('6',"mno"); map.put('7',"pqrs");
        map.put('8',"tuv"); map.put('9',"wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return result;
        }
        backTracking(digits,0,new StringBuilder());
        return result;
    }

    private void backTracking(String input , int index , StringBuilder tempResult ){
        if(tempResult.length() == input.length()){
            result.add(tempResult.toString());
            return;
        }

        String temp = map.get(input.charAt(index));
        for(int i = 0; i < temp.length(); i++){
            tempResult.append(temp.charAt(i));
            backTracking(input , index+1 , tempResult);
            tempResult.deleteCharAt(tempResult.length()-1);
        }
    }
}
