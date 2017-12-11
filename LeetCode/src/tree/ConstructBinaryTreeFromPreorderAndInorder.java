package tree;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 */
public class ConstructBinaryTreeFromPreorderAndInorder {

    /* Definition for a binary tree node.*/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0){
            return null;
        }

        return this.buildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder , int leftP , int rightP , int leftI , int rightI){

        if(leftP > rightP || leftI > rightI || leftP >= preorder.length || leftI >= inorder.length){
            return null;
        }

        if(leftP == rightP){
            return new TreeNode(preorder[leftP]);
        }

        int leftLength = 0;
        int rightLength = 0;
        int rootVal = preorder[leftP];
        int rootIndex = leftI;
        for(int i = leftI ; i < inorder.length; i++){
            if(inorder[i] == rootVal){
                leftLength = i-leftI;
                rootIndex = i;
                break;
            }
        }

        rightLength = rightP - leftP - leftLength;

        TreeNode root = new TreeNode(rootVal);
        if(leftLength > 0 ){
            root.left = buildTree(preorder, inorder, leftP+1 , leftP + leftLength , leftI , leftI + leftLength-1);
        }

        if(rightLength > 0){
            root.right = buildTree(preorder, inorder, leftP + leftLength +1 , leftP + leftLength + rightLength , rootIndex +1  , rootIndex+rightLength);
        }
        return root;
    }
}
