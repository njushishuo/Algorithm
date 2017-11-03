package array;

/**
 * https://leetcode.com/problems/container-with-most-water/description/
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * 思路： 根本不需要O(n^2)的时间复杂度，事实上只需要O(n)
 *     首先最基本的优化： 记录lastLeftHeight , 我们是从最左边开始作为左侧的边，如果接下来的边长度小于等于之前选择过的边，那么这些边是不需要再考虑作为左侧的边的。
 *     我们期望的最大值是左边大，右边也大，所以我们的右边是从最右边开始选择，此时需要比较left与right的长度：
 *     1. H[left] <= H[right] 这意味着我们不需要再计算 j= left+1 ,j= left+2 ,, j=right-1的情况,因为当选择H[i]作为左边时，就决定了MaxHeight = H[i]。
 *        接下来只要考虑底的长度了，而此时j处于最右端 ，所以一定是最大值。我们可以省略一行的计算。
 *     2. H[left] > H[right] 这意味着我们不需要再计算  i= left+1 , i= left+2 ,, i=right-1的情况，因为这些值中MaxHeight = H[j]。
 *        接下来只要考虑底的长度，而此时i在最左侧，所以一定是这些可能中的最大值。我们可以省略一列的计算。
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea = 0;
        int lastLeftHeight = 0;
        int rightBound = height.length-1;
        for( int i = 0 ; i < height.length-1; i++) {

            if(height[i] <= lastLeftHeight){
                continue;
            }else{
                lastLeftHeight = height[i];
            }

            for (int j = rightBound; j >=0; j--) {

                if(height[j] > height[i]){
                    int tempArea = (j - i) * height[i];
                    if (tempArea > maxArea) {
                        maxArea = tempArea;
                    }
                    break;
                }else{
                    rightBound--;
                    int tempArea = (j - i) * Math.min(height[i] , height[j]);
                    if (tempArea > maxArea) {
                        maxArea = tempArea;
                    }
                }
            }
        }
        return maxArea;
    }


}
