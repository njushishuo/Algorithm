import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2017/5/12.
 */
public class MaxSumOfNonadjacentSubSequenceTest {
    @Test
    public void findMaximumSumofSubArray() throws Exception {
        int a  [] = {5, 5, 10, 100, 10, 5};
        int b  [] = {1, 2, 3};
        int c  [] = {1, 20, 3};
        MaxSumOfNonadjacentSubSequence maxSumProblem = new MaxSumOfNonadjacentSubSequence();
        int resulta = maxSumProblem.findMaximumSumofSubArray(a);
        int resultb = maxSumProblem.findMaximumSumofSubArray(b);
        int resultc = maxSumProblem.findMaximumSumofSubArray(c);
        assert resulta==110;
        assert resultb == 4;
        assert resultc ==20;
    }

}