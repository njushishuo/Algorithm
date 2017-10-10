package array;

/**
 *https://leetcode.com/problems/find-peak-element/solution/
 * 找到峰值；
 * 1. 递减
 * 2. 递增
 * 3. 曲折
 * 看清问题本质，因为只要求返回一个峰值下标即可。所以我们要不断地朝着高处靠拢
 *
 */
public class FindPerkElement {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
