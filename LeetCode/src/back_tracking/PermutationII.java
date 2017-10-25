package back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  包含重复元素，返回去重后的全排列
 */
public class PermutationII {

    public static void main(String args []){
        PermutationII p = new PermutationII();
        int [] a = {1,1,2};
        System.out.println(p.permute(a));
    }

    public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            boolean used [] = new boolean[nums.length];
            backtrack(result,used, new ArrayList<>(), nums);
            return result;
        }
    private void backtrack(List<List<Integer>> result,boolean [] used, List<Integer> tempList, int [] nums){
            if(tempList.size() == nums.length){
                result.add(new ArrayList<>(tempList));
            } else{
                for(int i = 0; i < nums.length; i++){

                    if(used[i]) continue;
                    if(i>0 && nums[i] == nums[i-1] && !used[i-1]) continue;
                    used[i] = true;
                    tempList.add(nums[i]);
                    backtrack(result,used , tempList, nums);
                    tempList.remove(tempList.size() - 1);
                    used[i] = false;
                }
            }
    }

}
