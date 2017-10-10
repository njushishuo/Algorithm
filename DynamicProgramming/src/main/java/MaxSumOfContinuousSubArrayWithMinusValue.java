/**
 * Created by ss14 on 2017/5/12.
 * 求一个整数数组的最大子数组的和
 * 要求： 数组可能包含负数； 子数组连续
 *
 */
public class MaxSumOfContinuousSubArrayWithMinusValue {


    /**
     * 利用动态规划思想，寻找问题之间的分解关系
     * 我们用f(i)表示以a[i]结尾的子数组的最大和
     * f(i) = a[i] (当f(i-1)<=0 或者 i=0)
     * f(i) = f(i-1)+ a[i] (当f(i-1)>0 且 i>0 时)
     * @param a
     * @return
     */
    int findMaximumSumofSubArray(int [] a){

        int curSum =a[0];
        int maxSum =0;
        for(int i=1;i<a.length;i++){
            if(curSum<=0){
                curSum = a[i];
            }else{
                curSum+=a[i];
            }
            if(curSum>maxSum){
                maxSum = curSum;
            }
        }
        return maxSum;
    }


}
