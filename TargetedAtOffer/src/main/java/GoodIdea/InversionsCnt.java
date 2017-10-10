package GoodIdea;

/**
 * Created by ss14 on 2017/5/17.
 * 输入: int [] a
 * 输出: 逆序对的数量
 *
 * 例如输入{5,7,3,4,8} 逆序对有{5,3}{5,4} {7,3}{7,4} 共4个
 * O(n^2)的方法是显而易见的
 * 这里我们考虑的是分解问题，对于一个数组，我们可以先分别统计左右两半的逆序对，然后再统计合并后的逆序对；
 * 例如: 7,5,6,3
 * 先看 7,5 包含一个逆序对
 * 再看 6,3 也包含一个逆序对
 * 那么对于7,5,6,3 我们要考虑逆序对时只要看符合这个性质的数对：(m,n) m来自左半边, n来自右半边;
 * 那么怎么计算合并后的逆序对呢？ 如果仍然两两比较的话，时间复杂度将会是O(n^2logn)
 * 我们可以考虑先将左右两部分排序，这样可以方便计算合并后新出现的逆序对；
 *
 * 分析下来，发现整个过程其实就是归并排序，外加上归并的时候，计算一下逆序对；
 *
 *
 */
public class InversionsCnt {

    public int cntInversions(int a[],int temp[], int left ,int right ){

        if(a==null || right<=left){
            return 0;
        }

        int mid = (left+right)/2;
        int cnt =0;

        cnt+=cntInversions(a,temp,left,mid);
        cnt+=cntInversions(a,temp,mid+1,right);

        cnt+=merge(a,temp,left,mid,right);

        return  cnt;
    }


    private int merge(int a[],int temp[],int left,int mid,int right){

        int cnt =0;
        int leftStart = left;
        int leftEnd = mid;
        int rightStart = mid+1;
        int rightEnd = right;

        int index= right;

        while(leftEnd>=leftStart && rightEnd>=rightStart){
            if(a[leftEnd]>a[rightEnd]){
                cnt+=rightEnd-rightStart+1;
                temp[index--]=a[leftEnd--];
            }else{
                temp[index--]=a[rightEnd--];
            }
        }

        while(leftEnd>=leftStart){
            temp[index--]=a[leftEnd--];
        }

        while(rightEnd>=rightStart){
            temp[index--]=a[rightEnd--];
        }

        for(int i=left;i<=right;i++){
           a[i]=temp[i];
        }
        return cnt;
    }



}
