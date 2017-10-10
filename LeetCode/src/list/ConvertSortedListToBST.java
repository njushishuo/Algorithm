package list;

import java.util.List;

/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/
 */
public class ConvertSortedListToBST {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        return sortedListToBST(head,null);
    }


    public TreeNode sortedListToBST(ListNode head , ListNode tail) {

        if(head == tail){
            return null;
        }

        ListNode slow  = head , fast  = head;
        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head,slow);
        root.right = sortedListToBST(slow.next,tail);
        return  root;
    }

}
