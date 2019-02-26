import java.util.*;

/**
 * Created by ss14 on 2017/5/4.
 * 递归实现打印排列数
 * 输入： int [] a ;  int m
 * 输出： 打印每个排列情况
 *
 * 思想： n = a.length  m = m;
 * 一个排列情况，其实就是从n个数中，依次挑出m个数
 * 采用递归的思想，使用m容量的额外空间temp
 * 当已经填充了m个元素时，打印结果
 *
 * 每次遍历数组，挑选没有被选中过的元素加入到temp中去，然后递归地调用
 * 注意：递归返回后，需要从temp中删除之前添加的元素 ，以达到擦除影响的目的
 *
 */
public class PermutationR {

    /**
     * @param inputArray 数组
     * @param m
     * 从数组中选出m个数
     */
    public void printPermutaion( int [] inputArray ,int m){

        if(m<=0){
            return;
        }

        int []a = reduceDuplication(inputArray);
        LinkedList<Integer> temp = new LinkedList<Integer>();
        printPermutationRecursively(a,temp, m);

    }

    private int [] reduceDuplication(int a[]){
        Set set = new HashSet();
        for(int i=0; i<a.length ; i++){
            set.add(a[i]);
        }
        Integer [] tempArray = (Integer[]) set.toArray(new Integer[set.size()]);
        int [] result = new int [tempArray.length];
        for(int i=0;i<result.length;i++ ){
            result[i]=tempArray[i];
        }
        return result;
    }

    private void printPermutationRecursively(int [] a , LinkedList<Integer> temp, int m){
        if(temp.size()>=m){
            printList(temp);
            return;
        }

        for(int i=0;i<a.length;i++) {
            if (!temp.contains(a[i])) {
                temp.addLast(a[i]);
                printPermutationRecursively(a, temp,m);
                temp.removeLast();
            }
        }
    }

    private void printList(List temp){
        System.out.println(temp);
    }

}
