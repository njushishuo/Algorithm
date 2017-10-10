package list;

/**
 * https://leetcode.com/problems/insertion-sort-list/description/
 */
public class InsertSort {


    public static void main(String args[]){
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        a.next = b; b.next = c;
        InsertSort is = new InsertSort();
        ListNode result = is.insertionSortList(a);

        while(result != null){
            System.out.print(result.val+" ");
            result = result.next;
        }

    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode insertionSortList(ListNode head) {

        if(head == null){
            return null;
        }

        ListNode iNode = head.next;
        ListNode preFlagNode,flagNode,jNode, preNode;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        preFlagNode = head;
        while(iNode != null){
            flagNode = iNode;
            jNode = newHead.next;
            preNode = newHead;
            while(jNode != flagNode && jNode.val <= flagNode.val){
                preNode = preNode.next;
                jNode = jNode.next;
            }

            if(jNode != flagNode){
                preFlagNode.next = flagNode.next;
                preNode.next = flagNode;
                flagNode.next = jNode;
                iNode = preFlagNode.next;
            }else{
                iNode = iNode.next;
                preFlagNode = preFlagNode.next;
            }
        }

        return newHead.next;
    }
}
