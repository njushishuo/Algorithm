package array;


/**
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 * n+1个数字，每个数字取值 1-n ,找出那个唯一的重复的数字(重复次数可能>=2)
 *
 *  O(n) O(1)
 *
 * 将数组看做链表，每个元素值表示下一个节点的下标；采用寻找链表中的环的思路，很容易可以定位到环中的某个元素即相遇点。
 * 重点是，我们要寻找元素应该是环的入口节点,再找出了相遇点后如何找出环的入口呢？
 * 设从0到环的入口步长 x ,从环的入口到相遇点步长 a , 环的长度为c  相遇时i走了s步,有：
 *  2s = s + c*N (N=0,1,2,3...) => s = N*c
 *  s = x + a =>  N*c = x + a => x = N*c -a =>  x = (N-1)*c +  c-a
 *  最后一个等式表示：i j 相遇时, 从nums[0]到环的入口的距离 ==  环中从相遇点到入口的距离 + (N-1)*loop
 *  也就是说，此时将j移至0位置,然后 i和j 同时一步一步的移动，他们必然会相遇在环的入口。Amazing!  PS: nums[0]的入度为0,所以它永远位于环外.
 *
 */
public class FindDuplicate {


    public static void main(String args [] ){
        FindDuplicate fd = new FindDuplicate();
        int [] input = {1,3,4,2,2};
        int [] input1 = {2,5,9,6,9,3,8,9,7,1};
        System.out.println(fd.findDuplicate(input1));
    }


    public int findDuplicate(int[] nums) {
        int i=0,j=0;
        do{
            i = nums[i];
            j = nums[nums[j]];
        }while(i!=j);

        j=0;
        while(i!=j){
            i = nums[i];
            j = nums[j];
        }
        return i;
    }
}
