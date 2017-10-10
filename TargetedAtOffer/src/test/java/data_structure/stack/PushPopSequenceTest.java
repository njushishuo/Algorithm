package data_structure.stack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2017/5/14.
 */
public class PushPopSequenceTest {
    @Test
    public void isPopSequence() throws Exception {
        PushPopSequence pushPopSequence = new PushPopSequence();
        int [] pushSeq = {1,2,3,4,5};
        int [] popSeq1 = {1,2,3,4,5};
        int [] popSeq2 = {4,5,3,2,1};
        int [] popSeq3 = {5,4,3,2,1};
        int [] popSeq4 = {5,4,1,2,3};

       assertTrue(pushPopSequence.isPopSequence(pushSeq,popSeq1));
       assertTrue(pushPopSequence.isPopSequence(pushSeq,popSeq2));
       assertTrue(pushPopSequence.isPopSequence(pushSeq,popSeq3));
       assertFalse(pushPopSequence.isPopSequence(pushSeq,popSeq4));

    }

}