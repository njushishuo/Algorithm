package GoodIdea;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2017/5/16.
 */
public class UglyNumberTest {
    @Test
    public void findNthUglyNumber() throws Exception {

      assert 1==  UglyNumber.findNthUglyNumber(1);
      assert 2==  UglyNumber.findNthUglyNumber(2);
      assert 3==  UglyNumber.findNthUglyNumber(3);
      assert 4==  UglyNumber.findNthUglyNumber(4);
      assert 5==  UglyNumber.findNthUglyNumber(5);
      assert 6==  UglyNumber.findNthUglyNumber(6);
      assert 7==  UglyNumber.findNthUglyNumber(8);


      assertFalse(UglyNumber.isUglyNumber(7));
      assertTrue(UglyNumber.isUglyNumber(9));

    }

}