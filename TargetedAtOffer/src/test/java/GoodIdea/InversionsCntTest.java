package GoodIdea;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2017/5/17.
 */
public class InversionsCntTest {
    @Test
    public void cntInversions() throws Exception {

        InversionsCnt inversionsCnt = new InversionsCnt();

        int []a1 = {5,7,3,4,8};
        int []a2 = {7,5,6,4};
        int []a3 = {7,6,5,4};

        test(inversionsCnt,a1,4);
        test(inversionsCnt,a2,5);
        test(inversionsCnt,a3,6);
    }

    private void test(InversionsCnt inversionsCnt ,int a[] , int cnt){
        int temp [] = new int [a.length];

        ArrayHelper.printArray(a);
        assertEquals(inversionsCnt.cntInversions(a,temp,0,a.length-1),cnt);
        ArrayHelper.printArray(a);
        System.out.print('\n');
    }

}