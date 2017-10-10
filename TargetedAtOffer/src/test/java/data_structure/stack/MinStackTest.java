package data_structure.stack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2017/5/14.
 */
public class MinStackTest {

    @Test
    public void test(){
        MinStack<Integer> minStack = new MinStack<Integer>();
        minStack.push(3);
        assert  minStack.min()==3;
        minStack.push(1);
        assert  minStack.min()==1;
        minStack.push(2);
        assert  minStack.min()==2;
        minStack.push(4);
        assert  minStack.min()==1;
        minStack.pop();
        assert  minStack.min()==1;
        minStack.pop();
        assert  minStack.min()==1;
        minStack.pop();
        assert  minStack.min()==3;


    }


}