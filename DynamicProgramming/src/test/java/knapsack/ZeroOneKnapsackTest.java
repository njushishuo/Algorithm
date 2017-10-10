package knapsack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2017/7/1.
 */
public class ZeroOneKnapsackTest {
    @Test
    public void maxValue() throws Exception {
        int w=50;
        int weights  [] ={10,20,30};
        int valuess  [] ={60,100,120};

        ZeroOneKnapsack.maxValue(w,weights,valuess);

    }

}