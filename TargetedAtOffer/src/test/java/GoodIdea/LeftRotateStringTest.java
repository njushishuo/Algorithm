package GoodIdea;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2017/5/18.
 */
public class LeftRotateStringTest {
    @Test
    public void leftRotateString() throws Exception {

        String input = "abcde";
        LeftRotateString lr = new LeftRotateString();

        lr.leftRotateString(input,2);
        lr.leftRotateString(input,3);
        lr.leftRotateString(input,5);
        lr.leftRotateString(input,7);



    }

}