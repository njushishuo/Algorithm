package list;

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/description/
 * 输入: 需要删除的节点,该节点不会是tail  (what ? 链表head节点没有给出 ?)
 */
public class DeleteNode {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    //O(n)
    public void deleteNode(ListNode node) {

        ListNode next = node.next;

        while( next.next != null ){
            node.val = next.val;
            node = node.next;
            next = next.next;
        }
        node.val = next.val;
        node.next = null;
    }

    //O(1)
    public void deleteNodeBetter(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
