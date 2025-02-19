package sorting;
import static sorting.QuickSort.partition;

public class MedianOfThreeQuickSort {
    public static void sort(int[] a, int p, int r) {
        if (r<=p) return;
        Utility.swap(a, (p+r)/2, r-1);
        
        if (a[r-1]< a[p]) Utility.swap(a, p, r-1);
        if (a[r] < a[p]) Utility.swap(a, p, r);
        if (a[r] < a[r-1]) Utility.swap(a, r-1, r);

        int q = partition(a, p, r);
        sort(a, p, q-1);
        sort(a, q+1, r);
    }
}
