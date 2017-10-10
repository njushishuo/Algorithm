package data_structure.BinaryTree;

/**
 * Created by ss14 on 2017/5/12.
 * 求一颗二叉树的镜像
 * 输入： 一颗二叉树的根节点
 *
 * 其实就是把所有非叶节点的做右子女调换
 * 可以采用任何一种访问方式，先序中序或者后序
 */
public class MirrorTree {

    public void mirrorRecursivePreOrder(BinaryNode node){
        if(node!=null){
            if(node.left!=null || node.right!=null){
                BinaryNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
            mirrorRecursivePreOrder(node.left);
            mirrorRecursivePreOrder(node.right);
        }
    }

    public void mirrorRecursiveInOrder(BinaryNode node){
        if(node!=null){
            mirrorRecursiveInOrder(node.left);

            if(node.left!=null || node.right!=null){
                BinaryNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }

            mirrorRecursiveInOrder(node.right);
        }
    }

    public void mirrorRecursivePostOrder(BinaryNode node){
        if(node!=null){
            mirrorRecursivePostOrder(node.left);
            mirrorRecursivePostOrder(node.right);

            if(node.left!=null || node.right!=null){
                BinaryNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
        }
    }


}
