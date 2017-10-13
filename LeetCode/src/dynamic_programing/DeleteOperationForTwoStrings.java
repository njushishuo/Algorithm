package dynamic_programing;

/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/description/
 * 每次只能删除一个字符，求使两个字符串相等的最小步骤数
 * Input: "sea", "eat"
   Output: 2
   Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".

   本质上就是找出最长公共子序列的长度
 */
public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int commonLen = this.findLongestCommmonSubSequence(word1,n,word2,m);
        return n+m-commonLen*2;
    }


    private int findLongestCommmonSubSequence(String A, int n, String B, int m) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int[][] dp = new int[n+1][m+1];
        int max = 0;
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if(a[i-1]==b[j-1])
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                    if(max<dp[i][j])
                        max=dp[i][j];
                }else{

                    if(dp[i-1][j]>dp[i][j-1]){
                        dp[i][j]=dp[i-1][j];
                    }else{
                        dp[i][j]=dp[i][j-1];
                    }
                }
            }
        }//for
        return max;
    }
}
