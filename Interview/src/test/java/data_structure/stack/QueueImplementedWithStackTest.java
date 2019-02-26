package data_structure.stack;

import data_structure.stack.QueueImplementedWithStack;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2017/5/3.
 */
public class QueueImplementedWithStackTest {

    @Test
    public void test(){
        QueueImplementedWithStack queue = new QueueImplementedWithStack();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        assertEquals(1,queue.take());
        assertEquals(2,queue.take());
        assertEquals(3,queue.take());
        queue.offer(4);
        assertEquals(4,queue.take());
        queue.offer(5);
        assertEquals(5,queue.take());
    }

}