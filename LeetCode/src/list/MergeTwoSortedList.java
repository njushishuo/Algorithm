package list;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 * 返回的链表由输入的两个链表剪接而成
 */
public class MergeTwoSortedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    /**
     * 将l2 merge到 l1中
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsA(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        if(l1.val > l2.val){
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }

        ListNode curNode1 = l1, curNode2 = l2;

        while(curNode1!=null && curNode2!=null ) {

            if (curNode1.val <= curNode2.val) {
                if (curNode1.next != null) {
                    if (curNode1.next.val > curNode2.val) {

                        ListNode node2Tag = curNode2;
                        while(curNode2.next!=null && curNode1.next.val > curNode2.next.val){
                            curNode2 = curNode2.next;
                        }

                        ListNode temp = curNode2.next;
                        curNode2.next = curNode1.next;
                        curNode1.next = node2Tag;

                        curNode1 = curNode2.next;
                        curNode2 = temp;
                    } else {
                        curNode1 = curNode1.next;
                    }
                } else {
                    curNode1.next = curNode2;
                    return l1;
                }
            }
        }

        if(curNode2 !=null){
            curNode1.next = curNode2;
        }

        return l1;
    }


    /**
     * 将两个链表链接到一个新的链表中
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsB(ListNode l1, ListNode l2){
        ListNode pre1 = new ListNode(0);
        ListNode head = pre1;

        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                pre1.next = l1;
                l1 = l1.next;
            }else{
                pre1.next = l2;
                l2 = l2.next;
            }
            pre1 = pre1.next;
        }
        if(l1 == null) pre1.next = l2;
        else pre1.next = l1;
        return head.next;
    }
}
