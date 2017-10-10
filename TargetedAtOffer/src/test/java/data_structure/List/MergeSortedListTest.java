package data_structure.List;

import org.junit.Test;

/**
 * Created by ss14 on 2017/5/12.
 */
public class MergeSortedListTest {
    @Test
    public void mergeLists() throws Exception {
        ListNode a1 = new ListNode(1);
        ListNode b1 = new ListNode(3);
        ListNode c1 = new ListNode(5);
        ListNode d1 = new ListNode(7);

        ListNode a2 = new ListNode(2);
        ListNode b2 = new ListNode(4);
        ListNode c2 = new ListNode(6);

        a1.nextNode = b1;  b1.nextNode = c1; c1.nextNode=d1;
        a2.nextNode = b2;  b2.nextNode = c2;

        MergeSortedList mergeSortedList = new MergeSortedList();

        System.out.println("不改变输入R");
        ListHelper.printList(a1);
        ListHelper.printList(a2);
        ListHelper.printList(mergeSortedList.mergeListsR(a1,a2));
        ListHelper.printList(a1);
        ListHelper.printList(a2);

        System.out.println("不改变输入Loop");
        ListHelper.printList(a1);
        ListHelper.printList(a2);
        ListHelper.printList(mergeSortedList.mergeListsLoop(a1,a2));
        ListHelper.printList(a1);
        ListHelper.printList(a2);


        System.out.println("改变输入R");
        ListHelper.printList(a1);
        ListHelper.printList(a2);
        ListHelper.printList(mergeSortedList.mergeListsModifyR(a1,a2));
        ListHelper.printList(a1);
        ListHelper.printList(a2);
    }



    @Test
    public void copyList(){
        ListNode a1 = new ListNode(1);
        ListNode b1 = new ListNode(3);
        ListNode c1 = new ListNode(5);
        ListNode d1 = new ListNode(7);


        a1.nextNode = b1;  b1.nextNode = c1; c1.nextNode=d1;

        ListHelper.printList(a1);
        ListHelper.printList(ListHelper.copyList(a1));
        ListHelper.printList(a1);
    }
}