
public class InsertSort{

    public void insertSort( int a[] ){
        int i = 1;
        for(; i < a.length; i++){
            int tmp = a[i];
            int j;
            for( j = i-1 ; j>=0 && a[j] > tmp; j-- ){
                a[j+1] = a[j];
            }
            a[j+1] = tmp; 
        }
    }
}