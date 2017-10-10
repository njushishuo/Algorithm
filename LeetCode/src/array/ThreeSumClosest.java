package array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/description/
 * 找到 和最接近 target的三个数，并返回他们的和
 * 每个元素只能使用一次，只有唯一解
 *
 * 需要理解一点：
 * 对于一个已经排序的数组，我们要寻找两个数字之和等于或者接近某个值的时候，
 * 可以使用双向逼近法，每次根据当前的值与target值的大小，可以排除掉一个数字的可能。
 * 对于此题，要求的是接近，因此是有可能移动下标时，使得相差的绝对值更大了，所以需要记录一个最小值，不断更新。
 * 这种逼近的方法，总是根据上次的情况来尝试最有可能的方案，其他可能但是不符合“最接近”的组合情况就不会再尝试了。
 */
public class ThreeSumClosest {


    public int threeSumClosest(int[] nums, int target) {
        //首先将数组排序，用于去重
        Arrays.sort(nums);
        int result = nums[0]+nums[1]+nums[2];
        int absGap = Math.abs(target-result);

        for(int i=0;i<nums.length-2;i++){

            //既然之前遇到一个一样的元素就直接忽略
            if(i==0|| (i>0 && nums[i]!=nums[i-1])) {
                int j = i+1;  int k = nums.length-1;
                while( j < k ){
                    int tempResult = nums[i]+nums[j]+nums[k];
                    int tempAbsGap = Math.abs(target-tempResult);
                    if( tempAbsGap < absGap){
                        absGap = tempAbsGap;
                        result = tempResult;
                        if(tempResult == target){
                            return  tempResult;
                        }
                    }
                    if(tempResult > target) {
                        k--;
                    }else{
                        j++;
                    }
                }
            }
        }
        return result;
    }


}
