package list;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/description/
 * 返回环的起点，否则返回null
 */
public class HasCycleII {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head , fast = head ;
        while(fast!=null &&fast.next !=null ){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                fast = head;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
