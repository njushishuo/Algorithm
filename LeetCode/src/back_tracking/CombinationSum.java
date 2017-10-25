package back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/description/
 * 输入：候选int[] , int target
 * 输出: 所有可能的整数组合list,使得各个元素来自候选数组且元素和等于target
 *
 * 候选数组中的每个元素可以被重复使用，候选元素都是唯一的
 */
public class CombinationSum {


    public static void main(String args[]){
        CombinationSum cs = new CombinationSum();
        int [] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(cs.combinationSum(candidates,target));
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates,target,result,new ArrayList<>(),0 , 0 );
        return  result;
    }

    public void backTrack(int [] nums, int target, List<List<Integer>> result, List<Integer> tempList, int curSum , int fromIndex){

        if(curSum == target){
            result.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = fromIndex; i < nums.length ; i++){
            if(curSum + nums[i] <= target){
                tempList.add(nums[i]);
                curSum += nums[i];
                backTrack(nums,target,result,tempList,curSum,i);
                tempList.remove(tempList.size()-1);
                curSum -= nums[i];
            }
        }
    }


}
