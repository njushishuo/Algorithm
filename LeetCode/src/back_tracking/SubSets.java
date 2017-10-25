package back_tracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/description/
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 */
public class SubSets {

    public static void main(String args[]){
        SubSets subSets = new SubSets();
        Solution solution = new Solution();
        int nums [] = {1,2,3};

        System.out.println(subSets.subsets(nums));
        System.out.println(solution.subsets(nums));
    }


    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<=nums.length ; i++){
            backTrack(nums,result,new ArrayList<>(),i, 0);
        }
        return  result;
    }


    public void backTrack(int [] nums ,List<List<Integer>> result , List<Integer> tempList , int targetLength , int fromIndex ){
        if(tempList.size() == targetLength){
            result.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = fromIndex; i < nums.length ; i++){
            if(!tempList.contains(nums[i])){
                tempList.add(nums[i]);
                backTrack(nums,result,tempList,targetLength,i+1);
                tempList.remove(tempList.size()-1);
            }
        }


    }


    private static class Solution{
        public List<List<Integer>> subsets(int[] nums) {

            List<List<Integer>> result = new ArrayList<>();
            backTrack(nums,result,new ArrayList<>(), 0);
            return  result;
        }

        public void backTrack(int [] nums ,List<List<Integer>> result , List<Integer> tempList , int fromIndex ){

            result.add(new ArrayList<>(tempList));
            for(int i = fromIndex; i < nums.length ; i++){
                if(!tempList.contains(nums[i])){
                    tempList.add(nums[i]);
                    backTrack(nums,result,tempList,i+1);
                    tempList.remove(tempList.size()-1);
                }
            }


        }
    }
}
