package tree;

public class DepthOfTree {
    /* Definition for a binary tree node.*/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {
        return getDepthR(root);
    }

    private int getDepthR(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }

        return Math.max( getDepthR(treeNode.left), getDepthR(treeNode.right) ) +1;

    }
}
