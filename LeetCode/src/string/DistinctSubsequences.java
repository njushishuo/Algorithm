package string;
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
 */
public class DistinctSubsequences {

    public static void main(String args [] ){
        DistinctSubsequences ds = new DistinctSubsequences();
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(ds.numDistinct(s,t));
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
                sBuilder.deleteCharAt(j);
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


        return 0;
    }

}
