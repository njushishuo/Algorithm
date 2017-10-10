package knapsack;
/**
 * Created by ss14 on 2017/7/1.
 *
 * 0-1背包问题
 * 背包容量有限，现在给出每件物品的容量和价值，求此背包可携带的最大物品价值
 *
 * 输入: totalWeight, int [] weights , int [] values;
 * 输出: maxValue
 *
 * 思路:
 * 我们假设c[i,w]表示当我们考虑的范围包括 1, 2,,,i号物品,最大容量为w时的最优解；
 * 我们考虑一个性质，当我们从当前假设的最优解中拿掉i物品时, 剩下的选择是否仍满足最优性质。答案是肯定的可用反证法
 * 也就是说，最优解的性质具有问题分解的特性。我们只需要考虑递推关系即可。
 * 对于c[i,w]表示，我们正在考虑容量为w时，i物品如何处理：拿或者不拿
 *
 * c[i,w] = 0 (i=0或w=0)
 * c[i,w] = c[i-1,w] (wi > w 该物品比当前最大容量还大)
 * c[i,w] = max(c[i-1,w-wi]+vi , c[i-1,w] ) (wi<=w 拿或者不拿)
 *
 */
public class ZeroOneKnapsack {

    public static void maxValue(int w , int [] weights , int [] values){

        int n = weights.length;
        int c [][] = new int [n+1][w+1];
        for(int i=0;i<=n;i++){
            c[i][0]=0;
        }

        for(int i=0;i<=w;i++){
            c[0][w]=0;
        }

        int itemWeight;
        int itemValue ;
        for(int i=1;i<=n;i++){
            itemWeight = weights[i-1];
            itemValue  = values[i-1];
            for(int j=1;j<=w;j++){
                if(itemWeight>j){
                    c[i][j]=c[i-1][j];
                }else{
                    c[i][j]=Math.max(c[i-1][j-itemWeight]+itemValue , c[i-1][j]);
                }
            }
        }

        System.out.println("maxValue:"+c[n][w]);

    }







}
