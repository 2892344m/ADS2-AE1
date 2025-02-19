package sorting;
import static sorting.QuickSort.partition;

public class CutOffQuickSort {
    private static void kSort(int[] a, int p, int r, int k) {
        if (r - p <= k) return;
        int q = partition(a, p, r);
        kSort(a, p, q-1, k);
        kSort(a, q+1, r, k);
    }

    public static void sort(int[] a, int p, int r, int k) {
        kSort(a, p, r, k);
        InsertionSort.sort(a, p, r+1);
    }
}
