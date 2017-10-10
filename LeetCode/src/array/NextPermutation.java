package array;

/**
 * https://leetcode.com/problems/next-permutation/description/
 * 输入: int []  e.g  1,2,3
 * 输出: 下一个全排列 2,1,3
 * 没想到最后写出一个O(n)的算法 ..
 * 思路：
 *     我们要找到比当前的排列数稍稍大一点的排列。
 *     怎么变得稍稍大一点呢？把最右侧的位置由顺序变为逆序就可以了。
 *     对于已经出现的逆序，说明我们需要调整更高的位置，来获得更大的排列；
 *     left的停止位置，就是需要调整的高位的下标; 此时，从left+1开始数组是逆序的
 *     我们只需要将left与右侧的所有数字中，刚刚大于left的数字交换位置；此时数组从left+1开始依然是逆序的,
 *     我们还需要把left+1开始调整为正序.
 */
public class NextPermutation {

    public static void main(String args []){

        NextPermutation np = new NextPermutation();

        int [] input = {3,2,1};
        np.nextPermutation(input);

        for(int i=0;i<input.length;i++){
            System.out.print(input[i]+" ");
        }

    }


    public void nextPermutation(int[] nums) {

        if(nums==null || nums.length<=1){
            return;
        }

        int left = nums.length-2;
        int right = nums.length-1;
        while(left>=0 && nums[left] >= nums[right]){
            left--;
            right--;
        }

        if(left<0){
            this.reverse(nums,0);
            return;
        }else{

            int i=nums.length-1;
            for(;i>left;i--){
                if(nums[i]>nums[left]){
                    break;
                }
            }
            this.swap(nums,left,i);
            this.reverse(nums,left+1);
        }
    }

    private void swap(int[] nums , int i , int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    private void reverse(int[] nums , int start){
        int i=start, j=nums.length-1;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
}
