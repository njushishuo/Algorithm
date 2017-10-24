/**
 * Created by ss14 on 2017/4/26.
 */
public class LongestCommonSubString {


    public int findLongestCommonSubStringBad(String A, int n, String B, int m) {
        // write code here
        int a = 0;
        int b;
        int cnt;
        int result=0;
        while(a<n){
            System.out.println("a"+"["+a+"]:"+A.charAt(a)+"---------------");
            int a1 = a;
            cnt=0;
            b=0;
            while(a<n&&b<m){
                if( A.charAt(a)==B.charAt(b) ){
                    System.out.println("a"+"["+a+"]:"+A.charAt(a));
                    cnt++;
                    a++;
                    b++;
                    if(cnt>result){
                        result = cnt;
                    }
                }else{
                    if(cnt>0){
                        a=a1;
                        cnt=0;
                    }else{
                        b++;
                    }
                }
            }

//            if(a>=n){
//                return result;
//            }
            a=a1;
            a++;
        }
        return  result;
    }



    /**
     *
     * @param A 第一个字符串
     * @param n 第一个字符串的长度
     * @param B 第二个字符串
     * @param m 第二个字符串的长度
     * @return  最长公共子串的长度,即要求子串中字符连续出现不能间断
     * 注意区别 最长公共序列的算法
     * 采用动态规划算法
     * 核心思想：S1: x1,x2,x3,,,xn ; S2: y1,y2,y3,,,ym
     * 令 c[i,j]表示 S1从x1到xi的部分 与 S2 从y1到yj的部分的最长公共子串的长度
     * 则：
     * c[i,j] = 0 (若i=0 或 j=0)
     * c[i,j] = c[i-1,j-1]+1  （若xn=ym）
     * c[i,j] = 0 (若 xn!=yn)
     *
     * 把两个字符串分别以行和列组成一个二维矩阵。
     * 比较二维矩阵中行和列对应的每个点的字符是否相同，是设置这个点为1，否设置这个点为0。
     * 通过查找值为1的最长对角线来找到最长公共字符串。
     *
     */
    public int findLongestCommonSubStringGood(String A, int n, String B, int m) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int[][] dp = new int[n+1][m+1];
        int max = 0;
        int max_i=0;
        int max_j=0;
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if(a[i-1]==b[j-1])
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                    if(max<dp[i][j]){
                        max=dp[i][j];
                        max_i=i;
                        max_j=j;
                    }

                }
            }
        }//for

        //print matrix
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.print("\n");
        }

        String reverse = "";
        //print substring
        while(max_i>=1 && max_j >=1 && dp[max_i][max_j]>0){
            reverse+=a[max_i-1];
            max_i--;
            max_j--;
        }

        for(int i=reverse.length()-1;i>=0;i--){
            System.out.print(reverse.charAt(i));
        }
        System.out.print("\n");

        return max;
    }


    public static void main(String[] args) {
        LongestCommonSubString main = new LongestCommonSubString();
        System.out.print(main.findLongestCommonSubStringGood("ABCAD",5,"AABCD",5));
    }

    
}
