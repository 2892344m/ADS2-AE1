import java.io.FileNotFoundException;
import sorting.InsertionSort;
import sorting.MergeSort;
import sorting.QuickSort;
import sorting.SelectionSort;
import sorting.ShellSort;
import sorting.Utility;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        String f = "src/main/java/files/int500k.txt";
        int n = 10;

        testSortsWork();

        AverageTime.insertionAverage(f, n);
        AverageTime.insertionMillisAverage(f, n);
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

    public static void testSortsWork() throws FileNotFoundException {   
        String f = "src/main/java/files/int10.txt";

        int[] d = ReadArrays.readArray(f);
        InsertionSort.sort(d);
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
        MergeSort.insertionSort(d, 0, d.length-1, 100);
        System.out.println("Merge-Insertion Sort: " + Utility.isSorted(d));

        d = ReadArrays.readArray(f);
        MergeSort.bottomUpMergeSort(d, 0, d.length-1);
        System.out.println("Bottom-Up Merge Sort: " + Utility.isSorted(d));

        d = ReadArrays.readArray(f);
        QuickSort.sort(d, 0, d.length-1);
        System.out.println("Quick Sort: " + Utility.isSorted(d));

        d = ReadArrays.readArray(f);
        QuickSort.sortCutOff(d, 0, d.length-1, 100);
        System.out.println("Quick-Insertion Sort: " + Utility.isSorted(d));

        d = ReadArrays.readArray(f);
        QuickSort.sort3Way(d, 0, d.length-1);
        System.out.println("3 Way Sort: " + Utility.isSorted(d));

        d = ReadArrays.readArray(f);
        QuickSort.sortMedian3(d, 0, d.length-1);
        System.out.println("Median of 3 Sort: " + Utility.isSorted(d));

        System.out.println("\n\n\n");
    }

}
