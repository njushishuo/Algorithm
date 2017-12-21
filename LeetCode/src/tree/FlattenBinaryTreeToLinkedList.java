package tree;


public class FlattenBinaryTreeToLinkedList {

    /* Definition for a binary tree node.*/
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }
    }


    public static void main(String args [] ){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);

        b.left = c ; b.right =d;
        e.right =f ;
        a.left = b ; a.right =e;

        FlattenBinaryTreeToLinkedList fbt = new FlattenBinaryTreeToLinkedList();
        fbt.flatten(a);
        while(a != null){
            System.out.print(a.val+" ");
            a = a.right;
        }

    }


    public void flatten(TreeNode root) {

        this.flattenR(root);
    }

    public void flattenR(TreeNode root){
        if(root != null){
            if(root.left != null){
                this.flattenR(root.left);
            }

            if(root.right != null){
                this.flattenR(root.right);
            }

            if(root.left != null){
                TreeNode temp = root.right;
                root.right = root.left;
                root.left = null;
                TreeNode curNode = root.right;
                while(curNode.right != null){
                    curNode = curNode.right;
                }
                curNode.right = temp;
            }
        }
    }
}
