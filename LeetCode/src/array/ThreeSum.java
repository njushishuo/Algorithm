package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  区别于twosum 要求返回三个数组中的值和为0,返回所有可能的组合，不能重复
 *  Your runtime beats 96.97 % of java submissions.   Yeah!
 *  注意可能存在重复的元素
 *  可以获得O(n2)的时间复杂度
 */
public class ThreeSum {


    public static void main(String args[]){
        ThreeSum threeSum = new ThreeSum();
        int [] input = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        List<List<Integer>> result =  threeSum.threeSum(input);
        System.out.println(result);

    }

    public List<List<Integer>> threeSum(int[] nums) {

        //首先将数组排序，用于去重
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<nums.length-2;i++){

            //既然之前遇到一个一样的元素就直接忽略
            if(i==0|| (i>0 && nums[i]!=nums[i-1])) {
                int target = 0-nums[i];
                int m= i+1; int n= nums.length-1;

                //因为排好序了，所以可以使用双向搜索
                while(m<n){
                    if(nums[m]+nums[n]>target){
                        n--;
                    }else if(nums[m]+nums[n]<target){
                        m++;
                    }else{

                        //注意去重
                        if(m>0&&n<nums.length-1){
                            if( ! (nums[m]==nums[m-1]&&nums[n]==nums[n+1]) ){
                                List<Integer> temp = new ArrayList<>();
                                temp.add(nums[i]); temp.add(nums[m]); temp.add(nums[n]);
                                result.add(temp);
                            }
                        }else{
                            List<Integer> temp = new ArrayList<>();
                            temp.add(nums[i]); temp.add(nums[m]); temp.add(nums[n]);
                            result.add(temp);
                        }
                        m++; n--;
                    }
                }
            }
        }
        return result;
    }
}
