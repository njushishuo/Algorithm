import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2017/5/14.
 */
public class AscentSequenceTest {
    @Test
    public void findLongestUsingLCS() throws Exception {

        AscentSequence as = new AscentSequence();
        int [] array = {157,232,6};
        int [] array1 = {5, 6, 7, 1, 2, 8};
        int [] array2 = { 1, 2,3,4,5};
        assertEquals(2,as.findLongestUsingLCS(array,array.length));
        assertEquals(4,as.findLongestUsingLCS(array1,array1.length));
        assertEquals(5,as.findLongestUsingLCS(array2,array2.length));
    }

    @Test
    public void findLongest() throws Exception {

        AscentSequence as = new AscentSequence();
        int [] array = {157,232,6};
        int [] array1 = {5, 6, 7, 1, 2, 8};
        int [] array2 = { 1, 2,3,4,5};
        assertEquals(2,as.findLongest(array,array.length));
        assertEquals(4,as.findLongest(array1,array1.length));
        assertEquals(5,as.findLongest(array2,array2.length));

    }

}