package data_structure.BinaryTree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2017/5/17.
 */
public class DepthOfBinaryTreeTest {
    @Test
    public void getDepthSimpleWay() throws Exception {
        BinaryNode  a = new BinaryNode(1);
        BinaryNode  b = new BinaryNode(2);
        BinaryNode  c = new BinaryNode(3);
        BinaryNode  d = new BinaryNode(4);
        BinaryNode  e = new BinaryNode(5);
        BinaryNode  f = new BinaryNode(6);
        BinaryNode  g = new BinaryNode(7);
        a.left = b; a.right=c;
        b.left = d; b.right=e;
        c.right = f; e.left=g;

        DepthOfBinaryTree db = new DepthOfBinaryTree();
        assertEquals( 4,db.getDepthSimpleWay(a));
        assertEquals( 4,db.getDepth(a));

    }

}