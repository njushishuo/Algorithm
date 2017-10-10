package GoodIdea;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ss14 on 2017/5/16.
 * 输入: 正整数数组int [] a
 * 输出: 由数组中每一项拼接而成数字中最小的那个
 * 例如a ={3,31,32}
 * 输出 31323
 * 思路： 其实很简单，小的数字应该排在前面；
 * 何为较小呢？
 * 例如 3， 31
 * 要判断那个数“较小” ，其实就该比较 331 和 313的大小
 *
 */
public class MinNumFormedByArray {

    public static int minNumFormedByArray(int [] a){
        String [] nums = new String[a.length];
        for(int i=0;i<a.length;i++){
            nums[i] = a.toString();
        }

        Arrays.sort(nums,new StringComparetor());
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<a.length;i++){
            builder.append(nums[i]);
        }

        return Integer.parseInt(builder.toString());
    }




}
