import java.util.HashSet;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * Given a string, find the length of the longest substring without repeating characters.
   Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String args[]){
        LongestSubstringWithoutRepeatingCharacters lswr = new LongestSubstringWithoutRepeatingCharacters();
        String a = "dvdf";
        String b = "abcabcbb";
        String c = "bbbbb";

        System.out.println(lswr.lengthOfLongestSubstring(a));
        System.out.println(lswr.lengthOfLongestSubstring(b));
        System.out.println(lswr.lengthOfLongestSubstring(c));


    }

    /**
     * use HashSet
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() == 0){
            return 0;
        }

        HashSet<Character> set = new HashSet<Character>();
        int max = 0;
        for(int i = 0; i < s.length(); i++){

            if(s.length()-i <= max){
                break;
            }

            set.clear();
            int tempLen = 0;
            for(int j = i; j < s.length() ;j++ ){
                char tempChar = s.charAt(j);
                if(!set.contains(tempChar)){
                    set.add(tempChar);
                    tempLen++;
                    if(tempLen > max){
                        max = tempLen;
                    }
                }else{
                    break;
                }
            }
        }
        return  max;
    }


    /**
     * Solution (DP, O(n)):
     *
     * Assume L[i] = s[m...i], denotes the longest substring without repeating
     * characters that ends up at s[i], and we keep a hashmap for every
     * characters between m ... i, while storing <character, index> in the
     * hashmap.
     * We know that each character will appear only once.
     * Then to find s[i+1]:
     * 1) if s[i+1] does not appear in hashmap
     *    we can just add s[i+1] to hash map. and L[i+1] = s[m...i+1]
     * 2) if s[i+1] exists in hashmap, and the hashmap value (the index) is k
     *    let m = max(m, k), then L[i+1] = s[m...i+1], we also need to update
     *    entry in hashmap to mark the latest occurency of s[i+1].
     *
     * Since we scan the string for only once, and the 'm' will also move from
     * beginning to end for at most once. Overall complexity is O(n).
     *
     * If characters are all in ASCII, we could use array to mimic hashmap.
     */

    public int lengthOfLongestSubstringDP(String s) {
        // for ASCII char sequence, use this as a hashmap
        /**
         *  int[26] for Letters 'a' - 'z' or 'A' - 'Z'
         *  int[128] for ASCII
         *  int[256] for Extended ASCII
         */
        int [] dp = new int [256];
        for( int i = 0; i < dp.length; i++){
            dp[i] = -1;
        }

        int longest = 0, m = 0;

        for (int i = 0; i < s.length(); i++) {
            m = Math.max(dp[s.charAt(i)] + 1, m);    // automatically takes care of -1 case
            dp[s.charAt(i)] = i;
            longest = Math.max(longest, i - m + 1);
        }

        return longest;
    }

}
