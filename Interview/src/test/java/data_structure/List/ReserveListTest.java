package data_structure.List;

import data_structure.List.ListHelper;
import data_structure.List.ListNode;
import data_structure.List.ReserveList;
import org.junit.Test;

/**
 * Created by ss14 on 2017/5/12.
 */
public class ReserveListTest {
    @Test
    public void reserveList() throws Exception {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.nextNode=b;
        b.nextNode=c; c.nextNode=d;

        ReserveList reserveList = new ReserveList();
        ListHelper.printList(a);
        ListNode head = reserveList.reserveList(a);
        ListHelper.printList(head);

    }

}