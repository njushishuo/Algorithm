import java.util.HashSet;
import java.util.Set;

/**
 * Created by ss14 on 2017/3/10.
 * 循环实现打印组合数
 */

//组合数
public class Combination {

    /**
     *
     * @param inputArray 数组
     * @param m
     * 从数组中选出m个数
     */
    public void printCombination( int [] inputArray ,int m){

        int []a = reduceDuplication(inputArray);
        int temp [] = init(a, m);
        printTemp(temp);

        int indexToIncrease;
        while( (indexToIncrease = findIndexToIncrease(temp,a,m))!=-1){
            temp=adjustTemp(temp,a,indexToIncrease);
            printTemp(temp);
        }


    }

    private int [] reduceDuplication(int a[]){
        Set set = new HashSet();
        for(int i=0; i<a.length ; i++){
            set.add(a[i]);
        }
        Integer [] tempArray = (Integer[]) set.toArray(new Integer[set.size()]);
        int [] result = new int [tempArray.length];
        for(int i=0;i<result.length;i++ ){
            result[i]=tempArray[i];
        }
        return result;
    }

    private int[] init(int [] a , int m ){

        int temp [] = new int [m];

        for(int i=0;i<m;i++){
            temp[i] = a[i];
        }
        return temp;
    }

    private int findIndexToIncrease(int [] temp , int a[] , int m ){

        for (int i = m-1 ; i>=0; i-- ){
            if(temp[i]!= a[a.length-m+i] ){
                return i;
            }
        }
        return -1;
    }

    private void printTemp(int temp[]) {

        for(int i=0 ; i<temp.length-1 ; i++){
            System.out.print(temp[i]+",");
        }
        System.out.println(temp[temp.length-1]);
    }

    private int [] adjustTemp(int [] temp , int a[] , int indexToIncrease){
        int oldIndexInArray = getIndexOf(a,temp[indexToIncrease]);
        for(int i=indexToIncrease; i<temp.length ; i++){
            temp[i]=a[oldIndexInArray+1];
            oldIndexInArray++;
        }
        return temp;
    }

    private int getIndexOf(int []a ,int target){
        for(int i=0;i<a.length;i++){
            if(a[i]==target){
                return i;
            }
        }
        return -1;
    }


}
