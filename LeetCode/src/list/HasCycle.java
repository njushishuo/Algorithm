package list;

/**
 * https://leetcode.com/problems/linked-list-cycle/description/
 */
public class HasCycle {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public boolean hasCycle(ListNode head) {
        ListNode slow = head , fast = head ;
        while(slow != null && fast!=null &&fast.next !=null ){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }

        return false;

    }
}
