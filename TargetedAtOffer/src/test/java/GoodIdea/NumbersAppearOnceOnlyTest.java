package GoodIdea;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2017/5/17.
 */
public class NumbersAppearOnceOnlyTest {
    @Test
    public void printNumbersAppearOnceOnly() throws Exception {

        NumbersAppearOnceOnly nao = new NumbersAppearOnceOnly();

        int a1 [] = {1,2,2,3,3,5};
        int a2 [] = {2,2,3,1,1,6,4,4};
        nao.printNumbersAppearOnceOnly(a1);
        nao.printNumbersAppearOnceOnly(a2);

    }

}