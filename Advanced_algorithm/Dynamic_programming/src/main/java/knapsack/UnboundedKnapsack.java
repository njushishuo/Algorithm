package knapsack;
/**
 * Created by ss14 on 2017/7/1.
 * 完全背包问题与0-1背包的区别在于：
 * 每种物品都是不同的，且每种物品有无限多个可以拿取
 * 输入: totalWeight, int [] weights , int [] values;
 * 输出: maxValue
 */
public class UnboundedKnapsack {
    
    /**
     * 思路1: 一维表
     * 我们用c[w]表示当容量为w时的最优解,并假设在最后放入的物品为i；
     * 则当i物品被移除时，c[w-wi]是否仍未最优解？答案依然是肯定的
     * c[w] = 0 , w=0;
     * c[w] = max{ c[w-wi] + vi} (1<=i<=n)
     *
     */
    public static void maxValue(int w , int [] weights , int [] values){

        int n = weights.length;
        int c[] = new int [w+1];
        c[0] = 0;
        int max;
        for(int i=1;i<=w;i++){
            max = c[i-1];
            for(int j=0;j<n;j++){
                // = should not be left out
                if(weights[j]<=i){
                    int tem =Math.max(c[i-weights[j]]+values[j], c[i-1]);
                    if( tem>max){
                        max = tem;
                    }
                }
            }
            c[i] = max;
        }
        System.out.println("maxValue:"+c[w]);

    }

    /**
     * 思路2： 二维表
     * 子问题： 考虑M[k,x] 表示只拿前k中物品，且总重量不超过x的最优解。  0<= k <=n, x>=0
     * 递推方程： 
     *       1.  M[k,x] = max( M[k-1,x], M[k,x-wk]+ vk)
     *       2.  M[k,x] = max( M[k-1,x-i*wk] + i*vk ) (0<= i <= x/wk)
     * 有两种递推方程， 本质的思路是一样的，都是考虑不拿物品k，或者拿1,2,3，，次物品k。
     * 区别在于： 可以这么理解第一种思路，对于所有选择可以分为两类：拿或者不拿物品k，如果不拿，那就是左值，如果拿了那么首先至少拿了一个，所以可以向右值那样表示。
     * 那种递推方程更优？ 显然是第一种，因为只需要查表两次然后比较； 而第二种需要做多次查表， i 是一个随着问题规模变化的值。
     * 下面实现下思路1：
     */

    public static void maxValue2D(int w , int [] weights , int [] values){

        int n = weights.length; // 物品的种数
        int m = w;
        int M[][] = new int[n+1][m+1];
        // row
        for(int i=1; i<=n; i++ ){
            // column
            for(int j=1; j<=m; j++){

                M[i][j] = M[i-1][j]; // 注意这里把初始化提前，而不是放到下面的if 判断里
                
                if(weights[i-1] <= j ){
                    M[i][j] = Math.max( M[i-1][j] , M[i][j-weights[i-1]]+ values[i-1] );
                }
            }
        }
        printArray(M);
        System.out.println("maxValue:"+M[n][m]);
    }

    private static void printArray(int [][]M){
        int n = M.length;
        int m = M[0].length;
        for(int i=0; i<n ; i++){
            for(int j=0; j<m; j++){
                System.out.print(M[i][j]+" ");
            }
            System.out.print('\n');
        }
    }


    public static void main(String args[]){
        int w=10;
        int weights  [] ={2,3,4,7};
        int values  [] ={1,3,5,9};
        UnboundedKnapsack.maxValue(w,weights,values);
        UnboundedKnapsack.maxValue2D(w, weights, values);
    }



}
