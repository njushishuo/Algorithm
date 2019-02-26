package GoodIdea;

/**
 * Created by ss14 on 2017/5/16.
 * 快速排序所使用的partition算法
 * 所谓partition就是划分的意思；
 * 在快速排序中，我们递归地调用划分函数，
 * 先将数组划分为 小于pivot的部分 + pivot + 大于pivot的部分
 * 再递归地对左半部分和右半部分进行调用；
 * 注意使用该算法会修改输入的数组
 *
 * 在这里我们需要处理一些细节：
 * i , j 越界问题-> 控制好边界
 * 重复元素问题 -> 我们移动i越过那些小于pivot的元素， 其实可以考虑越过那些 小于或者等于pivot的元素
 *
 * 输入： int[] a ; int start ; int end
 * 输出:  排序后，选取的作为pivot的index
 */
public class PartitionHelper {

    /**
     * 本算法采用中间值作为pivot
     * @param a
     * @param start
     * @param end
     * @return 被选为pivot的元素在算法结束后在数组中的下标
     */
    public static int partition(int []a , int start , int end){
        int p = (start+end)/2;
        int pivot =a[p];
        swap(a,p,end);

        int i=start;
        int j=end-1;
        while(true){
            while(i<end&&a[i]<=pivot) {
                i++;
            }

            while(j>start&&a[j]>pivot){
                j--;
            }

            if(i<j){
                swap(a,i,j);
            }else{
                break;
            }
        }

        swap(a, i, end);
//        printArray(a);
        return i;
    }


    private static void  swap(int [] a , int i ,int j){
        int tem = a[i];
        a[i] = a[j];
        a[j] =tem;
    }



}
