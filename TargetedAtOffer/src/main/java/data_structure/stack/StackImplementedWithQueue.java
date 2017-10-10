package data_structure.stack;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by ss14 on 2017/5/3.
 */
public class StackImplementedWithQueue<T> {

    private LinkedList<T> queue1 ;
    private LinkedList<T> queue2 ;

    public StackImplementedWithQueue(){
        queue1 = new LinkedList<T>();
        queue2 = new LinkedList<T>();
    }

    public void push(T t){
        if(queue1.isEmpty()){
            queue2.add(t);
        }else {
            queue1.add(t);
        }
    }

    public T pop(){

        int size=0;

        if(queue2.isEmpty()&&!queue1.isEmpty()){
            size= queue1.size();
            for(int i=0;i<size-1;i++){
                T t = queue1.removeFirst();
                queue2.add(t);
            }
            return  queue1.removeFirst();

        }else if(queue1.isEmpty()&&!queue2.isEmpty()){
            size= queue2.size();
            for(int i=0;i<size-1;i++){
                T t = queue2.removeFirst();
                queue1.add(t);
            }
            return  queue2.removeFirst();
        }

        return null;
    }

    public void print(){
        if(queue1.isEmpty()){
            System.out.println(queue2);
        }else{
            System.out.println(queue1);
        }
    }






}
