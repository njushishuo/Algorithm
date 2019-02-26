package data_structure.BinaryTree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2017/5/12.
 */
public class MirrorTreeTest {
    @Test
    public void mirrorRecursivePreOrder() throws Exception {

        BinaryNode  a = new BinaryNode(1);
        BinaryNode  b = new BinaryNode(2);
        BinaryNode  c = new BinaryNode(3);
        BinaryNode  d = new BinaryNode(4);
        BinaryNode  e = new BinaryNode(5);
        BinaryNode  f = new BinaryNode(6);
        BinaryNode  g = new BinaryNode(7);
        a.left = b; a.right =c;
        b.left = d; b.right =e;
        d.left = f; d.right =g;

        MirrorTree mirrorTree  = new MirrorTree();
        TreeHelper.inOrder(a);
        System.out.print('\n');
        mirrorTree.mirrorRecursivePreOrder(a);
        TreeHelper.inOrder(a);
        System.out.print('\n');


    }

    @Test
    public void mirrorRecursiveInOrder() throws Exception {

        BinaryNode  a = new BinaryNode(1);
        BinaryNode  b = new BinaryNode(2);
        BinaryNode  c = new BinaryNode(3);
        BinaryNode  d = new BinaryNode(4);
        BinaryNode  e = new BinaryNode(5);
        BinaryNode  f = new BinaryNode(6);
        BinaryNode  g = new BinaryNode(7);
        a.left = b; a.right =c;
        b.left = d; b.right =e;
        d.left = f; d.right =g;

        MirrorTree mirrorTree  = new MirrorTree();
        TreeHelper.inOrder(a);
        System.out.print('\n');
        mirrorTree.mirrorRecursiveInOrder(a);
        TreeHelper.inOrder(a);
        System.out.print('\n');

    }

    @Test
    public void mirrorRecursivePostOrder() throws Exception {

        BinaryNode  a = new BinaryNode(1);
        BinaryNode  b = new BinaryNode(2);
        BinaryNode  c = new BinaryNode(3);
        BinaryNode  d = new BinaryNode(4);
        BinaryNode  e = new BinaryNode(5);
        BinaryNode  f = new BinaryNode(6);
        BinaryNode  g = new BinaryNode(7);
        a.left = b; a.right =c;
        b.left = d; b.right =e;
        d.left = f; d.right =g;

        MirrorTree mirrorTree  = new MirrorTree();
        TreeHelper.inOrder(a);
        System.out.print('\n');
        mirrorTree.mirrorRecursivePostOrder(a);
        TreeHelper.inOrder(a);
        System.out.print('\n');
    }

}