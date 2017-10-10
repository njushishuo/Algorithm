package data_structure.stack;

import java.util.Queue;
import java.util.Stack;


/**
 * 使用两个栈来实现队列操作
 * 很明显，栈的特点是只能在栈顶进行压入或者弹出的操作， 而队列可以在队首和队尾进行操作，在队尾进行删除，在队尾进行插入。
 * 那么根据这些特点，我们不难想到可以用两个栈分别作为 队首和队尾
 * 入队操作，通过对队尾栈的push来的模拟
 * 出队操作，通过对队首栈的pop来模拟
 * 问题的关键在于一致性的保持
 * 首先我们对stack1 进行入队操作，当需要进行出队操作时，我们需要利用两次栈后进先出的特性，达到队列的先进先出的特性；
 * 我们把stack1进行清空pop，然后依次push进stack2中，再进行pop操作来达到出队的效果
 *
 * @param <T>
 */
public class QueueImplementedWithStack<T> {

    private Stack<T> head;
    private Stack<T> tail;
    private Queue queue;

    public QueueImplementedWithStack() {
        head = new Stack<T>();
        tail = new Stack<T>();
    }

    /**
     * 入队，插入到队尾
     */
    public void offer(T a){
        tail.push(a);
    }

    /**
     * 出队，删除队首
     * @return
     */
    public T take(){

        if(head.empty()){
            while(!tail.empty()){
                T temp = tail.pop();
                head.push(temp);
            }
        }

        return head.pop();
    }


}
