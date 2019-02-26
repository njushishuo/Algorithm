package data_structure.List;


/**
 * Created by ss14 on 2017/5/12.
 * 合并两个排序的链表
 */
public class MergeSortedList {

    /**
     * 重新创建每一个结点，并且不改变输入的链表
     * @param head1
     * @param head2
     * @return
     */
    public ListNode mergeListsR(ListNode head1 , ListNode head2){

        if(head1==null){
            return ListHelper.copyList(head2);
        }
        if(head2 == null){
            return ListHelper.copyList(head1);
        }

        ListNode newHead = new ListNode(0);
        if(head1!=null && head2!=null){

            if(head1.value>head2.value){
                newHead.value = head2.value;
                newHead.nextNode = mergeListsR(head1, head2.nextNode);

            }else{
                newHead.value = head1.value;
                newHead.nextNode = mergeListsR(head1.nextNode, head2);
            }

            return  newHead;
        }

        return newHead;
    }

    /**
     * 不重新创建每一个结点，会改变输入的链表
     * @param head1
     * @param head2
     * @return
     */
    public ListNode mergeListsModifyR(ListNode head1 , ListNode head2){

        if(head1==null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }

        ListNode newHead = null;

        if(head1!=null && head2!=null){

            if(head1.value>head2.value){
                newHead = head2;
                newHead.nextNode = mergeListsModifyR(head1, head2.nextNode);

            }else{
                newHead = head1;
                newHead.nextNode = mergeListsModifyR(head1.nextNode, head2);
            }

            return  newHead;
        }

        return newHead;
    }


    /**
     * 重新创建每一个结点，不改变输入的链表
     * @param head1
     * @param head2
     * @return
     */
    public ListNode mergeListsLoop(ListNode head1 , ListNode head2){
        if(head1==null){
            return ListHelper.copyList(head2);
        }
        if(head2 == null){
            return ListHelper.copyList(head1);
        }

        ListNode mergedHead = new ListNode(0);
        ListNode mergedCur = mergedHead;
        ListNode curNode1 = head1;
        ListNode curNode2 = head2;

        if(head1.value<head2.value){
            mergedHead.value =head1.value;
            curNode1 = head1.nextNode;
        }else{
            mergedHead.value =head2.value;
            curNode2 = head2.nextNode;
        }

        ListNode tempNode;
        while(curNode1!=null&&curNode2!=null){
            if(curNode1.value<=curNode2.value){
                tempNode = new ListNode(curNode1.value);
                curNode1 = curNode1.nextNode;
            }else{
                tempNode = new ListNode(curNode2.value);
                curNode2 = curNode2.nextNode;
            }

            mergedCur.nextNode = tempNode;
            mergedCur = mergedCur.nextNode;


        }

        if(curNode1!=null){
            mergedCur.nextNode = ListHelper.copyList(curNode1);
        }

        if(curNode2!=null){
            mergedCur.nextNode = ListHelper.copyList(curNode2);
        }

        return mergedHead;
    }

}
