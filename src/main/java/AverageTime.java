import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import sorting.BottomUpMergeSort;
import sorting.CutOffQuickSort;
import sorting.InsertionSort;
import sorting.MedianOfThreeQuickSort;
import sorting.MergeInsertionSort;
import sorting.MergeSort;
import sorting.QuickSort;
import sorting.SelectionSort;
import sorting.ShellSort;
import sorting.ThreeWayQuickSort;
import sorting.Utility;

public class AverageTime {

    static final int CUTOFF_SECONDS = 30;
    static final double NANOSECOND_DIVISOR = 1_000_000.0;

    public static void insertionAverage(String filename, int n) throws FileNotFoundException {
        
        long[] times = new long[n];
        int[] data = ReadArrays.readArray(filename);
        int dataLength = data.length;

        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
        Future future = executor.submit(() -> {
            for (int i = 0; i < n; i++) {
                int[] workingData = Arrays.copyOf(data, dataLength);
                long start = System.nanoTime();
                InsertionSort.sort(workingData, 0, dataLength);
                
                long duration = System.nanoTime() - start;
                times[i] = duration;
            }
            double average = Utility.arrayAverage(times, n);
            System.out.println("Insertion Sort Average: " + average/NANOSECOND_DIVISOR + " milliseconds\n");
        });

            future.get(CUTOFF_SECONDS, TimeUnit.SECONDS);
        } catch (TimeoutException e) {System.out.println("Timeout Error. Took too long.");}
        catch (Exception e) { e.printStackTrace();}
        finally {executor.shutdown();}
        
    }

    public static void selectionAverage(String filename, int n) throws FileNotFoundException {
        long[] times = new long[n];
        int[] data = ReadArrays.readArray(filename);
        int dataLength = data.length;

        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
        Future future = executor.submit(() -> {
            for (int i = 0; i < n; i++) {
                int[] workingData = Arrays.copyOf(data, dataLength);
                long start = System.nanoTime();
                SelectionSort.sort(workingData);
                
                long duration = System.nanoTime() - start;
                times[i] = duration;
            }
            double average = Utility.arrayAverage(times, n);
            System.out.println("Selection Sort Average: " + average/NANOSECOND_DIVISOR + " milliseconds\n");
        });

            future.get(CUTOFF_SECONDS, TimeUnit.SECONDS);
        } catch (TimeoutException e) {System.out.println("Timeout Error. Took too long.");}
        catch (Exception e) { e.printStackTrace();}
        finally {executor.shutdown();}
    }

    public static void shellAverage(String filename, int n) throws FileNotFoundException {
                
        long[] times = new long[n];
        int[] data = ReadArrays.readArray(filename);
        int dataLength = data.length;

        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
        Future future = executor.submit(() -> {
            for (int i = 0; i < n; i++) {
                int[] workingData = Arrays.copyOf(data, dataLength);
                long start = System.nanoTime();
                ShellSort.sort(workingData);
                
                long duration = System.nanoTime() - start;
                times[i] = duration;
            }
            double average = Utility.arrayAverage(times, n);
            System.out.println("Shell Sort Average: " + average/NANOSECOND_DIVISOR + " milliseconds\n");
        });

            future.get(CUTOFF_SECONDS, TimeUnit.SECONDS);
        } catch (TimeoutException e) {System.out.println("Error. Took too long.");}
        catch (Exception e) { e.printStackTrace();}
        finally {executor.shutdown();}
    }

    public static void mergeAverage(String filename, int n) throws FileNotFoundException {
                
        long[] times = new long[n];
        int[] data = ReadArrays.readArray(filename);
        int dataLength = data.length;

        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
        Future future = executor.submit(() -> {
            for (int i = 0; i < n; i++) {
                int[] workingData = Arrays.copyOf(data, dataLength);
                long start = System.nanoTime();
                MergeSort.sort(workingData, 0, dataLength-1);
                
                long duration = System.nanoTime() - start;
                times[i] = duration;
            }
            double average = Utility.arrayAverage(times, n);
            System.out.println("Merge Sort Average: " + average/NANOSECOND_DIVISOR + " milliseconds\n");
        });

            future.get(CUTOFF_SECONDS, TimeUnit.SECONDS);
        } catch (TimeoutException e) {System.out.println("Error. Took too long.");}
        catch (Exception e) { e.printStackTrace();}
        finally {executor.shutdown();}
    }

    public static void mergeInsertionAverage(String filename, int n) throws FileNotFoundException {
                
        long[] times = new long[n];
        int[] data = ReadArrays.readArray(filename);
        int dataLength = data.length;

        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
        Future future = executor.submit(() -> {
            for (int i = 0; i < n; i++) {
                int[] workingData = Arrays.copyOf(data, dataLength);
                long start = System.nanoTime();
                MergeInsertionSort.sort(workingData, 0, dataLength-1, 100);
                
                long duration = System.nanoTime() - start;
                times[i] = duration;
            }
            double average = Utility.arrayAverage(times, n);
            System.out.println("Merge-Insertion Sort Average: " + average/NANOSECOND_DIVISOR + " milliseconds\n");
        });

            future.get(CUTOFF_SECONDS, TimeUnit.SECONDS);
        } catch (TimeoutException e) {System.out.println("Error. Took too long.");}
        catch (Exception e) { e.printStackTrace();}
        finally {executor.shutdown();}
    }

    public static void bottomUpMergeAverage(String filename, int n) throws FileNotFoundException {
                
        long[] times = new long[n];
        int[] data = ReadArrays.readArray(filename);
        int dataLength = data.length;

        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
        Future future = executor.submit(() -> {
            for (int i = 0; i < n; i++) {
                int[] workingData = Arrays.copyOf(data, dataLength);
                long start = System.nanoTime();
                BottomUpMergeSort.sort(workingData, 0, dataLength-1);
                
                long duration = System.nanoTime() - start;
                times[i] = duration;
            }
            double average = Utility.arrayAverage(times, n);
            System.out.println("Bottom-up Merge Sort Average: " + average/NANOSECOND_DIVISOR + " milliseconds\n");
        });

            future.get(CUTOFF_SECONDS, TimeUnit.SECONDS);
        } catch (TimeoutException e) {System.out.println("Error. Took too long.");}
        catch (Exception e) { e.printStackTrace();}
        finally {executor.shutdown();}
    }

    public static void quickAverage(String filename, int n) throws FileNotFoundException {
                
        long[] times = new long[n];
        int[] data = ReadArrays.readArray(filename);
        int dataLength = data.length;

        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
        Future future = executor.submit(() -> {
            for (int i = 0; i < n; i++) {
                int[] workingData = Arrays.copyOf(data, dataLength);
                long start = System.nanoTime();
                QuickSort.sort(workingData, 0, dataLength-1);
                
                long duration = System.nanoTime() - start;
                times[i] = duration;
            }
            double average = Utility.arrayAverage(times, n);
            System.out.println("Quick Sort Average: " + average/NANOSECOND_DIVISOR + " milliseconds\n");
        });

            future.get(CUTOFF_SECONDS, TimeUnit.SECONDS);
        } catch (TimeoutException e) {System.out.println("Error. Took too long.");}
        catch (Exception e) { e.printStackTrace();}
        finally {executor.shutdown();}
    }

    public static void sort3WayAverage(String filename, int n) throws FileNotFoundException {
                
        long[] times = new long[n];
        int[] data = ReadArrays.readArray(filename);
        int dataLength = data.length;

        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
        Future future = executor.submit(() -> {
            for (int i = 0; i < n; i++) {
                int[] workingData = Arrays.copyOf(data, dataLength);
                long start = System.nanoTime();
                ThreeWayQuickSort.sort(workingData, 0, dataLength-1);
                
                long duration = System.nanoTime() - start;
                times[i] = duration;
            }
            double average = Utility.arrayAverage(times, n);
            System.out.println("Three Way (Dutch) Sort Average: " + average/NANOSECOND_DIVISOR + " milliseconds\n");
        });

            future.get(CUTOFF_SECONDS, TimeUnit.SECONDS);
        } catch (TimeoutException e) {System.out.println("Error. Took too long.");}
        catch (Exception e) { e.printStackTrace();}
        finally {executor.shutdown();}
    }

    public static void cutOffAverage(String filename, int n) throws FileNotFoundException {
                
        long[] times = new long[n];
        int[] data = ReadArrays.readArray(filename);
        int dataLength = data.length;

        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
        Future future = executor.submit(() -> {
            for (int i = 0; i < n; i++) {
                int[] workingData = Arrays.copyOf(data, dataLength);
                long start = System.nanoTime();
                CutOffQuickSort.sort(workingData, 0, dataLength-1, 100);
                
                long duration = System.nanoTime() - start;
                times[i] = duration;
            }
            double average = Utility.arrayAverage(times, n);
            System.out.println("Cut Off (Insertion) Quick Sort Average: " + average/NANOSECOND_DIVISOR + " milliseconds\n");
        });

            future.get(CUTOFF_SECONDS, TimeUnit.SECONDS);
        } catch (TimeoutException e) {System.out.println("Error. Took too long.");}
        catch (Exception e) { e.printStackTrace();}
        finally {executor.shutdown();}
    }

    public static void  medianOf3Average(String filename, int n) throws FileNotFoundException {
                
        long[] times = new long[n];
        int[] data = ReadArrays.readArray(filename);
        int dataLength = data.length;

        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
        Future future = executor.submit(() -> {
            for (int i = 0; i < n; i++) {
                int[] workingData = Arrays.copyOf(data, dataLength);
                long start = System.nanoTime();
                MedianOfThreeQuickSort.sort(workingData, 0, dataLength-1);
                
                long duration = System.nanoTime() - start;
                times[i] = duration;
            }
            double average = Utility.arrayAverage(times, n);
            System.out.println("Median of Three Sort Average: " + average/NANOSECOND_DIVISOR + " milliseconds\n");
        });

            future.get(CUTOFF_SECONDS, TimeUnit.SECONDS);
        } catch (TimeoutException e) {System.out.println("Error. Took too long.");}
        catch (Exception e) { e.printStackTrace();}
        finally {executor.shutdown();}
    }
}
