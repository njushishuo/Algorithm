package list;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * Given a linked list, remove the nth node from the end of list and return its head.
 * Note: n will always be valid
 *
 */
public class RemoveNthNode {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }



    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode preHead  = new ListNode(0);
        preHead.next = head;
        ListNode preNode = preHead, slowNode = head , fastNode = head;
        while(n>1){
            fastNode = fastNode.next;
            n--;
        }

        while(fastNode.next != null){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
            preNode = preNode.next;
        }


        preNode.next = slowNode.next;
        return preHead.next;
    }


}
