package GoodIdea;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2017/5/16.
 */
public class MinNumFormedByArrayTest {
    @Test
    public void minNumFormedByArray() throws Exception {

        int a1[] = {32,3,31,12};
        int a2[] = {5,3,10};
        int a3[] = {7,1,50};

        assert 1231323==MinNumFormedByArray.minNumFormedByArray(a1);
        assert 1035==MinNumFormedByArray.minNumFormedByArray(a2);
        assert 1507==MinNumFormedByArray.minNumFormedByArray(a3);

        System.err.println("3".compareTo("31"));
        System.err.println(new StringComparetor().compare("3","31"));
    }

}