package data_structure.BinaryTree;

import java.util.LinkedList;

/**
 * Created by ss14 on 2017/5/14.
 * 二叉树的广度优先遍历算法
 * 思路就是要按层访问
 * 利用一个队列
 * 每次将根节点的子女入队；然后依次访问队列中每个元素，访问完之后从队列删除
 * 并将该元素的子女依次入队；
 *
 */
public class BFS {

    private LinkedList list;

    public BFS(){
        list = new LinkedList();
    }

    public void broadFirstSearch(BinaryNode root){

        if(root==null){
            return;
        }

        list.add(root);

        while(!list.isEmpty()){

            BinaryNode curNode = (BinaryNode) list.remove();
            if(curNode!=null) {
                printNode(curNode);
                list.add(curNode.left);
                list.add(curNode.right);
            }
        }
    }

    private void printNode(BinaryNode node){
        System.out.print(node.value+" ");
    }


}
