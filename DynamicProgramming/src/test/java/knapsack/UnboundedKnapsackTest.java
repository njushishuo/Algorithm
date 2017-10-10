package knapsack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2017/7/1.
 */
public class UnboundedKnapsackTest {
    @Test
    public void maxValue() throws Exception {
        int w=17;
        int weights  [] ={2,3,5};
        int values  [] ={50,100,140};

        int w1=100;
        int weights1  [] ={5,10,15};
        int values1  [] ={10,30,20};

        UnboundedKnapsack.maxValue(w,weights,values);
        UnboundedKnapsack.maxValue(w1,weights1,values1);
    }

}