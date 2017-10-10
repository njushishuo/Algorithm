package GoodIdea;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2017/5/16.
 */
public class MajorityElementProblemTest {
    @Test
    public void findMajority() throws Exception {
        MajorityElementProblem mep = new MajorityElementProblem();
        int a1 [] = {2,3,4,2,2};
        int a2 [] = {2,3};
        int a3[] = {1};
        int a4[] = {1,1,1};
        int a5[]={2,2,1,1};
        int a6[]={2,2,1,1,1};


        assertEquals(mep.findMajority(a1) , 2);
        assertEquals(mep.findMajority(a2) , -1);
        assertEquals(mep.findMajority(a3) , 1);
        assertEquals(mep.findMajority(a4) , 1);
        assertEquals(mep.findMajority(a5) , -1);
        assertEquals(mep.findMajority(a6) , 1);

    }

}