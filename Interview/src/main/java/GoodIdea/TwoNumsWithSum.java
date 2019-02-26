package GoodIdea;

/**
 * Created by ss14 on 2017/5/17.
 *
 * 输入: int a[] , int sum ; 数组是排序的数组都是正整数
 * 输出： 打印数组中两个数字，这两个数字的和恰好等于sum
 *
 */
public class TwoNumsWithSum {

    public static void printTwoNumsWithSum(int a[] ,int sum){
        int i=0;
        int j=a.length-1;

        boolean found =false;
        while (i<j){
            if(a[i]+a[j]==sum){
                found =true;
                System.out.println(a[i]+" "+a[j]);
                i++;
                j--;
            }
            if(a[i]+a[j]>sum){
                j--;
            }
            if(a[i]+a[j]<sum){
                i++;
            }
        }

        if(!found){
            System.out.print("不存在的");

        }
    }




}
