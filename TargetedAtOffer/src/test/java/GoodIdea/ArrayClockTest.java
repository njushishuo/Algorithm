package GoodIdea;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2017/5/12.
 */
public class ArrayClockTest {
    @Test
    public void printArrayInClockWise() throws Exception {
        ArrayClock arrayClock = new ArrayClock();

        int a [][] = {
                {1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}
        };
        int b[][] = {
                {1,2,3},{4,5,6},{7,8,9},{10,11,12}
        };
        int c[][] = {
                {1,2,3,4},{5,6,7,8},{9,10,11,12}
        };
        arrayClock.printArrayInClockWise(a);
        arrayClock.printArrayInClockWise(b);
        arrayClock.printArrayInClockWise(c);

    }

}