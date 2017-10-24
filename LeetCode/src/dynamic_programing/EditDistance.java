package dynamic_programing;

/**
 * https://leetcode.com/submissions/detail/124325663/
 *
 * 最少的步骤将 word1 转化为 word2
 * 每次可采取的操作： add a char , delete a char , modify a char
 * dp[i][j]: 表示将 word1[0-i-1] 转化为 word2[0-j-1]所需的最小操作数
 * {
 *     dp[i][0] = i 将word1[0-i-1]转化为""所需的操作数
 *     dp[0][j] = j 将""转化为 word2[0-j-1]所需的操作数
 *     dp[i][j] = dp[i-1][j-1] ,word1[i-1] == word2[j-1]
 *     dp[i][j] =  dp[i-1][j-1] + 1 将word1[0-i-2]转化为word2[0-j-2] 并修改word1最后一个元素为word2最后一个元素
 *              =  dp[i-1][j] + 1 将word1[0-i-2]转化为 word2 并删除word1最后一个元素
 *              =  dp[i][j-1] + 1 将word1转化为 word2[0-j-2] 并添加word2最后一个元素
 * }
 */
public class EditDistance {



    public int minDistance(String word1, String word2) {

        if(word1.length() == 0){
            return word2.length();
        }

        if(word2.length() == 0){
            return word1.length();
        }

        int dp [][]  = new int [word1.length()+1][word2.length()+1];
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = i;
        }

        for(int i = 0; i < dp[0].length; i++){
            dp[0][i] = i;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] =  Math.min( Math.min( dp[i-1][j-1]+1 ,dp[i-1][j]+1) , dp[i][j-1]+1 );
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
