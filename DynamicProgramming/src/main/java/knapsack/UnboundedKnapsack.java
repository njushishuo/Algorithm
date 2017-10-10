package knapsack;

/**
 * Created by ss14 on 2017/7/1.
 * 完全背包问题与0-1背包的区别在于：
 * 每种物品都是不同的，且每种物品有无限多个可以拿取
 * 输入: totalWeight, int [] weights , int [] values;
 * 输出: maxValue
 * 思路:
 * 问题得到了简化，因为所有元素都可以重复选择
 * 我们用c[w]表示当容量为w时的最优解,并假设在最后放入的物品为i；
 * 则当i物品被移除时，c[w-wi]是否仍未最优解？答案依然是肯定的
 * c[w] = 0 , w=0;
 * c[w] = max{ c[w-wi] + vi} (1<=i<=n)
 *
 */
public class UnboundedKnapsack {

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





}
