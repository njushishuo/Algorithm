package data_structure.BinaryTree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ss14 on 2017/5/14.
 */
public class BFSTest {
    @Test
    public void BFS() throws Exception {
        BFS bfs = new BFS();
        BinaryNode _1 = new BinaryNode(1);
        BinaryNode _2 = new BinaryNode(2);
        BinaryNode _3 = new BinaryNode(3);
        BinaryNode _4 = new BinaryNode(4);
        BinaryNode _5 = new BinaryNode(5);
        BinaryNode _6 = new BinaryNode(6);

        _1.left=_2; _1.right=_3;
        _2.left=_4; _2.right=_5;
        _3.left=_6;

        bfs.broadFirstSearch(_1);


    }

}