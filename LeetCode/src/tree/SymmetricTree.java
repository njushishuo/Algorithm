package tree;





public class SymmetricTree {

    /* Definition for a binary tree node.*/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    // Time : O(n) , Space : O(1)
    public boolean isSymmetric(TreeNode root) {

        if(root == null) {
            return  true;
        }

        return  isSymmetric(root.left , root.right);

    }


    private boolean isSymmetric (TreeNode rootA, TreeNode rootB){

        if(rootA == null && rootB == null){
            return true;
        }else if(rootA != null && rootB != null){

            return rootA.val == rootB.val && isSymmetric(rootA.left , rootB.right) && isSymmetric(rootA.right , rootB.left);
        }

        return false;

    }


    private class Solution{

    }

}
