package array;

/**
 * 找出数组中最大差值，max(aj - ai) j>=i
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {

        if(prices == null || prices.length == 0){
            return 0;
        }

        int max  = 0;
        int low = prices[0];
        for( int i = 1; i < prices.length; i++){
            if(prices[i] > low){
                max = Math.max(max , prices[i] - low);
            }else{
                low = prices[i];
            }
        }

        return max;

    }

}
