import java.io.FileNotFoundException;
import sorting.InsertionSort;
import sorting.MergeSort;
import sorting.QuickSort;
import sorting.SelectionSort;
import sorting.ShellSort;
import sorting.Utility;

public class AverageTime {

    public static void insertionAverage(String filename, int n) throws FileNotFoundException {
        long[] times = new long[n];
        for (int i = 0; i < n; i++) {
            int[] data = ReadArrays.readArray(filename);
            long start = System.nanoTime();
            long cutoff = start + 60 * 1000;
            while (System.nanoTime() < cutoff) {
                InsertionSort.sort(data);
                break;
            }
            long duration = System.nanoTime() - start;
            times[i] = duration;
        }
        long average = Utility.arrayAverage(times);
        System.out.println("Insertion Sort Average: " + average/1_000_000.0 + " milliseconds");
    }

    public static void selectionAverage(String filename, int n) throws FileNotFoundException {
        long[] times = new long[n];
        for (int i = 0; i < n; i++) {
            int[] data = ReadArrays.readArray(filename);
            long start = System.nanoTime();
            long cutoff = start + 60 * 1000;
            while (System.nanoTime() < cutoff) {
                SelectionSort.sort(data);break;
            }
            long duration = System.nanoTime() - start;
            times[i] = duration;
        }
        long average = Utility.arrayAverage(times);
        System.out.println("Selection Sort Average: " + average/1_000_000.0 + " milliseconds");
    }

    public static void shellAverage(String filename, int n) throws FileNotFoundException {
        long[] times = new long[n];
        for (int i = 0; i < n; i++) {
            int[] data = ReadArrays.readArray(filename);
            long start = System.nanoTime();
            long cutoff = start + 60 * 1000;
            while (System.nanoTime() < cutoff) {
                ShellSort.sort(data);break;
            }
            long duration = System.nanoTime() - start;
            times[i] = duration;
        }
        long average = Utility.arrayAverage(times);
        System.out.println("Shell Sort Average: " + average/1_000_000.0 + " milliseconds");
    }

    public static void mergeAverage(String filename, int n) throws FileNotFoundException {
        long[] times = new long[n];
        for (int i = 0; i < n; i++) {
            int[] data = ReadArrays.readArray(filename);
            long start = System.nanoTime();
            long cutoff = start + 60 * 1000;
            while (System.nanoTime() < cutoff) {
                MergeSort.sort(data, 0, data.length-1);break;
            }
            long duration = System.nanoTime() - start;
            times[i] = duration;
        }
        long average = Utility.arrayAverage(times);
        System.out.println("Merge Sort Average: " + average/1_000_000.0 + " milliseconds");
    }

    public static void mergeInsertionAverage(String filename, int n) throws FileNotFoundException {
        long[] times = new long[n];
        for (int i = 0; i < n; i++) {
            int[] data = ReadArrays.readArray(filename);
            long start = System.nanoTime();
            long cutoff = start + 60 * 1000;
            while (System.nanoTime() < cutoff) {
                MergeSort.insertionSort(data, 0, data.length-1, 100);break;
            }
            long duration = System.nanoTime() - start;
            times[i] = duration;
        }
        long average = Utility.arrayAverage(times);
        System.out.println("Merge-Insertion Sort Average: " + average/1_000_000.0 + " milliseconds");
    }

    public static void bottomUpMergeAverage(String filename, int n) throws FileNotFoundException {
        long[] times = new long[n];
        for (int i = 0; i < n; i++) {
            int[] data = ReadArrays.readArray(filename);
            long start = System.nanoTime();
            long cutoff = start + 60 * 1000;
            while (System.nanoTime() < cutoff) {
                MergeSort.bottomUpMergeSort(data, 0, data.length-1);break;
            }
            long duration = System.nanoTime() - start;
            times[i] = duration;
        }
        long average = Utility.arrayAverage(times);
        System.out.println("Bottom-Up Merge Sort Average: " + average/1_000_000.0 + " milliseconds");
    }

    public static void quickAverage(String filename, int n) throws FileNotFoundException {
        long[] times = new long[n];
        for (int i = 0; i < n; i++) {
            int[] data = ReadArrays.readArray(filename);
            long start = System.nanoTime();
            long cutoff = start + 60 * 1000;
            while (System.nanoTime() < cutoff) {
                QuickSort.sort(data, 0, data.length-1);break;
            }
            long duration = System.nanoTime() - start;
            times[i] = duration;
        }
        long average = Utility.arrayAverage(times);
        System.out.println("Quick Sort Average: " + average/1_000_000.0 + " milliseconds");
    }

    public static void sort3WayAverage(String filename, int n) throws FileNotFoundException {
        long[] times = new long[n];
        for (int i = 0; i < n; i++) {
            int[] data = ReadArrays.readArray(filename);
            long start = System.nanoTime();
            long cutoff = start + 60 * 1000;
            while (System.nanoTime() < cutoff) {
                QuickSort.sort3Way(data, 0, data.length-1);break;
            }
            long duration = System.nanoTime() - start;
            times[i] = duration;
        }
        long average = Utility.arrayAverage(times);
        System.out.println("Three Way Sort Average: " + average/1_000_000.0 + " milliseconds");
    }

    public static void cutOffAverage(String filename, int n) throws FileNotFoundException {
        long[] times = new long[n];
        for (int i = 0; i < n; i++) {
            int[] data = ReadArrays.readArray(filename);
            long start = System.nanoTime();
            long cutoff = start + 60 * 1000;
            while (System.nanoTime() < cutoff) {
                QuickSort.sortCutOff(data, 0, data.length-1, 100);break;
            }
            long duration = System.nanoTime() - start;
            times[i] = duration;
        }
        long average = Utility.arrayAverage(times);
        System.out.println("Quick-Insertion Sort Average: " + average/1_000_000.0 + " milliseconds");
    }

    public static void  medianOf3Average(String filename, int n) throws FileNotFoundException {
        long[] times = new long[n];
        for (int i = 0; i < n; i++) {
            int[] data = ReadArrays.readArray(filename);
            long start = System.nanoTime();
            long cutoff = start + 60 * 1000;
            while (System.nanoTime() < cutoff) {
                QuickSort.sortMedian3(data, 0, data.length-1);break;
            }
            long duration = System.nanoTime() - start;
            times[i] = duration;
        }
        long average = Utility.arrayAverage(times);
        System.out.println("Median of 3 Sort Average: " + average/1_000_000.0 + " milliseconds");
    }

}
