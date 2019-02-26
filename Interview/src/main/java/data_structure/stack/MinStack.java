package data_structure.stack;

import java.util.Stack;

/**
 * Created by ss14 on 2017/5/14.
 * 要求：实现一个带Min功能的栈
 * 要求 push pop min 操作时间复杂度均为O(1)
 * 如何处理min？怎样才能随时保持可以取出当前栈中的最小值？
 * 当Push一个新元素时，如何维持最小值； 当pop一个元素时又如何维护最小值。
 * 当弹出当前栈中最小元素时，如何保证min变为第二小的元素？
 *
 *
 */
public class MinStack<T extends Comparable> {

    private Stack<T> workStack;
    private Stack<T> minStack;

    public MinStack (){
        this.minStack = new Stack();
        this.workStack = new Stack();
    }

    public void push(T a){

        workStack.push(a);

        if(minStack.empty()){
            minStack.push(a);
        }else{
            if(a.compareTo(minStack.peek())<0){
                minStack.push(a);
            }else{
                minStack.push(minStack.peek());
            }
        }
    }

    public T pop(){
        if(!workStack.empty()){
           T a = workStack.pop();
            minStack.pop();
            return a;
        }
        return null;
    }

    public T min(){
        return minStack.peek();
    }
}
