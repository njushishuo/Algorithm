package array;

/**
 * https://leetcode.com/problems/array-nesting/solution/
 *
 * 方法1: 遍历数组，将每一个元素作为开头
 * 方法2： 很明显，当以数组中某个元素作为开头后，必定会在某个时刻再次回到开头。（因为元素值不重复且范围是0-(N-1)）
 *        构成了一个环，以环上任何一个元素作为开头，都会将这些元素全部加入到选择的列表中去。因此我们可以考虑用一个数组来记录;
 *        注意将条件并写到for循环的条件判断中时要谨慎，因为一旦不满足条件，循环就退出了
 */
public class NestArray {


    public static  void main(String a[]){
        NestArray na = new NestArray();
        int [] input = {5,4,0,3,1,6,2};
        int [] input1 = {1,0,3,4,2};
        int [] input2 = {0,1,2};
        int result = na.arrayNestingWithVisitedArrayItself(input2);
        System.out.println(result);
    }

    public int arrayNesting(int[] nums) {
        int result =0;
        for(int i=0;i<nums.length;i++){
            int cur = i; int cnt =1;
            // 注意理解 nums[cur] != i; 没错只要不等于起点就说明还没有走到环的尽头
            while( nums[cur]!=i){
                cur = nums[cur];
                cnt++;
            }
            if(cnt>result){
                result = cnt;
            }
        }
        return result;
    }

    public int arrayNestingWithVisitedArray(int[] nums) {
        int result =0;
        int [] visitedArray = new int [nums.length];
        for(int i=0;i<nums.length;i++){

            //已经访问过的环都会标注为1；只走那些还没走过的环
            if(visitedArray[i]==1){
                continue;
            }
            int cur = i; int cnt =1;
            visitedArray[cur]=1;
            while( visitedArray[nums[cur]]==0){
                cur = nums[cur];
                cnt++;
                visitedArray[cur]=1;
            }
            if(cnt>result){
                result = cnt;
            }
        }
        return result;
    }


    public int arrayNestingWithVisitedArrayItself(int[] nums) {
        int result =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==Integer.MAX_VALUE){
                continue;
            }
            int cur = i; int cnt = 0;
            int next;
            do{
                next = nums[cur];
                nums[cur]=Integer.MAX_VALUE;
                cur = next;
                cnt++;
            }while(cur<nums.length&&nums[cur]!=Integer.MAX_VALUE);

            if(cnt>result){
                result = cnt;
            }
        }
        return result;
    }
}
