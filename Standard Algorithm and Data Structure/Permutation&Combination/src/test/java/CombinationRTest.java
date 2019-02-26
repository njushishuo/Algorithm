import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2017/5/15.
 */
public class CombinationRTest {
    @Test
    public void combination() throws Exception {
        int [] a = {1,2,3,4};
        CombinationR combinationR = new CombinationR();
        combinationR.printCombination(a,2);
    }

}