package GoodIdea;

import org.junit.Test;

/**
 * Created by ss14 on 2017/5/16.
 */
public class PartitionHelperTest {
    @Test
    public void partitionMid() throws Exception {

        int a1[] = {1,3,5,4,2,8,4,6};
        int a2[] = {2,1,3};
        int a3[] = {2,0,1,4,1};
        int a4[] = {2,0,6,4,1,3,7,4};
        int a5[] = {2,3,6,3,1};
        int a6[] = {1,2,3,4,5,6};
        int a7[] = {6,5,4,3,2,1};
        int a8[] = {1,2};
        int a9[] = {1};
        int a10 [] = {2,3,4,2,2};
        int a11[] = {1,2,5,7,4,3};
        test(a1);
        test(a2);
        test(a3);
        test(a4);
        test(a5);
        test(a6);
        test(a7);
        test(a8);
        test(a9);
        test(a10);
        test(a11);



    }


    private void  test(int a[]){
        ArrayHelper.printArray(a);
        PartitionHelper.partition(a , 0, a.length-1);
        ArrayHelper.printArray(a);
        System.out.println();
    }

}