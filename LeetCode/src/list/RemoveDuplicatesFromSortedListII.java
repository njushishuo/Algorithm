package list;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
 * 所有出现两次及以上的节点删除
 */
public class RemoveDuplicatesFromSortedListII {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String args []){
        RemoveDuplicatesFromSortedListII rd = new RemoveDuplicatesFromSortedListII();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        a.next = b;
        rd.deleteDuplicates(a);
    }



    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return  head;
        }

        //既然要做到重复的全部删除，就需要一个前置节点
        ListNode preHead = new ListNode(0);
        preHead.next = head;

        //preNode用于串联符合要求的下一个节点
        ListNode preNode = preHead , curNode = head;
        while(curNode != null && curNode.next != null){

            if(curNode.val == curNode.next.val){
                while (curNode != null
                        && curNode.next != null
                        && curNode.val == curNode.next.val){
                    curNode = curNode.next;
                }
                //只是跳过这些重复的节点,暂时不设置preNode.next,因为可能curNode正指向另一个重复的节点
                curNode = curNode.next;
            }else {

                //此时确定该节点不是重复的，即应当保留下来,设置preNode.next并移动preNode
                preNode.next = curNode;
                preNode = preNode.next;
                curNode = curNode.next;
            }
        }

        //最后设置一下最后一个节点
        preNode.next = curNode;
        return preHead.next;
    }
}
