package back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/description/
 *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 */
public class SubSetsII {

    public static void main(String args[]){
        SubSetsII subSets = new SubSetsII();
        int nums [] = {1,2,2};
        System.out.println(subSets.subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean [] used = new boolean[nums.length];
        backTrack(nums,result, used, new ArrayList<>(), 0);
        return  result;
    }

    public void backTrack(int [] nums ,List<List<Integer>> result ,boolean[] used,  List<Integer> tempList , int fromIndex ){
        result.add(new ArrayList<>(tempList));
        for(int i = fromIndex; i < nums.length ; i++){
            if(used[i]) continue;
            if(i>0 && nums[i] == nums[i-1] && !used[i-1]) continue; //  表示当前的下标现在是第一次使用，但是之前使用过与之数值相同但是下标不同的槽，这就说明，当前槽如果选中就会引起重复
            tempList.add(nums[i]);
            used[i] = true;
            backTrack(nums,result,used,tempList,i+1);
            tempList.remove(tempList.size()-1);
            used[i] = false;
        }
    }

}
