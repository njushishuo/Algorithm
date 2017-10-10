package array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/
 * 输入: int [] nums >0,int s  PS: 数组的顺序不可变
 * 输出: int 如果nums中存在连续的子序列使得序列之和>=s , 则返回序列的长度 , 否则返回0
 * 方法一: 简单的O(n2)算法
 * 方法二:
 */

public class MinSubarraySum {


    public static void main(String args[]){
        MinSubarraySum ms = new MinSubarraySum();
        int s = 213;
        int [] nums = {12,28,83,4,25,26,25,2,25,25,25,12};
        System.out.println(ms.minSubArrayLen(s,nums));
    }


    public int minSubArrayLenSimple(int s, int[] nums) {
        int result = nums.length;
        for(int i=0;i<nums.length;i++){
            int sum=nums[i];
            int len =1;
            for(int j=i+1;j<nums.length&&sum<s;j++){
                sum+=nums[j];
                len++;
            }
            if(sum < s && len == nums.length){
                return 0;
            }
            if(sum >= s && len<result){
                result = len;
            }
        }
        return result;
    }

    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= s) {
                ans = Math.min(ans, i + 1 - left);
                sum -= nums[left++];
            }
            left = i+1;
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }
}
