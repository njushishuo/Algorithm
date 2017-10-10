package data_structure.stack;

import data_structure.stack.StackImplementedWithQueue;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2017/5/3.
 */
public class StackImplementedWithQueueTest {
    @Test
    public void test(){
        StackImplementedWithQueue stack = new StackImplementedWithQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.print();
        assertEquals(3,stack.pop());
        stack.print();
        assertEquals(2,stack.pop());
        stack.print();
        stack.push(4);
        stack.print();
        stack.push(5);
        stack.print();
        assertEquals(5,stack.pop());
        stack.print();
        assertEquals(4,stack.pop());
        stack.print();
        assertEquals(1,stack.pop());
        stack.print();
    }




}