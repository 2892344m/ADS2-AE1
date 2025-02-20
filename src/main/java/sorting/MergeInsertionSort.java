package sorting;
import static sorting.MergeSort.merge;

public class MergeInsertionSort {
   
    public static void sort(int[] a, int p, int r, int n) {
        if (r <= p + n - 1) {
            InsertionSort.sort(a, p, r+1);
            return;
        }
        int q = p + (r-p) / 2;
        sort(a, p, q, n);
        sort(a, q+1, r, n);
        merge(a, p, q, r);
    }

}
