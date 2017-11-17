package dynamic_programing;

/**
 * https://leetcode.com/problems/decode-ways/description/
 * 思路:
 *    动态规划思想,对于一个字符串a, 我们用dp[i]表示从a[i]-a[a.length-1]这段字符串可以被解码的方法数；
 *    那么我们思考a[i]的值与a[i-1]的关系：
 *    显然，如果a[i]a[i+1]可以连起来看的话 a[i] = a[i+1] + a[i+2] 不连看+连看的总解码方法数;
 *         如果 a[i]a[i+1]不可以连看 a[i] =  a[i+1]
 *    除此之外需要考虑'0'这种特殊情况; 因为'0'无法解法 它只可能与'1'或者'2'构成 “10”  “20”来看
 *    如果a[i]=0  dp[i]表示以0开头的字符串，显然是无法解码的故dp[i]=0;
 *
 *    注意初始化，dp长度为a长度+1, dp[a.length]=1，表示当 dp[a.length-1]可以连看时的情况
 *
 *    技巧： 使用(s.charAt(i)-'0')*10 + (s.charAt(i+1)-'0') 来代替   Integer.valueOf(subStr) 提高效率
 */
public class DecodeWays {


    public static void main(String args []){
        DecodeWays dw = new DecodeWays();
        System.out.println(dw.numDecodings("101"));
        System.out.println(dw.numDecodingsDP("101"));
        System.out.println(dw.numDecodingsDPII("101"));
    }


    public int numDecodings(String s) {
        if(s == null || s.length() ==0){
            return 0;
        }

        return numDecodingsR(s,0);
    }

    //mind 0
    public int numDecodingsR(String s , int i){

        if(i >= s.length()){
            return 1;
        }

        if(!isValid(s.charAt(i))){
            return 0;
        }

        if(i == s.length()-1){
            return  1;
        }else{
            String twoChars = s.substring(i,i+2);
            int value = Integer.parseInt(twoChars);
            if(value >=1 && value <=26){
                return numDecodingsR(s,i+1) + numDecodingsR(s,i+2);
            }else{
                return numDecodingsR(s,i+1);
            }
        }
    }



    public int numDecodingsDP(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int dp [] = new int [s.length()+1];
        dp[dp.length-1] = 1;
        dp[dp.length-2] = this.isValid(s.charAt(s.length()-1)) ? 1 : 0 ;
        for(int i=s.length()-2; i>=0; i--){

            if(this.isValid(s.charAt(i))){
                String twoChars = s.substring(i,i+2);
                int value  = Integer.valueOf(twoChars);
                if(value >=1 && value <=26){
                    dp[i] = dp[i+2]+dp[i+1];
                } else{
                    dp[i] = dp[i+1];
                }
            }else{
                if(i==0){
                    return 0;
                }else{
                    dp[i] = 0;
                }
            }
        }

        return dp[0];
    }


    public int numDecodingsDPII(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        if(s.charAt(0)=='0'){
            return 0;
        }

        int dp [] = new int [s.length()+1];
        dp[dp.length-1] = 1;
        dp[dp.length-2] = s.charAt(s.length()-1)!='0' ? 1 : 0 ;
        for(int i=s.length()-2; i>=0; i--){
            if(s.charAt(i) !='0'){
                int value  = (s.charAt(i)-'0')*10 + (s.charAt(i+1)-'0');
                if(value >=10 && value <=26){
                    dp[i] = dp[i+2]+dp[i+1];
                } else{
                    dp[i] = dp[i+1];
                }
            }else{
                dp[i] = 0;
            }
        }

        return dp[0];
    }


    private boolean isValid(char a){
        if( a >= '1' && a <='9'){
            return true;
        }
        return false;
    }




}
