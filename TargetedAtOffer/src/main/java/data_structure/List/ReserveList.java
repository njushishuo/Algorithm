package data_structure.List;


/**
 * Created by ss14 on 2017/5/12.
 * 反转一个链表
 * 输入：头结点
 * 输出：反转后头结点
 */
public class ReserveList {

    public ListNode reserveList(ListNode head){

        ListNode preNode = null;
        ListNode nextNode= null;
        ListNode curNode = head;
        while(curNode!=null){
            nextNode = curNode.nextNode;
            curNode.nextNode = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }



}
