import java.io.FileNotFoundException;
import sorting.BottomUpMergeSort;
import sorting.CutOffQuickSort;
import sorting.InsertionSort;
import sorting.MedianOfThreeQuickSort;
import sorting.MergeInsertionSort;
import sorting.MergeSort;
import sorting.MinHeap;
import sorting.QuickSort;
import sorting.SelectionSort;
import sorting.ShellSort;
import sorting.ThreeWayQuickSort;
import sorting.Utility;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        testSortsWork();
        calculateAverageTimes();
        findKLargest();
        System.exit(0);
    }

    private static void testSortsWork() throws FileNotFoundException {   
        String f = "src/main/java/files/int10.txt";

        int[] d = ReadArrays.readArray(f);
        InsertionSort.sort(d, 0, d.length);
        System.out.println("Insertion Sort: " +Utility.isSorted(d));

        d = ReadArrays.readArray(f);
        SelectionSort.sort(d);
        System.out.println("Selection Sort: " + Utility.isSorted(d));

        d = ReadArrays.readArray(f);
        ShellSort.sort(d);
        System.out.println("Shell Sort: " + Utility.isSorted(d));

        d = ReadArrays.readArray(f);
        MergeSort.sort(d, 0, d.length-1);
        System.out.println("Merge Sort: " + Utility.isSorted(d));

        d = ReadArrays.readArray(f);
        MergeInsertionSort.sort(d, 0, d.length-1, 100);
        System.out.println("Merge-Insertion Sort: " + Utility.isSorted(d));

        d = ReadArrays.readArray(f);
        BottomUpMergeSort.sort(d, 0, d.length-1);
        System.out.println("Bottom-Up Merge Sort: " + Utility.isSorted(d));

        d = ReadArrays.readArray(f);
        QuickSort.sort(d, 0, d.length-1);
        System.out.println("Quick Sort: " + Utility.isSorted(d));

        d = ReadArrays.readArray(f);
        CutOffQuickSort.sort(d, 0, d.length-1, 100);
        System.out.println("Quick-Insertion Sort: " + Utility.isSorted(d));

        d = ReadArrays.readArray(f);
        ThreeWayQuickSort.sort(d, 0, d.length-1);
        System.out.println("3 Way Sort: " + Utility.isSorted(d));

        d = ReadArrays.readArray(f);
        MedianOfThreeQuickSort.sort(d, 0, d.length-1);
        System.out.println("Median of 3 Sort: " + Utility.isSorted(d));

        System.out.println("\n\n\n");
    }

    private static void calculateAverageTimes() throws FileNotFoundException {
        String f = "src/main/java/files/int50.txt";
        int n = 10;
        AverageTime.insertionAverage(f, n);
        AverageTime.selectionAverage(f, n);
        AverageTime.shellAverage(f, n);
        AverageTime.mergeAverage(f, n);
        AverageTime.bottomUpMergeAverage(f, n);
        AverageTime.mergeInsertionAverage(f, n);
        AverageTime.quickAverage(f, n);
        AverageTime.medianOf3Average(f, n);
        AverageTime.sort3WayAverage(f, n);
        AverageTime.cutOffAverage(f, n);
    }

    private static void findKLargest() throws FileNotFoundException {
        String f = "src/main/java/files/views.txt";
        int k = 50;
        int[] data = ReadArrays.readArray(f);
        System.out.println(MinHeap.findKLargest(data, k));
    }
}
