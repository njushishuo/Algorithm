package list;
/**
 * https://leetcode.com/problems/merge-k-sorted-lists/discuss/
 * 厉害了一遍过
 */
public class MergeKSortedLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length <1){
            return null;
        }

        return  mergeKLists(lists,0,lists.length-1);
    }

    public ListNode mergeKLists(ListNode[] lists , int i , int j){

        if(i>=j){
            return lists[i];
        }
        int mid = (i+j)/2;
        ListNode left = mergeKLists(lists,i,mid);
        ListNode right = mergeKLists(lists,mid+1,j);
        return merge(left,right);
    }


    private ListNode merge(ListNode l1 , ListNode l2){
        ListNode preHead = new ListNode(0);
        ListNode curNode = preHead;
        while(l1 != null && l2 != null){
            if( l1.val < l2.val){
                curNode.next = l1;
                l1 = l1.next;
            }else{
                curNode.next = l2;
                l2 = l2.next;
            }
            curNode = curNode.next;
        }

        if(l1 != null){
            curNode.next = l1;
        }else{
            curNode.next = l2;
        }

        return preHead.next;
    }
}
