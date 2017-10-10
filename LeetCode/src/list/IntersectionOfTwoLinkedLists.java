package list;


/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 * 只需要判断是否有环
 *
 */
public class IntersectionOfTwoLinkedLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }



    public static void main(String args []){
        IntersectionOfTwoLinkedLists iw = new IntersectionOfTwoLinkedLists();
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(3);
        b.next = a;

        ListNode result = iw.getIntersectionNode(a,b);
        if(result != null){
            System.out.println(result.val);
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }

        int lengthA = 0, lengthB = 0;
        ListNode curNodeA = headA;
        ListNode curNodeB = headB;
        while(curNodeA != null){
            lengthA++;
            curNodeA = curNodeA.next;
        }

        while(curNodeB != null){
            lengthB++;
            curNodeB = curNodeB.next;
        }

        if(lengthA < lengthB){
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }

        curNodeA = headA;
        curNodeB = headB;

        for(int i=0; i<Math.abs(lengthA-lengthB); i++){
            curNodeA = curNodeA.next;
        }

        while(curNodeA != null && curNodeB !=null){
            if(curNodeA == curNodeB){
                return new ListNode(curNodeA.val);
            }else{
                curNodeA = curNodeA.next;
                curNodeB = curNodeB.next;
            }
        }

        return null;
    }
}
