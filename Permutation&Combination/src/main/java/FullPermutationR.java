/**
 * Created by ss14 on 2017/5/15.
 *
 * 整数全排列
 * 输入： int []a
 * 输出： 打印全排列
 * 例如输入 abc
 * 输出 abc acb  bac bca cba cab
 *
 * 思路： 是排列问题的简化版输入本身就是一种全排列
 * 我们不使用额外的空间来存储结果，直接在输入上进行修改；
 * 那么交换操作，是很适合的
 * 用index表示需要替换的下标位置
 * 每次循环，都要遍历index位置与index之后的每个元素，将其与index位置进行交换，
 * 我们把一个全排列情况视为： 第一个元素+剩下元素的全排列 ； 每次只需要将第一个元素和剩下的元素进行交换；
 * 然后递归调用即可
 *
 */
public class FullPermutationR {


    public void printFullPermutaion( int [] a){

        if(a==null||a.length==0){
            return;
        }

        printFullPermutationRecursively(a , 0);

    }


    private void printFullPermutationRecursively(int [] a , int index){

        if(index>=a.length){
            printArray(a);
            return;
        }

        for(int i=index ; i<a.length ; i++){
            swap(a,index,i);
            printFullPermutationRecursively(a,index+1);
            swap(a,index,i);
        }

    }

    private void printArray(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]);
        }
        System.out.print('\n');
    }


    private void swap(int []a , int i, int j){
        if(i==j){
            return;
        }
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
