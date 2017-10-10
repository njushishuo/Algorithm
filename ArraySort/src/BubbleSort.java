/**
 * Created by ss14 on 2017/3/21.
 */

/**
 *交换排序之冒泡排序
 */
public class BubbleSort {

    /**
     * 每次将最大值交换到最后
     * @param a
     */
    public void bubbleSort(int a[]){
        //n-1次
        for(int i=0;i<a.length-1;i++){

            for(int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
            ArrayHelper.printArray(a);
        }
    }


    public void bubbleSortImproved(int a[]){
        //n-1次
        for(int i=0;i<a.length-1;i++){
            boolean swaped =false;

            for(int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                    swaped=true;
                }
            }
            ArrayHelper.printArray(a);
            if(!swaped){
                break;
            }
        }
    }

}
