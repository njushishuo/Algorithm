package list;

/**
 * https://leetcode.com/problems/palindrome-linked-list/description/
 * 判断一个链表是不是对称的，要求O(n) O(1)
 *
 * 思路： 找到中点，将前半部分逆序。区分奇偶
 */
public class PalindromeLinkedList {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String args []){
        PalindromeLinkedList pl = new PalindromeLinkedList();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(0);
        ListNode c = new ListNode(2);
        a.next = b; b.next = c;
        System.out.println(pl.isPalindrome(a));
    }
    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }

        if(head.next == null){
            return true;
        }

        ListNode preHead = new ListNode(0);
        preHead.next = head;

        ListNode slowNode = preHead , fastNode = preHead;
        while(fastNode != null && fastNode.next != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }


        ListNode preNode = head , curNode = head.next , temp , leftEnd , rightStart;
        //odd
        if(fastNode == null){
            leftEnd = slowNode;
            rightStart = slowNode.next;
        }else{
            leftEnd = slowNode.next;
            rightStart = slowNode.next;
        }

        preNode.next =null ;
        while(curNode != leftEnd){
            temp = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = temp;
        }

        ListNode leftCur = preNode;
        ListNode rightCur = rightStart;
        while(leftCur != null && rightCur != null){
            if(leftCur.val != rightCur.val){
                return false;
            }

            leftCur = leftCur.next;
            rightCur = rightCur.next;
        }

        return true;
    }
}
