public class Main {

    public static void main(String[] args) {

        int a[] = {7,5,3,1,2,4,0,6,6,5,7,3,1,2,4,4,3,7};
        ArrayHelper.printArray(a);

        //InsertSort insertSort = new InsertSort();
        //ShellSort shellSort = new ShellSort();
        // BubbleSort bubbleSort = new BubbleSort();
         QuickSort quickSort = new QuickSort();
        //MergeSort mergeSort = new MergeSort();

    
        //shellSort.shellSort(a);
        //bubbleSort.bubbleSort(a);
        //bubbleSort.bubbleSortImproved(a);
        quickSort.quickSort(a);
        // mergeSort.mergeSort(a);


        ArrayHelper.printArray(a);

    }
}
