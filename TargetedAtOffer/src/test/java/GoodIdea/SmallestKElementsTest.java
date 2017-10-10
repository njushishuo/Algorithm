package GoodIdea;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2017/5/16.
 */
public class SmallestKElementsTest {
    @Test
    public void findLeastNumbers() throws Exception {
        SmallestKElements sm = new SmallestKElements();


        int [] a1 = {1,3,2,7,4,5};
        int [] a2 = {1,3,3,7,4,5};
        sm.findLeastNumbers(a1,3);
        sm.findLeastNumbers(a2,3);

    }

}