package array;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 */
public class SearchInRotatedSortedArray {



    public static void main(String args[]){
        int [] nums = new int []{5,1,3};
        int target = 3;
        int [] nums1 = new int []{5,1,3};
        int target1 = 5;
        int [] nums2 = new int []{4,5,6,7,0,1,2};
        int target2 = 7;
        int [] nums3 = new int []{4,5,6,7,8,1,2,3};
        int target3 = 8;
        int [] nums4 = new int []{5,1,2,3,4};
        int target4 = 1;
        int [] nums5 = new int []{3,1};
        int target5 = 1;

        SearchInRotatedSortedArray si = new SearchInRotatedSortedArray();
        System.out.println(si.search(nums,target) +","+ si.searchBetter(nums,target)+","+si.searchNew(nums,target));
        System.out.println(si.search(nums1,target1)+","+ si.searchBetter(nums1,target1)+","+si.searchNew(nums1,target1));
        System.out.println(si.search(nums2,target2)+","+ si.searchBetter(nums2,target2)+","+si.searchNew(nums2,target2));
        System.out.println(si.search(nums3,target3)+","+ si.searchBetter(nums3,target3)+","+si.searchNew(nums3,target3));
        System.out.println(si.search(nums4,target4)+","+ si.searchBetter(nums4,target4)+","+si.searchNew(nums4,target4));
        System.out.println(si.search(nums5,target5)+","+ si.searchBetter(nums5,target5)+","+si.searchNew(nums5,target5));
    }

    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        return binarySearch(nums,0,nums.length-1,target);

    }

    private int binarySearch( int [] nums , int left , int right , int target){
        if(left > right){
            return -1;
        }else{
            boolean isRotated = nums[left] > nums[right];
            int mid = (left+right)/2;

            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target ){
                if( isRotated && nums[mid] >= nums[left] && nums[left] > target)
                    return binarySearch(nums,mid+1,right,target);
                else
                    return binarySearch(nums,left,mid-1,target);
            }else{

                if( isRotated && nums[mid] <= nums[left] && nums[right] < target )
                    return binarySearch(nums,left,mid-1,target);
                else
                    return binarySearch(nums,mid+1,right,target);
            }
        }
    }


    public int searchBetter(int [] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            boolean isRotated = nums[left] > nums[right];

            //其实很简单，按照未旋转的判断方法，mid比较大，希望寻找更小的数字，那么一般情况下都需要往左找，什么时候需要往右找呢？
            //当处于旋转的左半侧并且left > target的时候，需要到包含右半侧的地方继续寻找； 注意等号
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
        return -1;
    }



    public int searchNew(int [] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            boolean isRotated = nums[left] > nums[right];

            if(!isRotated){
                if(nums[mid] > target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                // left half
                if(nums[mid] >= nums [left]){
                    if(nums[mid] > target){
                        if( nums[left] <= target){
                            right = mid - 1;
                        }else{
                            left = mid + 1;
                        }
                    }else{
                        left = mid + 1;
                    }
                }else{
                    if(nums[mid] < target){
                        if( nums[right] >= target){
                            left = mid + 1;
                        }else{
                            right = mid - 1;
                        }
                    }else{
                        right = mid - 1;
                    }
                }
            }
        }
        return -1;
    }

}
