package back_tracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/description/
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * ex. "aab"
 *  return "a" , "a" ,"b" ;  "aa" , "b"
 *  自己想的时候思想有点复杂，需要好好体会这个解法。
 *  此外result, tempResult其实可以作为成员变量，就不用反复的传递了。
 */
public class PalindromePartitioning {


    public static void main(String args[]){
        PalindromePartitioning pp = new PalindromePartitioning();
        String a = "aab";
        String b = "abcba";
        System.out.println(pp.partition(a));
        System.out.println(pp.partition(b));
    }



    List<List<String>> result;
    List<String> tempResult;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        tempResult = new ArrayList<>();
        backTracking(s , 0);
        return  result;
    }


    public void backTracking(String s , int left ){
        if(tempResult.size()>0 && left >= s.length()){
            result.add(new ArrayList<>(tempResult));
            return;
        }else{
            for( int i = left; i < s.length(); i++){
                if(this.isPalidrome(s,left ,i)){
                    tempResult.add(s.substring(left,i+1));
                    backTracking(s, i+1);
                    tempResult.remove(tempResult.size()-1);
                }
            }
        }
    }

    private boolean isPalidrome(String s , int from , int end){

        while(from <= end){
            if(s.charAt(from) == s.charAt(end)){
                from++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }

}
