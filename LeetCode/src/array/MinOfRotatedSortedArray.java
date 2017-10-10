package array;

/**
 *https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 * 以下是我的解法：
 * 想法比较简单易懂： e.g. input: 45670123
 * 我们先考虑待搜索的数组长度为1的情况，直接返回；
 * 再考虑长度为2的情况，返回较小者即可；
 * 再考虑长度大于等于3的情况，一种是直接命中转折点（两种形式一种在7 一种在0），另一种是在左半边或者右半边的时候,此时要考虑nums[mid]与最后一个数字的大小
 *    如果比最后一个数字小，那么只有两种可能，一种是没有旋转；另一种是旋转了并且此时位于右半边，这两种情况都可以将搜索范围缩小到左半边；
 *    如果比最后一个数字大，那么只有一种可能，数组被旋转过且当前位于左半边，因此将搜索范围缩小到右半边。
 */
public class MinOfRotatedSortedArray {

    public int findMin(int[] nums) {
        return findMinRecursive(nums,0,nums.length-1);
    }

    public int findMinRecursive(int [] nums , int left ,int right){
        if(left == right){
            return nums[left];
        }

        int mid = (left+right)/2;

        if(mid==left){
            return nums[left]<nums[right] ?  nums[left] :nums[right] ;
        }

        if( nums[mid-1]<nums[mid]&&nums[mid]>nums[mid+1]){
            return nums[mid+1];
        }else if( nums[mid-1]>nums[mid]&&nums[mid]<nums[mid+1]){
            return nums[mid];
        }else{
            if( nums[mid] > nums[right]){
                return findMinRecursive(nums, mid+1 , right);
            }else{
                return findMinRecursive(nums, left , mid -1);
            }
        }

    }


    public int findMinLoop(int[] nums){
        int start=0,end=nums.length-1;

        while (start<end) {
            if (nums[start]<nums[end])
                return nums[start];

            int mid = (start+end)/2;

            if (nums[mid]>=nums[start]) {
                start = mid+1;
            } else {
                end = mid;
            }
        }

        return nums[start];
    }
}
