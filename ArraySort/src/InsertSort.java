/**
 * Created by ss14 on 2017/3/21.
 */
public class InsertSort {


    /**
     * 直接插入排序
     * 每次插入后保证0-i的顺序正确
     * @param a
     */
    public void insertSort(int a[]){
        int j;
        for(int i=1;i<a.length;i++){
            int temp = a[i];
            for(j=i; j>0&&temp<a[j-1] ;j-- ){
                  a[j]=a[j-1];
            }
            a[j]=temp;
            ArrayHelper.printArray(a);
        }
    }



    public void insertSortFail(int a[]){
        int j;
        for(int i=1;i<a.length;i++){
            int temp = a[i];
            for(j=i; j>0 ;j-- ){
                if(temp<a[j-1]){
                    a[j]=a[j-1];
                }
            }
            a[j]=temp;
            ArrayHelper.printArray(a);
        }

    }



    public void insertSortCorrected(int a[]){
        int j;

        for(int i=1;i<a.length;i++){

            int temp = a[i];
            int target = i;
            for(j=i; j>0 ;j-- ){
                if(temp<a[j-1]){
                    a[j]=a[j-1];
                    target--;
                }
            }
            a[target]=temp;
            ArrayHelper.printArray(a);
        }
    }





}
