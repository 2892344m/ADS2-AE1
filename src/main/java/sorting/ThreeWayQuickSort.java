package sorting;

public class ThreeWayQuickSort {
    static int ik, jk;
    public static void sort(int[] a, int p, int r) {
        if (p < r) {
            ik = 0; jk = 0;
            threeWayPartition(a, p, r);
            sort(a, p, ik);
            sort(a, jk, r);
        }
    } 

    private static void threeWayPartition(int[] a, int l, int r) {
        if (r-l <= 1) {
            if (a[r] < a[l]) {
                Utility.swap(a, l, r);
            }
            ik = l;
            jk = r;
            return;
        }
        int mid = l;
        int pivot = a[r];
        while (mid <= r) {
            if (a[mid] < pivot) {
                Utility.swap(a, l++, mid++);
            }
            else if (a[mid] == pivot) {
                mid++;
            }
            else if (a[mid] > pivot) {
                Utility.swap(a, mid, r--);
            }
            ik = l-1;
            jk = mid;
        }
    }
}
