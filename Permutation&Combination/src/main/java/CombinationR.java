import java.util.LinkedList;
import java.util.List;

/**
 * Created by ss14 on 2017/5/12.
 * 递归实现打印组合数
 * 输入：int []array , int m
 *      {1,2,3,4}  2
 * 输出：12 13 14
 *      23 24
 *      34
 * 思路： 沿用排列的思路
 * 采用 List temp暂时存储已经被选中的元素,index不再表示当前处理到那个位置了
 * 而表示本次应该从array的那个位置开始选择下一个元素
 * 需要注意的是，每次遍历数组时的下标上限：
 *  a.length-m+temp.size()
 */
public class CombinationR {

    public void printCombination (int [] a,int m){

        if(a==null||m<=0){
            return;
        }
        LinkedList<Integer> temp = new LinkedList<Integer>();
        combinationR(a, temp,m , 0);
    }

    /**
     *
     * @param a
     * @param temp
     * @param m
     * @param index  当前元素应该从a中那个位置开始选择，从0开始计算
     */
    private void combinationR(int[] a, LinkedList temp ,int m,int index ){
        if(temp.size()>= m){
            printList(temp);
            return;
        }
        int upper = a.length-m+temp.size();
        for(int i=index; i<=upper ;i++){
            temp.addLast(a[i]);
            combinationR(a,temp,m, i+1);
            temp.removeLast();

        }
    }

    private void printList(List a){
        System.out.println(a);
    }

}
