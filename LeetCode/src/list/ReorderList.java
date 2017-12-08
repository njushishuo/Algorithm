package list;

/**
 * https://leetcode.com/problems/reorder-list/description/
 *
 */
public class ReorderList {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public static void main(String args[]){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;

        ReorderList rl = new ReorderList();
        rl.reorderList(a);
        rl.printList(a);
    }

    public void reorderList(ListNode head) {
        if(head==null){
            return;
        }
        ListNode mid = this.findMid(head);
        ListNode rightHead = this.reverseList(mid.next);
        mid.next = null;
        ListNode leftHead = head;

        ListNode leftNext ;
        ListNode rightNext ;
        while (leftHead != null && rightHead != null){
            leftNext  = leftHead.next;
            rightNext = rightHead.next;
            leftHead.next = rightHead;
            rightHead.next = leftNext;

            leftHead = leftNext;
            rightHead = rightNext;
        }
    }

    private ListNode findMid(ListNode head){
        if(head == null){
            return null;
        }

        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode slow = preHead , fast = preHead;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    private ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode preNode = head , curNode = head.next;
        preNode.next = null;
        while(curNode != null){
            ListNode temp = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = temp;
        }
        return preNode;
    }


    private void printList(ListNode head){
        while(head != null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}
