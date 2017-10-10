package data_structure.BinaryTree;

/**
 * Created by ss14 on 2017/5/17.
 * 输入: BinaryNode root
 * 输出: 该二叉树的深度(从根节点到叶节点的最长路径长度,只有一个节点时深度为1)
 *
 */
public class DepthOfBinaryTree {


    //找出所有路径，然后去最大值
    public int getDepthSimpleWay(BinaryNode root){

        if(root==null){
            return 0;
        }

        int [] maxLen = new int [1];
        getDepthSimpleWayRecursively(root,maxLen ,0);
        return maxLen[0];
    }
    private void getDepthSimpleWayRecursively(BinaryNode root, int[] maxLen , int curLen){
        if(root==null){
            return ;
        }
        curLen++;
        if(isLeafNode(root)){
            if(curLen>maxLen[0]){
                maxLen[0] =curLen;
            }
        }else{
            if(root.left!=null){
                getDepthSimpleWayRecursively(root.left,maxLen,curLen);
            }
            if(root.right!=null){
                getDepthSimpleWayRecursively(root.right,maxLen,curLen);
            }
        }
        curLen--;
    }
    private boolean isLeafNode(BinaryNode node){

        if(node.left==null && node.right==null){
            return true;
        }
        return false;
    }


    //递归方式
    public int getDepth(BinaryNode root){

        if(root==null){
            return 0;
        }

        int leftDepth=0, rightDepth=0;

        if(root.left!=null){
            leftDepth= getDepth(root.left);
        }

        if(root.right!=null){
            rightDepth = getDepth(root.right);
        }
        return Math.max(leftDepth,rightDepth)+1;
    }





}
