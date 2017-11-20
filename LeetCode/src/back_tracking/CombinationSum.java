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
        int target1 = 6;
        System.out.println(cs.combinationSum(candidates,target));
        System.out.println(cs.combinationSum(candidates,target1));
    }


    private List<List<Integer>> result;
    private List<Integer> tempList;
    private int [] candidates;
    private int target;
    private int curSum;

    public CombinationSum(){
        this.result = new ArrayList<>();
        this.tempList = new ArrayList<>();
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.tempList.clear();
        this.result.clear();
        this.candidates = candidates;
        this.target = target;
        this.curSum = 0;
        Arrays.sort(candidates);
        backTrack( 0 );
        return  result;
    }

    public void backTrack(int fromIndex){

        if(curSum == target){
            result.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = fromIndex; i < candidates.length ; i++){
            if(curSum + candidates[i] <= target){
                tempList.add(candidates[i]);
                curSum += candidates[i];
                backTrack(i);
                tempList.remove(tempList.size()-1);
                curSum -= candidates[i];
            }else{
                break;
            }
        }
    }


}
