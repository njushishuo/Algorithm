package data_structure.List;

/**
 * Created by ss14 on 2017/5/17.
 *
 * 两个单向链表有公共部分，寻找两个链表中第一个相同的节点
 * 输入: ListNode a, b
 * 输出: 第一个相同的节点
 *
 * 思路：
 *     两个链表只有可能在头部不一致，从之后的某各节点起，所有节点都是相同的，拓扑成"Y"形状
 *     想要找到第一个相同的节点，
 *     如果两个链表长度相同，则意味着分叉部分长度相同，那么只需要同时遍历连个链表，每次判断当前节点是否相同即可
 *     如果长度不同，那么只可能是分叉部分不同，我们只要实现遍历两个链表确定其长度，然后手动调整起始指针的位置，调节成一致即可
 *
 */
public class FirstCommonNode {

    public ListNode findFirstCommonNode(ListNode node1, ListNode node2){
        if(node1==null||node2==null){
            return null;
        }

        int len1 = getLength(node1);
        int len2 = getLength(node2);


        if(len1>len2){
            for(int i=0;i<len1-len2;i++){
                node1=node1.nextNode;
            }
        }else{
            for(int i=0;i<len2-len1;i++){
                node2=node2.nextNode;
            }
        }

        while(node1!=null&&node2!=null){
            if(node1==node2){
                return node1;
            }

            node1=node1.nextNode;
            node2=node2.nextNode;
        }

        return null;
    }

    private int getLength(ListNode node){

        int len =0;
        while(node!=null){
            len++;
            node=node.nextNode;
        }
        return len;
    }


}
