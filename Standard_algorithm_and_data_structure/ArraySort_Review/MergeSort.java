// O(N*logN) Recursive
public class MergeSort{

    public void mergeSort(int a[]){
        int[] tmpArray = new int[a.length];
        mergeSortR(a, tmpArray, 0, a.length-1);
    }

    private void mergeSortR(int a[], int tmp[], int start, int end ){
        if(start >= end){
            return;
        }
        int center = (start + end)/2;
        mergeSortR(a, tmp, start, center);
        mergeSortR(a, tmp, center+1, end);
        merge(a, tmp, start, center , end );
    }

    private void merge(int a[], int tmp[], int left, int center, int right){
        int tmpIndex = left;
        int leftIndex = left;
        int rightIndex = center+1;

        while( leftIndex <= center && rightIndex <=right ){
            if( a[leftIndex] <= a[rightIndex] ){
                tmp[tmpIndex++] = a[leftIndex++];
        
            }else{
                tmp[tmpIndex++] = a[rightIndex++];
            }
        }

        while( leftIndex <= center ){
            tmp[tmpIndex++] = a[leftIndex++];
        }

        while( rightIndex <= right ){
            tmp[tmpIndex++] = a[rightIndex++];
        }

        System.out.print("merge: ");
        for(int i = left; i <= right; i++){
            a[i] = tmp[i];
            System.out.print(a[i]+" ");
        }
        System.out.print("\n");
    }
}