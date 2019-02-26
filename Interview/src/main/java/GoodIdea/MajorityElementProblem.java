package GoodIdea;

/**
 * Created by ss14 on 2017/5/16.
 * Majority Element:
 * A majority element in an array A[] of size n is an element
 *  that appears more than n/2 times (and hence there is at most one such element).
 *  Write a function which takes an array and emits the majority element (if it exists),
 *  otherwise returns -1;
 *  思想：
 *  1. 利用partition函数
 *  所谓majority element最重要的性质就是出现的次数超过数组长度的一半；
 *  也就是说它一定是数组的中位数（排序后，中间位置的数字，在cs中指 n/2 或者 (n-1)/2的位置）
 *  那么如何得到中位数呢？ 是否必须将整个数组都排好序才能知道中位数在哪呢？
 *  其实不必， 我们可以利用partition函数来将数组分割成三个部分，如果pivot在分割后的位置正好处于“中间”位置,那么此时a[p]就是我们要找的数字。
 *
 */
public class MajorityElementProblem {

    public int findMajority(int a[]){
        if(a==null){
            return -1;
        }

        int start = 0;
        int end = a.length-1;
        int mid =(start+end)/2;

        int index =PartitionHelper.partition(a,start,end);
        while(index!=mid){

            if(index>mid){
                end = index-1;  // 注意这里修改的是index
            }else{
                start = index+1;
            }
            index = PartitionHelper.partition(a,start,end);
        }

        if(isMajorityElement(a,a[index])){
            return a[index];
        }

        return -1;
    }

    private boolean isMajorityElement(int a[], int c){
        int cnt =0;
        for(int i=0;i<a.length;i++){
            if(a[i]==c){
                cnt++;
            }
        }

        if(cnt>a.length/2){
            return true;
        }

        return false;
    }



}
