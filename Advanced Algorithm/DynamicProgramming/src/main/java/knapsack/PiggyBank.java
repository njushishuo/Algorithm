package knapsack;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by ss14 on 2017/7/1.
 */
public class PiggyBank{


    public static int totalWeight;
    public static int []value;
    public static int []weight;
    public static int []record;
    public static int inf=99999999;

    /**
     * @param args
     */
    public static void main(String[] args)throws IOException {

        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        for(int k=0;k<times;k++){
            int beforeWt = scanner.nextInt();
            int afterWt = scanner.nextInt();
            int totalWeight = afterWt-beforeWt;
            int n = scanner.nextInt();
            int weights [] = new int [n];
            int values [] = new int [n];
            for(int m=0;m<n;m++){
                values[m]=scanner.nextInt();
                weights[m]=scanner.nextInt();
            }
            int dp []  = new int [totalWeight+1];
            int infinite = 99999999;
            dp[0]=0;
            for(int i=1;i<dp.length;i++){
                dp[i] = infinite;
            }

            for(int i=1;i<=totalWeight;i++){
                int min = dp[i];
                for(int j=0;j<n;j++){
                    if(weights[j]<=i&&dp[i-weights[j]]!=infinite){
                        int temp = dp[i-weights[j]]+values[j];
                        if(temp<min){
                            min = temp;
                        }
                    }
                }
                dp[i]=min;
            }


            if(dp[totalWeight]==infinite){
                System.out.println("This is impossible.");
            }else{
                System.out.println("The minimum amount of money in the piggy-bank is "+dp[totalWeight]+".");
            }

        }


    }

}
