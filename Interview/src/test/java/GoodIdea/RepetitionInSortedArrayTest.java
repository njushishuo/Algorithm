package GoodIdea;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2017/5/17.
 */
public class RepetitionInSortedArrayTest {
    @Test
    public void getRepetitionOf() throws Exception {
        RepetitionInSortedArray ra = new RepetitionInSortedArray();
        int a[] = {1,2,2,2,3,3,4,5};

        assertEquals(1,ra.getRepetitionOf(a,1));
        assertEquals(3,ra.getRepetitionOf(a,2));
        assertEquals(2,ra.getRepetitionOf(a,3));
        assertEquals(1,ra.getRepetitionOf(a,4));
        assertEquals(1,ra.getRepetitionOf(a,5));
        assertEquals(0,ra.getRepetitionOf(a,9));


    }

}