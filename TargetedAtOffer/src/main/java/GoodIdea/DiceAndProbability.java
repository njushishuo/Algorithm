package GoodIdea;

import java.text.DecimalFormat;

/**
 * Created by ss14 on 2017/5/18.
 *
 * 输入: int n ； 骰子的数目
 * 输出： 设s为所有骰子朝上的一面的和，
 *       打印s各个可能的值，即相应的概率
 *
 * 随机独立事件： 总基本事件数 6^n，和为s的事件中包含m个基本事件
 * 则概率为  m/6^n， 所以问题的关键在于如何求出各个s包含多少个基本事件；
 * 即当各个骰子的朝上一面的数值之和为s时，各个骰子的取值情况有多少种；
 */
public class DiceAndProbability {

    final int maxNum = 6;

    public void printProbability(int n){

        int maxSum = maxNum*n;
        int minSum = n;
        //n,n+1,n+2,,,6*n  以sum为下标，以sum出现的次数为值
        int [] pros = new int [maxSum-minSum+1];
        computeProbability(n,pros);

        int total = (int) Math.pow(6,n);
        DecimalFormat df = new DecimalFormat("#0.00");

        for(int i=0;i<pros.length;i++){

            double temp = ((double)pros[i])/total;

            System.out.print("sum:"+(i+n));
            System.out.println(" repeated:"+pros[i]);
            System.out.println("pro:"+df.format(temp));
        }
    }


    private void computeProbability(int n ,int [] pros ){
        computeProbabilityRecursively(n , 1,0, pros);
    }

    /**
     * 递归的方式计算各个sum的出现次数
     * @param n       骰子个数
     * @param curDice 当前正在处理第几个骰子
     * @param curSum  当前的累加和
     * @param pros    概率数组
     */
    private void computeProbabilityRecursively(int n,int curDice,int curSum ,int [] pros ){
        if(curDice==n){
            for(int i=1;i<=maxNum;i++){
                curSum+=i;
                pros[curSum-n]++;
                curSum-=i;
            }
        }else{
            for(int i=1;i<=maxNum;i++){
                curSum+=i;
                computeProbabilityRecursively(n,curDice+1,curSum,pros);
                curSum-=i;
            }
        }
    }


    private void computeProbablityWithLoop(int n, int [] pros){

        for (int i=1;i<=n;i++){


            for(int j=1;j<maxNum;j++){



            }



        }



    }



}
