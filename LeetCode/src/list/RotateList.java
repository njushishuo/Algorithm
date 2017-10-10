package list;

/**
 * https://leetcode.com/problems/rotate-list/description/
 */
public class RotateList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String args[]){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;

        RotateList rl = new RotateList();
        rl.rotateRight(a,2);
        rl.printList(a);
    }



    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k==0){
            return head;
        }

        ListNode preHead = new ListNode(0);
        preHead.next = head;

        ListNode curNode = head , preNode = preHead , rightTail ;
        int length =0;
        while(curNode != null){
            length++;
            curNode = curNode.next;
            preNode = preNode.next;
        }
        rightTail = preNode;

        if(k >= length){
            k = k % length;
        }

        if(k==0){
            return head;
        }

        curNode = head; preNode = preHead;
        for( int i=0 ; i<length-k ; i++){
            curNode = curNode.next;
            preNode = preNode.next;
        }
        preNode.next=null;

        rightTail.next = head;

        return curNode;
    }


    private void printList(ListNode head){
        while(head != null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}
