package list;

/**
 * https://leetcode.com/problems/partition-list/description/
 *
 * 输入: 一个链表 和一个数值a
 * 输出：切分过的链表，要求所有值小于a的节点在前，大于等于a 的节点在后；要求相对顺序不变
 *
 * 思路: 两根线分别把需要的节点串起来，最后两个链表连起来
 */
public class PartitionList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public ListNode partition(ListNode head, int x) {


        if(head == null){
            return null;
        }

        ListNode leftHead = new ListNode(0);
        ListNode rightHead = new ListNode(0);
        ListNode leftCur = leftHead , rightCur = rightHead ,  curNode = head;

        while(curNode != null){
            if(curNode.val < x){
                leftCur.next = curNode;
                leftCur = leftCur.next;
            }else{
                rightCur.next = curNode;
                rightCur = rightCur.next;
            }

            curNode = curNode.next;
        }

        rightCur.next = null;
        leftCur.next = rightHead.next;

        return leftHead.next;
    }

}
