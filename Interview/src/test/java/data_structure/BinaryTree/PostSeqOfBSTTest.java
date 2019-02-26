package data_structure.BinaryTree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2017/5/14.
 */
public class PostSeqOfBSTTest {
    @Test
    public void isPostSeqOfBST() throws Exception {
        int a [] = {5,7,6,9,11,10,8};
        int b [] = {7,4,6,5};
        int c [] = {1,4,5};
        int c1 [] = {7,8,5};
        int d [] = {4,5};
        int e [] = {5};
        assertTrue(PostSeqOfBST.isPostSeqOfBST(a , 0 ,a.length-1) ) ;
        assertFalse(PostSeqOfBST.isPostSeqOfBST(b , 0 ,b.length-1) );
        assertTrue(PostSeqOfBST.isPostSeqOfBST(c , 0 ,c.length-1) ) ;
        assertTrue(PostSeqOfBST.isPostSeqOfBST(c1 , 0 ,c.length-1) ) ;
        assertTrue(PostSeqOfBST.isPostSeqOfBST(d , 0 ,d.length-1) ) ;
        assertTrue(PostSeqOfBST.isPostSeqOfBST(e , 0 ,e.length-1) ) ;
    }

}