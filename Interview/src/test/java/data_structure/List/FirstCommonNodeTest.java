package data_structure.List;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2017/5/17.
 */
public class FirstCommonNodeTest {
    @Test
    public void findFirstCommonNode() throws Exception {
        ListNode a1 = new ListNode(10);

        ListNode a2 = new ListNode(1);
        ListNode b2 = new ListNode(2);

        ListNode a = new ListNode(100);
        ListNode b = new ListNode(101);
        ListNode c = new ListNode(102);

        a1.nextNode =a;

        a2.nextNode =b2;
        b2.nextNode =a;

        a.nextNode = b;
        b.nextNode = c;

        FirstCommonNode firstCommonNode = new FirstCommonNode();

        ListNode firstNode = firstCommonNode.findFirstCommonNode(a1,a2);
        assertEquals(firstNode,a);
        System.out.println(firstNode.value);
    }

}