package GoodIdea;

/**
 * Created by ss14 on 2017/5/17.
 * 输入: int a , int len  两个正整数;
 * 输出: 打印所有可能的连续递增的正整数序列，使得他们的和为a, 并且长度不小于len
 *
 * 例如
 * 输入 15 , 2
 * 输出 12345  456  78
 *
 * 思路: 从连续len个数字起，len逐渐增加；直到len个连续递增整数序列中最小值 1,2,3,,len的值大于target时，结束循环
 *
 */
public class AscNumsWithSum {

    public void printAscConsecutiveNumsWithSumOf(int target , int minlen){
        int len = minlen;
        while( cmpMToN(1,len) <=target ){
            for(int i=1 ; i<=target/len ; i++){
                int temp =cmpMToN(i,i+len-1);
                if(temp>target ){
                    break;
                }

                if(temp==target ){
                    printMToN(i,i+len-1);
                }
            }
            len++;
        }
    }


    private  int cmpMToN(int m, int n){
        int result = 0;
        for(int i=m;i<=n;i++){
            result+=i;
        }

        return result;
    }

    private void printMToN(int m, int n){
        for(int i=m;i<=n;i++){
            System.out.print(i+" ");
        }
        System.out.print('\n');

    }





}
