package back_tracking;

import java.util.ArrayList;
import java.util.List;

/**
 *  不包含重复元素，返回全排列
 */
public class Permutation {

    public static void main(String args []){
        Permutation p = new Permutation();
        int [] a = {1,2,3};
        System.out.println(p.permute(a));
    }

    public List<List<Integer>> permute(int[] nums) {
        List result = new ArrayList();
        List<Integer> numList = new ArrayList<>();
        for(int i=0; i<nums.length ;i++){
            numList.add(nums[i]);
        }

        getPermutationR(nums,numList,null,result);
        return result;

    }


    private void getPermutationR(int [] nums , List<Integer> numList , List<Integer> temp , List result){
        if(temp != null && temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }


        for( int i = 0 ; i < numList.size(); i++){
            if(temp == null){
                temp = new ArrayList<>();
            }
            Integer tempNum = numList.get(i);
            temp.add(tempNum);
            numList.remove(tempNum);
            getPermutationR(nums,numList,temp,result);
            numList.add(i,tempNum);
            temp.remove(tempNum);
        }
    }


    private static class Solution{

        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            backtrack(result, new ArrayList<>(), nums);
            return result;
        }

        private void backtrack(List<List<Integer>> result, List<Integer> tempList, int [] nums){
            if(tempList.size() == nums.length){
                result.add(new ArrayList<>(tempList));
            } else{
                for(int i = 0; i < nums.length; i++){
                    if(tempList.contains(nums[i])) continue; // element already exists, skip
                    tempList.add(nums[i]);
                    backtrack(result, tempList, nums);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }
}
