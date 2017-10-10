package string;

/**
 * https://leetcode.com/problems/construct-string-from-binary-tree/description/
 */
public class ConstructStringFromBT {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public String tree2str(TreeNode t) {
        if(t == null){
            return "";
        }
        StringBuilder s = new StringBuilder();
        tree2strR(t,s);
        return s.toString();
    }


    public void tree2strR(TreeNode t , StringBuilder s) {
        if(t == null){
            return;
        }
        s.append(t.val);
        if(t.left != null || t.right != null){
            s.append("(");
            tree2strR(t.left,s);
            s.append(")");
            if(t.right !=null){
                s.append("(");
                tree2strR(t.right,s);
                s.append(")");
            }
        }

    }
}
