package dynamic_programing;

/**
 * https://leetcode.com/problems/maximum-subarray/description/
 *
 * dp[i] 表示从a0-ai的最大和
 * dp[i] = dp[i-1]+a[i] , dp[i-1]>0;
 * dp[i] = a[i];
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if(nums == null){
            return 0;
        }

        int dp [] = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for( int i = 1; i < nums.length; i++){
            if(dp[i-1] < 0){
                dp[i] = nums[i];
            }else{
                dp[i] = dp[i-1] + nums[i];
            }
            if(dp[i] > max){
                max = dp[i];
            }
        }

        return  max;
    }

    /**
     * 节省内存空间占用
     * @param nums
     * @return
     */
    public int maxSubArrayBetter(int[] nums) {
        if(nums == null){
            return 0;
        }
        int curMax = nums[0];
        int max = nums[0];
        for( int i = 1; i < nums.length; i++){
            if(curMax < 0){
                curMax = nums[i];
            }else{
                curMax += nums[i];
            }
            if(curMax > max){
                max = curMax;
            }
        }

        return  max;
    }
}
