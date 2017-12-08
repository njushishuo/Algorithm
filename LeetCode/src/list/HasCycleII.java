package list;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/description/
 * 返回环的起点，否则返回null
 *    x:head到loop起点的距离
 *    c:loop起点到相遇点的距离
 *    a:loop的长度
 *    a-c:从相遇点继续走下去到loop起点的距离
 *   2(x + c + N*a) = x + c + M*a (M>N)
 *   => x = a-c
 *
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
