package data_structure.stack;

import java.util.Stack;

/**
 * Created by ss14 on 2017/5/14.
 * 输入两个整数数组，第一个数组是压入序列，判断第二个数组是否是该压入序列的一个弹出序列
 */
public class PushPopSequence {

    private Stack<Integer> stack;

    public PushPopSequence(){
        stack = new Stack<Integer>();
    }

    public boolean isPopSequence(int [] pushSeq , int [] popSeq){

        int pushIndex = 0;
        int popIndex = 0;
        while(popIndex<popSeq.length){
            //当前栈为空或者栈顶元素跟当前的输出序列不一致
            if(stack.empty()||popSeq[popIndex]!=stack.peek()){
                while(pushIndex<pushSeq.length && pushSeq[pushIndex]!=popSeq[popIndex]){
                    stack.push(pushSeq[pushIndex]);
                    pushIndex++;
                }
                if(pushIndex>=pushSeq.length){
                    return false;
                }
                stack.push(pushSeq[pushIndex]);
            }
            stack.pop();
            pushIndex++;
            popIndex++;
        }
        return true;

    }

}
