package array;

/**
 *https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
 * 考虑可能的重复
 * 111
 * 11234
 * 22233
 * 3322
 * 556444
 * 55663444444
 * 77894456
 * 31
 */
public class MinOfRotatedSortedArrayII {

    public int findMin(int[] nums) {
        int left =0; int right = nums.length-1;
        while(left<right){
            if(nums[left]<nums[right]){
                return  nums[left];
            }

            int mid = (left+right)/2;
            //只有两个数
            if(mid==left){
                return nums[left]<nums[right] ? nums[left]:nums[right];
            }

            if(nums[mid]<nums[right]){
                right = mid;
            }else if(nums[mid]>nums[right]){
                left =mid+1;
            }else{
                //在右侧，说明从mid至right都相等
                if(nums[left]>nums[mid]){
                    right = mid;
                //在左侧
                }else if(nums[left]<nums[mid]){
                    left = mid;
                }else{
                    //无法判断
                    right--;
                }

            }
        }
        return nums[left];
    }


    public int findMinSimple(int nums[] , int left ,int right){
        int min = nums[left];
        for(int i=left+1; i<=right ;i++){
            if(nums[i]<min){
                min = nums[i];
            }
        }
        return min;
    }


}
