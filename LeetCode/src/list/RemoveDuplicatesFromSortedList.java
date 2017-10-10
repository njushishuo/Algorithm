package list;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 * 所有数字只保留一次，重复的去掉
 */
public class RemoveDuplicatesFromSortedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String args []){
        RemoveDuplicatesFromSortedList rd = new RemoveDuplicatesFromSortedList();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        a.next = b;
        rd.deleteDuplicatesB(a);
    }


    public ListNode deleteDuplicatesA(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode preNode = head, curNode = head.next;
        while(curNode != null){
            if(curNode.val == preNode.val){
                preNode.next = curNode.next;
                curNode = preNode.next;
            }else{
                preNode = curNode;
                curNode = curNode.next;
            }
        }
        return head;
    }


    public ListNode deleteDuplicatesB(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        ListNode curNode = head;
        while(curNode != null && curNode.next!= null){
            if(curNode.val == curNode.next.val){
                curNode.next = curNode.next.next;
            }else{
                //注意如果删除了一个节点，当前节点不应该移动
                curNode = curNode.next;
            }

        }
        return head;
    }

}
