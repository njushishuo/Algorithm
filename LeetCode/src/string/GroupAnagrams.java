package string;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */
public class GroupAnagrams {

    public static void main(String args[]){
        GroupAnagrams ga = new GroupAnagrams();
        String[] strs = {"eat",  "tan", "ate", "nat", "bat" ,"tea"};
        String[] strs1 = {"boo","bob","jab"};
        System.out.println(ga.groupAnagrams(strs));
        System.out.println(ga.groupAnagrams(strs1));
    }

    /**
     * 普通的思路，key采用的构造方法是排序后的字符串
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String , List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for(int i = 0; i < strs.length; i++){

            char [] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            StringBuilder stringBuilder = new StringBuilder();
            for(int j = 0; j < temp.length; j++ ){
                stringBuilder.append(temp[j]);
            }
            String key = stringBuilder.toString();

            if(!map.containsKey(key)){
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key,list);
            }else{
                List<String> list = map.get(key);
                list.add(strs[i]);
            }

        }
        for(Map.Entry<String , List<String>> entry : map.entrySet()){
            result.add(entry.getValue());
        }

        return result;
    }

    /**
     * 优化在于key的构造，这是一种简单的hash思路；
     * PRIMES是质数数组，意味着如果一个数是有几个质数相乘获得的，那么可能组合是唯一的；
     * 节省了对char数组进行排序和构造stringBuilder的时间。
     * key *= PRIMES[c-'a'];
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagramsBetter(String[] strs) {
        final int[] PRIMES = new int[]{2, 3, 5, 7, 11 ,13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 107};
        Map<Integer,List<String>> map  = new HashMap<>();
        List<List<String>> mainList = new ArrayList<>();

        for(String s : strs) {

            int mapping = 1;

            char[] tempCharArray = s.toCharArray();

            for(char c : tempCharArray) {
                mapping *= PRIMES[c-'a'];
            }

            List<String> tempListRef = map.get(mapping);
            if(tempListRef == null) {
                tempListRef = new ArrayList<>();
                tempListRef.add(s);
                map.put(mapping,tempListRef);
                mainList.add(tempListRef);
            }else {
                tempListRef.add(s);
            }


        }

        return mainList;
    }
}
