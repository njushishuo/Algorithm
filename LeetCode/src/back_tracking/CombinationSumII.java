package back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/description/
 * 输入：候选int[] , int target
 * 输出: 所有整数list,使得各个元素来自候选数组且元素和等于target
 *
 * 候选数组中的每个元素只可以被使用一次，候选元素不一定唯一
 */
public class CombinationSumII {


    public static void main(String args[]){
        CombinationSumII cs = new CombinationSumII();
        Solution solution = new Solution();
        int [] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(cs.combinationSum(candidates,target));
        System.out.println(solution.combinationSum(candidates,target));
    }


    /**
     * 使用 fromIndex来避免 1 2 5, 2 1 5, 5 1 2这种问题
     * 使用 used[] 来避免 1 1 6, 1 2 5, 1 7, 1 2 5, 1 7这种问题
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        boolean [] used = new boolean[candidates.length];
        backTrack(candidates,target,result,used,new ArrayList<>(),0 , 0);
        return  result;
    }

    public void backTrack(int [] nums, int target, List<List<Integer>> result,boolean[] used,List<Integer> tempList, int curSum , int fromIndex){

        if(curSum == target){
            result.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = fromIndex; i < nums.length ; i++){
            if(used[i]) continue;
            if(i>0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            if(curSum + nums[i] <= target){
                tempList.add(nums[i]);
                used[i] = true;
                curSum += nums[i];
                backTrack(nums,target,result,used,tempList,curSum , i+1);
                tempList.remove(tempList.size()-1);
                curSum -= nums[i];
                used[i] = false;
            }
        }
    }

    /**
     * 用于对比,是否使用used[] 的区别
     */
    private static class Solution{
        public List<List<Integer>> combinationSum(int[] candidates, int target) {

            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(candidates);
           // boolean [] used = new boolean[candidates.length];
            backTrack(candidates,target,result,new ArrayList<>(),0 , 0);
            return  result;
        }

        public void backTrack(int [] nums, int target, List<List<Integer>> result,List<Integer> tempList, int curSum , int fromIndex){

            if(curSum == target){
                result.add(new ArrayList<>(tempList));
                return;
            }

            for(int i = fromIndex; i < nums.length ; i++){
                if(curSum + nums[i] <= target){
                    tempList.add(nums[i]);
                    curSum += nums[i];
                    backTrack(nums,target,result,tempList,curSum , i+1);
                    tempList.remove(tempList.size()-1);
                    curSum -= nums[i];
                }
            }
        }
    }


}
