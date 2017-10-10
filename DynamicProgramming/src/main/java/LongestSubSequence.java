/**
 * 最长公共字符串与最长公共序列问题
 * 采用动态规划的算法
 */
public class LongestSubSequence {

    /**
     *
     * @param A 第一个字符串
     * @param n 第一个字符串的长度
     * @param B 第二个字符串
     * @param m 第二个字符串的长度
     * @return  最长公共序列的长度
     * 注意区别 最长公共子串的算法
     * 采用动态规划算法
     * 核心思想：S1: x1,x2,x3,,,xn ; S2: y1,y2,y3,,,ym
     * 令 c[i,j]表示 S1从x1到xi的部分 与 S2 从y1到yj的部分的最长公共子串的长度
     * 则：
     * c[i,j] = c[i-1,j-1]+1  （若xi=yj）
     * c[i,j] = max( c[i-1,j],c[i,j-1] ) (若xi!=yj)
     *
     *
     */
    public int findLongestCommmonSubSequence(String A, int n, String B, int m) {
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

//        for(int i=0;i<n+1;i++){
//            for(int j=0;j<m+1;j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.print("\n");
//        }

        return max;
    }




    public static void main(String[] args) {
        LongestSubSequence main = new LongestSubSequence();
        System.out.print(main.findLongestCommmonSubSequence("ABCAD",5,"AABCD",5));
    }
}
