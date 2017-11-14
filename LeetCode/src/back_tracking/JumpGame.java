package back_tracking;

/**
 * https://leetcode.com/problems/jump-game/description/
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 *
 *
 * 首先尝试回溯，超时了。。
 * 再尝试dp, 也超时了。。。
 */
public class JumpGame {

    public static void main(String args[]){
        int [] input1 = {2,3,1,1,4};
        int [] input2 = {3,2,1,0,4};
        JumpGame jg = new JumpGame();
        SolutionDP solutionDP = new SolutionDP();
        System.out.println(jg.canJump(input1));
        System.out.println(jg.canJump(input1));
        System.out.println(solutionDP.canJump(input2));
        System.out.println(solutionDP.canJump(input2));
    }


    private boolean canJump = false;

    public boolean canJump(int[] nums) {
        canJump = false;

        if(nums == null){
            return false;
        }

        if(nums != null && nums.length == 1){
            return true;
        }

        backTracking(nums,0);
        return canJump;
    }

    public void backTracking(int [] nums, int curIndex){
        if(canJump){
            return;
        }

        if(curIndex == nums.length-1){
            canJump = true;
        }

        if(curIndex < nums.length){
            if(nums[curIndex] == 0){
                return;
            }

            for( int i = nums[curIndex]; i >=1 ; i--) {
                backTracking(nums,curIndex+i);
            }
        }
    }

    private static class SolutionDP {
        public boolean canJump(int[] nums) {
            boolean [] dp = new boolean[nums.length];
            dp[nums.length-1] = true;

            for(int i = dp.length-2 ; i >= 0; i--){
                for( int j = 1; j <= nums[i]; j++){
                    if(i+j == nums.length-1 || (i+j < nums.length && dp[i+j])){
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[0];
        }
    }

    private static class SolutionGreedy {
        public boolean canJump(int[] nums) {
            int leftMostIndex = nums.length-1;
            for(int i = nums.length-2 ; i >= 0; i--){
                if(i+nums[i]>=leftMostIndex){
                    leftMostIndex = i;
                }
            }
            return leftMostIndex == 0;
        }
    }

}
