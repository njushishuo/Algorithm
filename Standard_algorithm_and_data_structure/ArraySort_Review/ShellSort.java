
/**
 * shellsort:  incremental sequence: hk, hk-1, hk-2,  h1 = 1;
 * each time use hk to do insert sort, make sure a[i], a[i-hk], a[i-2hk],,, is sorted;
 */
public class ShellSort{

    public void shellSort( int a[] ){
        int gap = a.length/2;
        for( ; gap > 0; gap/=2){
            int i = gap;
            for(; i < a.length; i++){
                int tmp = a[i];
                int j;
                for( j = i-gap; j >= 0 && a[j] > tmp; j-=gap ){
                    a[j+gap] = a[j];
                }
                a[j+gap] = tmp;
            }
        }
    }
}