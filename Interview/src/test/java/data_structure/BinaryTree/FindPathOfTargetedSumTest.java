package data_structure.BinaryTree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2017/5/14.
 */
public class FindPathOfTargetedSumTest {
    @Test
    public void findPathWithSumEqualsTo() throws Exception {
        BinaryNode  a = new BinaryNode(10);
        BinaryNode  b = new BinaryNode(5);
        BinaryNode  c = new BinaryNode(12);
        BinaryNode  d = new BinaryNode(4);
        BinaryNode  e = new BinaryNode(7);
        a.left = b; a.right=c;
        b.left = d; b.right=e;

        FindPathOfTargetedSum  findPath = new FindPathOfTargetedSum();
        findPath.findPathWithSumEqualsTo(a,22);

    }

}