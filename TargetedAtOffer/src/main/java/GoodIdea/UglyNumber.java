package GoodIdea;

/**
 * Created by ss14 on 2017/5/16.
 * 不知道哪里丑了。。
 * 输入： int n
 * 输出： 第n个丑数
 * 丑数定义:  因子是{2,3,5}的非空子集 ； 1是第一个丑数
 * 简单的做法：i从1开始不断递增； 初始化一个计数器为0； 如果当前i是丑数,计数器加1
 *    缺点很明显，当n很大的时候太耗时，因为对很多不是丑数的数字做了判断。
 *
 * 空间换时间：考虑丑数的定义； 第一个丑数是1； 第二个丑数是2*1；
 * 第三个丑数是3*1 ； 第四个丑数是2*2 ; 第五个丑数是5*1 ; 第六个丑数是 2*3
 * 如果我们使用大小为n的数组来保存我们自己推算出来的递增的丑数呢？
 * 数组初始化为1；
 * 假设数组中先存放了一些丑数，我们考虑如何生成下一个丑数；
 * 首先所有丑数都只能通过 *2 *3 *5变大，那么下一个丑数，按照递增顺序排列的话，就一定是数组中已经存储的数字中通过 *2或*3或*5得来的
 * 那么我们只要算出所有*2 *3 *5的结果然后取最小的一个数就可以的。 等等，其实不需要算出所有可能的结果再取最小，因为数组是递增排序的
 * 所以我们只需要求出通过 *2 *3 *5 变大的数中，第一次超过数组中最后一个元素的 三个值再取最小就可以了。
 */
public class UglyNumber {

    public static int findNthUglyNumber(int n){

        if(n==1){
            return 1;
        }else{
            int [] a = new int [n];
            for(int i=1;i<n;i++){
                int m2=0 ,m3=0,m5=0;
                int j=0;
                while(m2==0||m3==0||m5==0){
                    if(a[j]*2>a[i]&&m2==0){
                        m2 = a[j]*2;
                    }

                    if(a[j]*3>a[i]&&m3==0){
                        m3 = a[j]*3;
                    }

                    if(a[j]*5>a[i]&&m5==0){
                        m5 = a[j]*5;
                    }

                    j++;
                }
                int tem = Math.min(m2,m3);
                int min = Math.min(tem,m5);
                a[i] = min;
            }
            return a[n-1];

        }
    }


    public static boolean isUglyNumber(int n){
        if(n<=0){
            return false;
        }

        if(n==1){
            return true;
        }

        while(n%2==0){
            n/=2;
        }
        while(n%3==0){
            n/=3;
        }
        while(n%5==0){
            n/=5;
        }

        return n==1;

    }

}
