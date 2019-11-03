public class BubbleSort{

    public void bubbleSort( int a[] ){
        int tmp;
        for(int i=0; i < a.length-1; i++){
            for(int j=0; j < a.length-1-i; j++ ){
                if(a[j] > a[j+1]){
                    tmp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = tmp; 
                }
            }
        }
    }
}