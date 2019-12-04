/**
 * Created by ss14 on 2017/5/12.
 * 求一个整数数组的最大子序列的和
 * 要求： 数组不包含负数； 子序列中任意两个元素不相邻
 * https://leetcode.com/problems/house-robber/
 */
public class MaxSumOfNonadjacentSubSequence {

    /**
     * 利用动态规划思想，寻找问题之间的分解关系
     * 我们可以参考连续数组问题的思想，把问题聚焦到当前节点上。
     * 由于每个节点可能会被包含在最大和序列中也可能不会，所以我们需要两个值，
     * 分别记录包含当前节点的最大和 与 不包含当前节点的最大和
     * Inclu(i) Exclu(i)
     *
     * Inclu(i) = a[i] (i=0)
     * Exclu(i) = 0 (i=0)
     * Inclu(i) = Exclu(i-1) + a[i]  (i>=1)
     * Exclu(i) = max(Inclu(i-1) , Exclu(i-1)) (i>=1)
     * 由于没有负数，所以序列越长越好，故当i==a.length-1时，最大值会在Inclu 和 Exclu中产生
     *
     * 补充：该问题有个变体就是把数组改为循环链表，或者循环数组
     * 其实本质上就是多了 “第一个元素和最后一个元素是相邻的”的限制
     * 也就是说选了第一个元素就不要再选最后一个元素，或者选了最后一个元素就不要再选第一个元素
     * 转化为先求a[0]-a[n-2]的最大和；再求a[1]-a[n-1]的最大和；然后再比较一次
     * @param a
     * @return
     */
    int findMaximumSumofSubArray(int [] a){

        if(a == null || a.length == 0){
            return 0;
        }
        
        int inclu = a[0];
        int exclu = 0;
        int temp;

        for(int i=1 ; i<a.length;i++){
            temp = exclu + a[i];
            exclu = Math.max(inclu,exclu);
            inclu = temp;
        }

        return Math.max(exclu,inclu);
    }



}
