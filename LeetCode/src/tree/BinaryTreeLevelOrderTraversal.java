package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 */
public class BinaryTreeLevelOrderTraversal {
    /* Definition for a binary tree node.*/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }





    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();


        queue.add(root);
        int cnt = 1;
        int nextCnt = 0;

        while( !queue.isEmpty()){
            List<Integer> curLevel = new ArrayList<>();
            while( cnt > 0 ){
                TreeNode node =  queue.removeFirst();
                curLevel.add(node.val);
                cnt--;
                if(node.left != null){
                    nextCnt++;
                    queue.addLast(node.left);
                }

                if(node.right != null){
                    nextCnt++;
                    queue.addLast(node.right);
                }
            }
            cnt = nextCnt;
            nextCnt = 0;
            result.add(curLevel);
        }

        return result;

    }

}
