package GoodIdea;

/**
 * Created by ss14 on 2017/5/16.
 * 输入一个数组返回它的最小的k个元素
 *
 */
public class SmallestKElements {


    public void findLeastNumbers(int a[], int k){
        if(a==null){
            return ;
        }else if(k>a.length||k<=0){
            return ;
        }

        int start = 0;
        int end = a.length-1;

        int index =PartitionHelper.partition(a,start,end);
        while(index!=k-1){

            if(index>k-1){
                end = index-1;
            }else{
                start = index+1;

            }
            index = PartitionHelper.partition(a,start,end);
        }

        for(int i=0;i<k;i++){
            System.out.print(a[i]+" ");
        }
        System.out.print('\n');
    }
}
