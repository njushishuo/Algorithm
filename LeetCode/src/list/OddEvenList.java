package list;

/**
 * https://leetcode.com/problems/odd-even-linked-list/description/
 * 将奇数位置的节点全部放到前面，偶数位置的放到奇数后面
 *
 */
public class OddEvenList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }



    public ListNode oddEvenList(ListNode head) {

        if(head == null){
            return null;
        }

        if(head.next == null){
            return head;
        }

        ListNode evenHead = head.next;
        ListNode curOddNode = head;
        ListNode curEvenNode = head.next;
        while( curEvenNode != null && curEvenNode.next != null){

            curOddNode.next = curEvenNode.next;
            curEvenNode.next = curEvenNode.next.next;

            curOddNode = curOddNode.next;
            curEvenNode = curEvenNode.next;
        }

        curOddNode.next = evenHead;

        return head;
    }

}
