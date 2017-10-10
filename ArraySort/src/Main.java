public class Main {

    public static void main(String[] args) {

        InsertSort insertSort = new InsertSort();
        ShellSort shellSort = new ShellSort();
        BubbleSort bubbleSort = new BubbleSort();
        QuickSort quickSort = new QuickSort();
        MergeSort mergeSort = new MergeSort();

        int a[] = {7,5,3,9,0,1,2,4,8,6};

        ArrayHelper.printArray(a);
        //shellSort.shellSort(a);
        //bubbleSort.bubbleSort(a);
        //bubbleSort.bubbleSortImproved(a);
        //quickSort.quickSort(a);
        int[] temp = new int [10];
        mergeSort.mergeSort(a,temp);
        ArrayHelper.printArray(a);

    }
}
