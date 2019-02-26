package data_structure.List;

import data_structure.BinaryTree.BinaryNode;

import java.util.List;

/**
 * Created by ss14 on 2017/5/12.
 */
public class ListHelper {

    public static void printList(ListNode head){
        ListNode curNode = head;
        while(curNode!=null){

            System.out.print(curNode.value+"->");
            curNode=curNode.nextNode;
        }
        System.out.print("null\n");
    }

    public static void printDoublyLinkedListL2R(BinaryNode head){
        BinaryNode curNode = head;

        while(curNode!=null){
            System.out.print(curNode.value+"->");
            curNode=curNode.right;
        }
        System.out.print("null\n");
    }

    public static void printDoublyLinkedListR2L(BinaryNode head){
        if(head==null){
            return;
        }

        BinaryNode curNode = head;
        while(curNode.right!=null){
            curNode=curNode.right;
        }

        while(curNode!=null){
            System.out.print(curNode.value+"->");
            curNode=curNode.left;
        }
        System.out.print("null\n");
    }



    /**
     *
     * @param head
     * @return 拷贝的链表头
     */
    public static ListNode copyList(ListNode head){

        if(head==null){
            return null;
        }
        ListNode copyHead = new ListNode(head.value);
        ListNode curNode = head;
        ListNode copyCur = copyHead;
        ListNode tempNode;
        while(curNode.nextNode!=null){
            tempNode = new ListNode(curNode.nextNode.value);
            copyCur.nextNode = tempNode;
            copyCur = copyCur.nextNode;
            curNode = curNode.nextNode;
        }
        return copyHead;
    }




}
