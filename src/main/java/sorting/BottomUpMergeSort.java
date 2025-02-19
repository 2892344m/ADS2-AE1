package sorting;
import static sorting.MergeSort.merge;

public class BottomUpMergeSort  {
    public static void sort(int a[], int p, int r) {
        int n = a.length;
        for (int sz = 1; sz < n; sz += sz) {
            for (p = 0; p < n-sz; p += sz+sz) {
                merge(a, p, p+sz-1, Math.min(p+sz+sz-1, n-1));
            }
        }
    } 
}
