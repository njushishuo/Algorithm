package data_structure.BinaryTree;

/**
 * Created by ss14 on 2017/5/12.
 */
public class TreeHelper {

    public static void preOrder(BinaryNode root){
        if(root!=null){
            System.out.print(root.value);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void inOrder(BinaryNode root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.value);
            inOrder(root.right);
        }
    }

    public static void postOrder(BinaryNode root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.value);
        }
    }
}
