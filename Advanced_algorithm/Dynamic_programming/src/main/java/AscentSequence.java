/**
 * Created by ss14 on 2017/4/26.
 */

/**
 * 对于一个数字序列，请设计一个复杂度为O(nlogn)的算法，返回该序列的最长上升子序列的长度，这里的子序列定义为这样一个序列U1，U2...，其中Ui < Ui+1，且A[Ui] < A[Ui+1]。
 * 给定一个数字序列A及序列的长度n，请返回最长上升子序列的长度。
 * 测试样例：
 * [2,1,4,3,1,5,6],7
 * 返回：4
 */
public class AscentSequence {


    /**
     *最长公共子序列法O(n^2)
     *这个问题可以转换为最长公共子序列问题。
     *如例子中的数组A{5，6， 7， 1， 2， 8}，
     *则我们排序该数组得到数组A'{1， 2， 5， 6， 7， 8}，
     *然后找出数组A和A'的最长公共子序列即可。
     *显然这里最长公共子序列为{5, 6, 7, 8}，也就是原数组A最长递增子序列。
     * @param A
     * @param n
     * @return
     */
    public int findLongestUsingLCS(int[] A, int n) {
        // write code here
        MergeSort mergeSort = new MergeSort();
        int temp [] = new int [A.length];
        int copy [] = new int [A.length];

        for(int i=0;i<A.length;i++){

            copy[i] = A[i];

        }
        //将排序后的A留在temp中
        mergeSort.mergeSort(A,temp);

        LongestCommonSubSequence longestSubSequence = new LongestCommonSubSequence();
        String a = "";
        String b = "";
        for(int i=0;i<A.length;i++){
            a+=A[i];
            b+=copy[i];
        }

        return longestSubSequence.findLongestCommmonSubSequence(a,A.length,b,copy.length);
    }


    /**
     * 采用动态规划思想 O(n^2)
     * 对于序列S: a1,a2,,,ai
     * 它的最长递增子序列，必然是在以a1,a2,,,ai结尾的递增子序列中的一个
     * 用dp[i]表示序列a1,a2,,,ai 中以ai结尾的最长递增子序列的长度
     * 则： dp[i]= max(dp[j])+1; 其中j<i 且 aj < ai
     * @param A
     * @param n
     * @return
     */
    public int findLongest(int[] A, int n){

        int dp[] = new int[n];
        dp[0]=1;
        int max; //每次确定一个dp[i]时使用
        int result=0; //最终结果
        for(int i=1; i<A.length;i++){
            max=1;
            //对于每个ai-1
            for(int j=0; j<i ;j++){
                if(A[j]<A[i] ){
                    //更新max
                    if(dp[j]+1>max){
                        max = dp[j]+1;
                    }
                }
            }
            //将max赋值给dp[i]
            dp[i]=max;
            //更新result
            if(max>result){
                result = max;
            }
        }

        for(int i=0;i<dp.length;i++){
            System.out.print(dp[i]+" ");
        }
        System.out.print("\n");
        return result;
    }

}

