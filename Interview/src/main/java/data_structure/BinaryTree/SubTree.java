package data_structure.BinaryTree;

/**
 * Created by ss14 on 2017/5/12.
 * 判断一个二叉树是否是另一个二叉树的子树
 * 输入: BinaryNode a , b
 * 输出: 若a包含b，返回true;否则返回false;
 * 当a,b均为Null时返回false;
 */
public class SubTree {

    public boolean hasSubTree(BinaryNode nodeA , BinaryNode nodeB){

        boolean hasSubTree = false;
        if(nodeA!=null&&nodeB!=null){
            //如果根节点匹配，就继续看从各自根节点开始结构是否相同
            if(nodeA.value.compareTo(nodeB.value)==0){
                hasSubTree = hasSubTreeFromRoot(nodeA,nodeB);
            }

            //如果根节点匹配失败了，就递归地从左子女开始匹配
            if(!hasSubTree){
                hasSubTree = hasSubTree(nodeA.left,nodeB);
            }

            //如果左子女也匹配失败了，就递归地从右子女开始匹配
            if(!hasSubTree){
                hasSubTree = hasSubTree(nodeA.right,nodeB);
            }
        }

        return hasSubTree;
    }

    public boolean hasSubTreeFromRoot(BinaryNode rootA , BinaryNode rootB ){

        //如果rootB为null，说明子树已经遍历完毕
        if(rootB==null){
            return true;
        }

        //如果rootB!=null 且 rootA == null，说明不匹配
        if(rootA==null){
            return false;
        }

        //如果rootB!=null 且 rootA!=null
        if(rootA.value.compareTo(rootB.value)!=0){
            return false;
        }else{

            return hasSubTreeFromRoot(rootA.left , rootB.left) &&
                   hasSubTreeFromRoot(rootA.right , rootB.right) ;

        }

    }




}
