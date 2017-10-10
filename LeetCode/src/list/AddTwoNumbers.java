package list;

/**
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 */
public class AddTwoNumbers {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x)
      {
          val = x;
      }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode resultHead = new ListNode(-1);
        ListNode resultCur = resultHead;

        int addition=0;
        int temp =0;
        while(l1!=null && l2!=null){
            temp = (l1.val+l2.val+addition)%10;
            addition =  (l1.val+l2.val+addition)/10;
            ListNode node = new ListNode(temp);
            resultCur.next = node;
            resultCur = resultCur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1!=null){
            temp = (l1.val+addition)%10;
            addition =  (l1.val+addition)/10;
            ListNode node = new ListNode(temp);
            resultCur.next = node;
            resultCur = resultCur.next;
            l1 = l1.next;
        }

        while(l2!=null){
            temp = (l2.val+addition)%10;
            addition =  (l2.val+addition)/10;
            ListNode node = new ListNode(temp);
            resultCur.next = node;
            resultCur = resultCur.next;
            l2 = l2.next;

        }

        if(addition>0){
            ListNode node = new ListNode(addition);
            resultCur.next = node;
        }

        return resultHead.next;
    }

}
