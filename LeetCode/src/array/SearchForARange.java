package array;

/**
 * https://leetcode.com/problems/search-for-a-range/description/
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example:
 * Given [5, 7, 7, 8, 8, 10] and target value 8
 * return [3, 4].
 */
public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int [] result = new int [2];
        int index = -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            }
            boolean isRotated = nums[left] > nums[right];

            if(nums[mid] > target ){
                if( isRotated && nums[mid] >= nums[left] && nums[left] > target)
                    left = mid+1;
                else
                    right = mid-1;
            }else{
                if( isRotated && nums[mid] <= nums[left] && nums[right] < target )
                    right = mid-1;
                else
                    left = mid+1;
            }
        }

        if(index == -1){
            result[0] = -1;
            result[1] = -1;
            return result;
        }

        int i = index-1 , j = index+1;
        while(i>=0 && nums[i] == target){
            i--;
        }

        while(j<nums.length && nums[j] == target){
            j++;
        }
        result[0] = i+1;
        result[1] = j+1;
        return result;
    }
}
