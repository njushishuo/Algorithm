/**
 * Created by ss14 on 2017/3/21.
 * 归并排序，分治思想
 * 现将数组一分为二，然后再按大小顺序存放到缓存中去
 */
public class MergeSort {


    public void mergeSort(int a[] , int temp[]){
        mergeSort(a,temp,0,a.length-1);
    }

    private void mergeSort(int a[] ,int temp[] ,int left ,int right){
        if(left<right){
            int center = (left+right)/2;
            mergeSort(a,temp,left,center);
            mergeSort(a,temp,center+1,right);
            merge(a,temp,left,center,center+1,right);
        }
    }

    private void merge(int a[] ,int temp[],int leftPos, int leftEnd, int rightPos, int rightEnd){


        int temPos = leftPos;
        int cnt = rightEnd-leftPos+1;

        while(leftPos<=leftEnd&&rightPos<=rightEnd){

            if(a[leftPos]<=a[rightPos]){
                temp[temPos++] = a[leftPos++];
            }else{
                temp[temPos++] = a[rightPos++];
            }
        }

        while(leftPos<=leftEnd){
            temp[temPos++] = a[leftPos++];
        }

        while(rightPos<=rightEnd){
            temp[temPos++] = a[rightPos++];
        }

        for(int i=0 ;i<cnt;i++,rightEnd-- ){
            a[rightEnd]=temp[rightEnd];
        }
    }
}
