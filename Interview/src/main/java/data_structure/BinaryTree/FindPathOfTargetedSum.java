package data_structure.BinaryTree;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by ss14 on 2017/5/14.
 * 输入： 二叉树根节点， 一个整数
 * 输出: 打印，所有和为该整数的二叉树遍历路径
 * (从根节点到某一个叶节点所经过的所有节点构成一条路径)
 *
 * 思路: 由于二叉树的数值大小没有任何性质，所以只能采用穷举法；
 * 找出所有路径，然后判断该路径和是否等于target;
 *
 */
public class FindPathOfTargetedSum {

    public void findPathWithSumEqualsTo(BinaryNode<Integer> root , int target ){

        if(root==null){
            return;
        }

        LinkedList<BinaryNode> list = new LinkedList();
        int curSum = 0;
        findPathRecursive(root,list,target,curSum);

    }

    public void findPathRecursive(BinaryNode<Integer> root ,LinkedList<BinaryNode> list
            , int target , int curSum){

        list.add(root);
        curSum+=root.value;

        if(isLeafNode(root) && curSum==target){
            printPath(list);
        }

        if(root.left!=null){
            findPathRecursive(root.left,list,target,curSum);
        }

        if(root.right!=null){
            findPathRecursive(root.right,list,target,curSum);
        }

        list.removeLast();
        //curSum-=root.value;
    }



    private void printPath(List<BinaryNode> list){
        for(BinaryNode node:list){
            System.out.print(node.value+" ");
        }
        System.out.print('\n');
    }

    private boolean isLeafNode(BinaryNode node){

        if(node.left==null && node.right==null){
            return true;
        }
        return false;
    }


}
