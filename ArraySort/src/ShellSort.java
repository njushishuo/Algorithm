/**
 * Created by ss14 on 2017/3/21.
 */
public class ShellSort {


    /**
     * 采用增量序列1,h2,h3,,,,length/2
     * @param a
     */
    public void shellSort(int a[]){

        for(int gap = a.length/2 ; gap>=1 ; gap/=2 ){

            int j;
            for( int i=gap; i<a.length;i++  ){

                int temp = a[i];
                for(j=i; j>=gap&& temp<a[j-gap]; j-=gap){

                    a[j] = a[j-gap];
                }
                a[j] = temp;
            }
        }
    }


}
