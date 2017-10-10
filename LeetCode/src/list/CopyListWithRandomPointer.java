package list;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 *
 * 方法1：首先遍历链表，同时建立新的链表，以及保存输入和输出链表的每个节点的对应关系；
 *       第二次遍历，设置好random   space: O(n)  time: O(n)
 *
 * 方法2：真的必须用map来存储吗？ 除了输入和输出的必须空间外不再额外使用
 *
 */
public class CopyListWithRandomPointer {

    class RandomListNode {
          int label;
          RandomListNode next, random;
          RandomListNode(int x) { this.label = x; }
    }


    public RandomListNode copyRandomList(RandomListNode head) {
            if(head == null){
                return null;
            }

            HashMap<RandomListNode,RandomListNode> hashMap = new HashMap<>();

            RandomListNode resultHead = new RandomListNode(head.label);
            RandomListNode resCurNode  = resultHead;
            RandomListNode curNode  = head;
            hashMap.put(head , resultHead);

            while(curNode.next!=null){
                RandomListNode newNode = new RandomListNode(curNode.next.label);
                resCurNode.next = newNode;

                resCurNode = resCurNode.next;
                curNode = curNode.next;
                hashMap.put(curNode , resCurNode);
            }

            curNode = head;
            resCurNode = resultHead;

            while(curNode!=null){
                RandomListNode temp = hashMap.get(curNode.random);
                if(temp != null){
                    RandomListNode randomListNode = new RandomListNode(temp.label);
                    resCurNode.random = randomListNode;
                }
                resCurNode = resCurNode.next;
                curNode = curNode.next;
            }

            return resultHead;
    }

    public RandomListNode copyRandomListBetter(RandomListNode head) {

        if(head == null){
            return null;
        }

        RandomListNode curNode  = head;
        while(curNode != null){
            RandomListNode copyNode = new RandomListNode(curNode.label);
            copyNode.next = curNode.next;
            curNode.next = copyNode;
            curNode = copyNode.next;
        }

        curNode = head;
        while(curNode != null){
            curNode.next.random = curNode.random == null? null: curNode.random.next;
            curNode = curNode.next.next;
        }

        curNode = head;
        RandomListNode resultHead = head.next;
        RandomListNode nextNode = head.next;
        while(curNode != null){
            curNode.next = nextNode.next;
            nextNode.next = curNode.next == null? null : curNode.next.next;
            curNode = curNode.next;
            nextNode = nextNode.next;
        }

        return resultHead;
    }
}
