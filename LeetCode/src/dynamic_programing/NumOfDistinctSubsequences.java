package dynamic_programing;
/**
 * https://leetcode.com/problems/distinct-subsequences/description/
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 *
 *
 * "aacaacca"
   "ca"
 *
 *  采用递归的算法，超时了。
 *  采用dp:
 *
 *  dp[i][j] = {
 *      dp[0][j] = 1 ("" 是任何字符串的子串)
 *      ap[i][0] = 0 (i>=1 ""除了""没有子串)
 *      dp[i][j-1]  (si != tj);
 *      dp[i-1][j-1] + dp[i][j-1]  (si == tj)
 *  }
 *
 *
 */
public class NumOfDistinctSubsequences {

    public static void main(String args [] ){
        NumOfDistinctSubsequences ds = new NumOfDistinctSubsequences();
        String s = "a";
        String t = "a";
        System.out.println(ds.numDistinct(s,t));
        System.out.println(ds.numDistinctDP(s,t));
    }

    public int numDistinct(String s, String t) {

        StringBuilder sBuilder = new StringBuilder(s);
        StringBuilder tBuilder = new StringBuilder(t);

        String firstChar = String.valueOf(tBuilder.charAt(0));
        int indexOfFirstChar = sBuilder.indexOf(firstChar);
        if(indexOfFirstChar == -1){
            return 0;
        }else{
            for(int j=0; j<indexOfFirstChar ; j++){
                sBuilder.deleteCharAt(0);
            }
        }

        int i = 0;
        while (i < tBuilder.length()) {

            String a = String.valueOf(tBuilder.charAt(i));
            int firstIndex = sBuilder.indexOf(a);

            if(firstIndex == -1) {
                return 0;
            }

            int lastIndex = sBuilder.lastIndexOf(a);
            if (firstIndex == lastIndex) {
                sBuilder.deleteCharAt(firstIndex);
                tBuilder.deleteCharAt(i);
            } else {
                i++;
            }
        }

        i = 0;
        while (i < sBuilder.length()) {
            String a = String.valueOf(sBuilder.charAt(i));
            if (tBuilder.indexOf(a) == -1) {
                sBuilder.deleteCharAt(i);
            } else {
                i++;
            }
        }

        s = sBuilder.toString();
        t = tBuilder.toString();
        if(s.length() == 0){
            return 1;
        }
        String a = String.valueOf(t.charAt(0));
        int firstIndex = s.indexOf(a);
        return numDistinctR(s.toString(),t.toString(),0 , firstIndex);

    }

    private int numDistinctR(String s, String t , int indexOfT , int fromIndex ){

        if(fromIndex == -1){
            return 0;
        }

        String a = String.valueOf(t.charAt(indexOfT));
        int result =0;
        for(int i = fromIndex ; i<s.length()&& i!=-1 ; i=s.indexOf(a,i+1)){

            if(indexOfT == t.length()-1){
                result += 1;
            }else{
                String nextChar = String.valueOf(t.charAt(indexOfT+1));
                int nextFromIndex = s.indexOf(nextChar,i+1);
                result += numDistinctR(s,t,indexOfT+1 ,nextFromIndex );
            }
        }

        return  result;
    }


    public int numDistinctDP(String s, String t){

        if(s == null || t == null){
            return 0;
        }

        int [][] dp  = new int [t.length()+1][s.length()+1];
        for(int i = 0 ; i<= s.length() ;i++){
            dp[0][i] = 1;
        }

        for(int i=1; i< dp.length ; i++){
            for( int j = 1; j<dp[0].length ; j++){
                if(t.charAt(i-1) == s.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+dp[i][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[t.length()][s.length()];
    }



}
