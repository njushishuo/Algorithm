package data_structure.BinaryTree;

import data_structure.List.ListHelper;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2017/5/14.
 */
public class BSTreeToDLListTest {
    @Test
    public void binarySearchTreeToDoublyLinkedList() throws Exception {

        BinaryNode  a = new BinaryNode(8);
        BinaryNode  b = new BinaryNode(6);
        BinaryNode  c = new BinaryNode(10);
        BinaryNode  d = new BinaryNode(5);
        BinaryNode  e = new BinaryNode(7);
        BinaryNode  f = new BinaryNode(9);
        BinaryNode  g = new BinaryNode(11);
        a.left = b; a.right=c;
        b.left = d; b.right=e;
        c.left = f; c.right=g;

        BSTreeToDLList bs = new BSTreeToDLList();

        BinaryNode listhead = bs.BinarySearchTreeToDoublyLinkedList(a);
        ListHelper.printDoublyLinkedListL2R(listhead);
        ListHelper.printDoublyLinkedListR2L(listhead);
    }

}