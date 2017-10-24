package dynamic_programing;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Input: "cbbd"
   Output: "bb"
 */
public class LongestPalindromicSubstring {


    public static void main(String args[]){
        String a = "babad";
        String b = "cbbd";
        String c = "esbtzjaaijqkgmtaajpsdfiqtvxsgfvijpxrvxgfumsuprzlyvhclgkhccmcnquukivlpnjlfteljvykbddtrpmxzcrdqinsnlsteonhcegtkoszzonkwjevlasgjlcquzuhdmmkhfniozhuphcfkeobturbuoefhmtgcvhlsezvkpgfebbdbhiuwdcftenihseorykdguoqotqyscwymtjejpdzqepjkadtftzwebxwyuqwyeegwxhroaaymusddwnjkvsvrwwsmolmidoybsotaqufhepinkkxicvzrgbgsarmizugbvtzfxghkhthzpuetufqvigmyhmlsgfaaqmmlblxbqxpluhaawqkdluwfirfngbhdkjjyfsxglsnakskcbsyafqpwmwmoxjwlhjduayqyzmpkmrjhbqyhongfdxmuwaqgjkcpatgbrqdllbzodnrifvhcfvgbixbwywanivsdjnbrgskyifgvksadvgzzzuogzcukskjxbohofdimkmyqypyuexypwnjlrfpbtkqyngvxjcwvngmilgwbpcsseoywetatfjijsbcekaixvqreelnlmdonknmxerjjhvmqiztsgjkijjtcyetuygqgsikxctvpxrqtuhxreidhwcklkkjayvqdzqqapgdqaapefzjfngdvjsiiivnkfimqkkucltgavwlakcfyhnpgmqxgfyjziliyqhugphhjtlllgtlcsibfdktzhcfuallqlonbsgyyvvyarvaxmchtyrtkgekkmhejwvsuumhcfcyncgeqtltfmhtlsfswaqpmwpjwgvksvazhwyrzwhyjjdbphhjcmurdcgtbvpkhbkpirhysrpcrntetacyfvgjivhaxgpqhbjahruuejdmaghoaquhiafjqaionbrjbjksxaezosxqmncejjptcksnoq";
        String d = "cbbc";

//        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
//        System.out.println(lps.longestPalindrome(a));
//        System.out.println(lps.longestPalindrome(b));
//        System.out.println(lps.longestPalindrome(c));
//        System.out.println(lps.longestPalindrome(d));

        SolutionDP solutionDP = new SolutionDP();
        System.out.println(solutionDP.longestPalindrome(a));
        System.out.println(solutionDP.longestPalindrome(b));
        System.out.println(solutionDP.longestPalindrome(c));
        System.out.println(solutionDP.longestPalindrome(d));


        SolutionSimple solutionSimple = new SolutionSimple();
        System.out.println(solutionSimple.longestPalindrome(a));
        System.out.println(solutionSimple.longestPalindrome(b));
        System.out.println(solutionSimple.longestPalindrome(c));
        System.out.println(solutionSimple.longestPalindrome(d));

    }


    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return s;
        }

        StringBuilder sBuilder = new StringBuilder(s);
        StringBuilder aBuilder = new StringBuilder(s);
        aBuilder.reverse();

        if(sBuilder.toString() .equals( aBuilder.toString())){
            return s;
        }

        String common = this.findLongestCommonSubString(sBuilder.toString(),sBuilder.length() , aBuilder.toString() ,aBuilder.length());
        String reverseCommon = new StringBuilder(common).reverse().toString();
        while(common.charAt(0) != common.charAt(common.length()-1)){
            int index = sBuilder.indexOf(common);
            sBuilder.delete(index , index+common.length());
            index = sBuilder.indexOf(reverseCommon);
            sBuilder.delete(index , index+common.length());

            aBuilder = new StringBuilder(sBuilder.toString());
            aBuilder.reverse();

            common = this.findLongestCommonSubString(sBuilder.toString(),sBuilder.length() , aBuilder.toString() ,aBuilder.length());
            reverseCommon = new StringBuilder(common).reverse().toString();
        }

        return common;
    }

    public String findLongestCommonSubString(String A, int n, String B, int m) {
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

        StringBuilder result = new StringBuilder();
        //print substring
        while(max_i>=1 && max_j >=1 && dp[max_i][max_j]>0){
            result.insert(0,a[max_i-1]);
            max_i--;
            max_j--;
        }

        return result.toString();
    }




    private static class SolutionDP{


        /**
         * 思路： dp[i][j] = 1，0 表示 s[i,j]是否是对称的
         *       dp[i][j] = {
         *           1 (i == j);
         *           1 (si == sj && dp[i+1][j-1] == 1)
         *           0 (其他)
         *       }
         *       注意构建dp的顺序
         * @param s
         * @return
         */
        public String longestPalindrome(String s) {
            if(s == null || s.length() == 0){
                return s;
            }

            int [][]dp = new int [s.length()][s.length()];
            for(int i = 0;i < dp.length; i++){
                dp[i][i] = 1;
            }

            int max = 1;
            int left = 0;
            int right = 0;
            for(int i = dp.length-2; i >=0 ; i--){
                for(int j = i+1; j < dp[0].length; j++){
                    if(s.charAt(i) == s.charAt(j) && (i+1 == j || dp[i+1][j-1] == 1)){
                        dp[i][j] = 1;
                        if(max < j-i+1 ){
                            max = j-i+1;
                            left = i;
                            right = j;
                        }
                    }else{
                        dp[i][j] = 0;
                    }
                }
            }
            return s.substring(left,right+1);
        }
    }


    private static class SolutionSimple{


        /**
         * 思路： 对称中心扩展法，对称中心共 n + n-1 个
         * @param s
         * @return
         */
        public String longestPalindrome(String s) {
            if(s == null || s.length() == 0){
                return s;
            }

            int max = 1;
            int left = 0 , right = 0;
            for(int i = 0; i < s.length(); i++){
                int len1 = this.expand(s,i,i);
                int len2 = this.expand(s,i,i+1);
                int len = Math.max(len1,len2);
                if(max < len){
                    max = len;
                    left = (len&1)==0? i-len/2+1 : i-len/2;
                    right = i+len/2;
                }

            }
            return s.substring(left,right+1);
        }

        public int expand(String s , int left , int right){

            while(left>=0 && right<=s.length()-1 && s.charAt(left) == s.charAt(right) ){
                left--;
                right++;
            }

            return right-left-1;
        }



    }




}
