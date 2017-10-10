package data_structure.BinaryTree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2017/6/26.
 */
public class IsAVLTreeTest {


    @Test
    public void isAVLTreeRecursively() throws Exception {

        BinaryNode  a = new BinaryNode(1);
        BinaryNode  b = new BinaryNode(2);
        BinaryNode  c = new BinaryNode(3);
        BinaryNode  d = new BinaryNode(4);
        BinaryNode  e = new BinaryNode(5);
        BinaryNode  f = new BinaryNode(6);
        BinaryNode  g = new BinaryNode(7);
        a.left = b; a.right =c;
        b.left = d; b.right =e;
        c.left = f; c.right =g;

        IsAVLTree is = new IsAVLTree();

        System.err.println(is.isAvlTree(a));

    }

    @Test
    public void isAVLTreeAnotherWayR() throws Exception {


        BinaryNode  a = new BinaryNode(1);
        BinaryNode  b = new BinaryNode(2);
        BinaryNode  c = new BinaryNode(3);
        BinaryNode  d = new BinaryNode(4);
        BinaryNode  e = new BinaryNode(5);
        BinaryNode  f = new BinaryNode(6);

        a.left = b;
        b.left = d; b.right =e;


        IsAVLTree is = new IsAVLTree();

        System.err.println(is.isAvlTree(a));
    }

}