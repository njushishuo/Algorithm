/**
 * Created by ss14 on 2017/3/21.
 * 递归思想
 * 首先选取一个标准值，然后将数组分为小于标准值的一部分和大于标注值的一部分
 * 然后对每个递归地调用同样的排序方法
 */
public class QuickSort {

    
    /**
     * 取pivot分为两部分，对左右递归
     * @param a
     */
    public void quickSort(int a[]){
        quickSort(a,0,a.length-1);
    }

    private void swapValue(int a[] ,int i ,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * 三值取中法确定pivot，并将较小的值放到a[0]，较大的值放到a[length-1]
     * @param a
     * @param left
     * @param right
     */
    private int choosePivot(int a[] , int left, int right){

        int center = (left+right)/2;

        if(a[left]>a[right]){
            swapValue(a,left,right);
        }

        if(a[left]>a[center]){
            swapValue(a,left,center);
        }

        if(a[center]>a[right]){
            swapValue(a,center,right);
        }
    
        swapValue(a,center,right);
        return a[right];

    }


    private void quickSort(int a[] ,int left, int right){
        //至少有三个元素
        if(left+2<=right){
            //pivot放在了right-1
            int pivot = choosePivot(a,left,right);

            int i= left;
            int j= right-1;

            while(true){

                while(a[i] < pivot ){
                    i++;
                }

                while(a[j]> pivot){
                    j--;
                }

                if(i >= j){
                    break;
                }

                if(a[i] > a[j]){
                    swapValue(a,i,j);
                }

                i++;
                j--;
            }

            swapValue(a,i,right);

            quickSort(a,left,i-1);
            quickSort(a,i+1,right);

        }else{

            if(left + 1 == right){
                if(a[left] > a[right])
                    swapValue(a,left,right);
            }
            
           
        }

    }


}
