package array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/missing-number/description/
 * 利用异或操作来消除所有匹配的下标和值 PS: 数组中最大的值一定是没有匹配的下标的，所以循环结束后
 *   xor = missIndex ^ n, 所以最后再 xor ^ n 即可获得 missIndex即missValue;
 */
public class MissingNumber {


    public static void main(String a[]){
        MissingNumber mn = new MissingNumber();
        int [] nums = {0,3,1,4};
        System.out.println(mn.missingNumber(nums));
    }


    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left =0 ; int right = nums.length-1;
        int mid ;
        while(left < right){
            mid = (left + right)/2;
            if(nums[mid] > mid){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        if(nums[left]>left) {
            return nums[left]-1;
        }else{
            return nums[left]+1;
        }
    }


    public int missingNumberXor(int[] nums) {
        int xor = 0;
        for( int i=0;i<nums.length;i++ ){
            xor ^= i ^ nums[i];
        }
        return xor ^ nums.length;
    }
}
