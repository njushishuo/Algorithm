package GoodIdea;

/**
 * Created by ss14 on 2017/5/17.
 *
 * 输入一个排序整数数组和一个整数，求该整数的重复次数
 * 思路：既然是排序的数组，我们就可以方便使用二分法定位一个数字
 * 那么这里是要求一个数字的重复次数，如果我们可以求出第一次出现的下标和最后一次出现的下标，问题不就解决了吗
 */
public class RepetitionInSortedArray {

    public int getRepetitionOf(int []a , int target){
        int firIdx,endIdx;

        firIdx = findFirstIndex(a,target,0,a.length-1);

        if(firIdx!=-1){
            endIdx = findLastIndex(a,target,0,a.length-1);
            return endIdx-firIdx+1;
        }
        return 0;
    }


    private int findFirstIndex(int []a ,int target , int start , int end){


        if(start>end){
            return -1;
        }

        int mid = (start+end)/2;
        if(a[mid]> target){
            return findFirstIndex(a,target,start,mid-1);
        }else if(a[mid]< target){
            return findFirstIndex(a,target,mid+1,end);
        }else{
            if(mid==0||(mid>0&&a[mid-1]!=target)){
                return mid;
            }else{
                return findFirstIndex(a,target,start,mid-1);
            }
        }
    }

    private int findLastIndex(int []a ,int target , int start , int end){

        if(start>end){
            return -1;
        }

        int mid = (start+end)/2;
        if(a[mid]> target){
            return findLastIndex(a,target,start,mid-1);
        }else if(a[mid]< target){
            return findLastIndex(a,target,mid+1,end);
        }else{
            if(mid==a.length-1||(mid<a.length-1&&a[mid+1]!=target)){
                return mid;
            }else {
                return findLastIndex(a, target, mid + 1, end);
            }
        }
    }


}
