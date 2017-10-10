package data_structure.BinaryTree;

/**
 * Created by ss14 on 2017/5/17.
 */
public class IsAVLTree {



    public boolean isAvlTree(BinaryNode root){
        //return  isAVLTreeRecursively(root,new int [1]);
        return isAVLTreeAnotherWayR(root)!=-1;
    }


    /**
     * 利用后序遍历，每次判断子女是否是AVL树，
     * 如果是，再比较两个子女的高度差，如果不超过1，再计算当前节点的深度并返回true
     * 否则返回false
     *
     * 这里使用int [1]来模仿c++的指针作用，使得高层函数在调用完低层函数后能够看到修改的值。
     *
     * 这里所谓的“访问” 其实是指 判断当前的节点是否是一个AVL树，并计算树的深度
     * 并且访问左右子女 以条件判断隐式地发生。
     * @param root
     * @param depth
     * @return
     */
    public boolean isAVLTreeRecursively(BinaryNode root , int[] depth){


        //基本情况
        if(root==null){
            depth[0]=0;
            return true;
        }

        int left[] = new int [1];
        int right[] = new int [1];

        //先访问左子女，再访问有子女，最后处理根节点
        if(isAVLTreeRecursively(root.left , left)&&isAVLTreeRecursively(root.right, right)){
            if(Math.abs(left[0]-right[0])<=1){
                depth[0] = Math.max(left[0],right[0])+1;
                return  true;
            }
        }
        return false;
    }


    public int isAVLTreeAnotherWayR(BinaryNode root ){


        //基本情况
        if(root==null){
            return 0;
        }

        int leftHeight = isAVLTreeAnotherWayR(root.left) ;
        int rightHeight = isAVLTreeAnotherWayR(root.right);

        //先访问左子女，再访问有子女，最后处理根节点
        if(leftHeight!=-1&&rightHeight!=-1){
            if(Math.abs(leftHeight-rightHeight)<=1){
                return Math.max(leftHeight,rightHeight)+1;
            }
        }
        return -1;
    }
}
