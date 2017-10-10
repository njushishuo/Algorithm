package data_structure.BinaryTree;

/**
 * Created by ss14 on 2017/5/14.
 * 二叉搜索树 转化为 双向链表；
 * 链表从左到右依次递增
 *
 * 思路： 关键在于如何转化
 * 递归，首先把左右子树转化为正确的双链表，然后再把根节点和左右子女链接起来。
 * 连接的方式：  根节点左边指向 左子女的最右侧的元素也就是最大值
 *             根节点右边指向 右子女的最左边的元素也就是最小值
 */
public class BSTreeToDLList<T extends  Comparable> {

    public BinaryNode<T>
        BinarySearchTreeToDoublyLinkedList(BinaryNode<T> root){

        if(root==null){
            return null;
        }

        //先将BST转化为双链表
        root = convert(root);
        BinaryNode<T> listHead = root;

        //找到头结点
        while(listHead.left!=null){
            listHead = listHead.left;
        }
        return listHead;
    }


    public BinaryNode<T> convert(BinaryNode<T> root){

        if(root==null){
            return null;
        }

        root.left = convert(root.left);
        root.right = convert(root.right);


        if(root.left!=null){
            BinaryNode<T> leftChild = findMax(root.left);
            root.left = leftChild;
            leftChild.right = root;
        }

        if(root.right!=null){
            BinaryNode<T> rightChild = findMin(root.right);
            root.right = rightChild;
            rightChild.left = root;
        }

        return root;
    }


    private BinaryNode<T> findMax(BinaryNode<T> root){

        BinaryNode<T> curNode = root;
        if(curNode!=null){
            while(curNode.right!=null){
                curNode = curNode.right;
            }
        }
        return curNode;
    }

    private BinaryNode<T> findMin(BinaryNode<T> root){


        BinaryNode<T> curNode = root;
        if(curNode!=null){
            while(curNode.left!=null){
                curNode = curNode.left;
            }
        }
        return curNode;
    }

}
