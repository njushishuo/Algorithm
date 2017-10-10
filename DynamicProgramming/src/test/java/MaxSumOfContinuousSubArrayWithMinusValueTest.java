import static org.junit.Assert.*;

/**
 * Created by ss14 on 2017/5/12.
 */
public class MaxSumOfContinuousSubArrayWithMinusValueTest {
    @org.junit.Test
    public void findMaximumSumofSubArray() throws Exception {

        MaxSumOfContinuousSubArrayWithMinusValue maxSumProblem = new MaxSumOfContinuousSubArrayWithMinusValue();
        int [] a = {1,-2,3,10,-4,7,2,-5};
        int result =  maxSumProblem.findMaximumSumofSubArray(a);
        assert  result ==18;

    }

}