package sorting;

import java.util.Random;

public class QuickSort {

    static int ik, jk;

    private static int partition(int[] a, int p , int r) {
        int x = a[r];
        int i = p-1;
        for (int j = p; j < r; j++) {
            if (a[j] <= x) {
                i++;
                Utility.swap(a, i, j);
            }
        }
        Utility.swap(a, i+1, r);
        return i + 1;
    }

    public static void sort(int[] a, int p, int r) {
        if (r <= p) return;
        int q = partition(a, p, r);
        sort(a, p, q-1);
        sort(a, q+1, r);
    }

    public static void rSort(int[] a, int p , int r) {
        if (r <= p) return;
        Random random = new Random();
        Utility.swap(a, random.nextInt(r-p) + p, r);
        int q = partition(a, p, r);
        rSort(a, p, q-1);
        rSort(a, q+1, r);
    }

    private static void kSort(int[] a, int p, int r, int k) {
        if (r - p <= k) return;
        int q = partition(a, p, r);
        kSort(a, p, q-1, k);
        kSort(a, q+1, r, k);
    }

    public static void sortCutOff(int[] a, int p, int r, int k) {
        kSort(a, p, r, k);
        InsertionSort.sort(a);
    }

    public static void sort3Way(int[] a, int p, int r) {
        if (p < r) {
            ik = 0; jk = 0;
            threeWayPartition(a, p, r);
            sort(a, p, ik);
            sort(a, jk, r);
        }
    }

    public static void sortMedian3(int[] a, int p, int r) {
        if (r<=p) return;
        Utility.swap(a, (p+r)/2, r-1);
        if (a[r-1]< a[p]) Utility.swap(a, p, r-1);
        if (a[r] < a[p]) Utility.swap(a, p, r);
        if (a[r] < a[r-1]) Utility.swap(a, r-1, r);
        int q = partition(a, p+1, r-1);
        sortMedian3(a, p, q);
        sortMedian3(a, q, r);
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