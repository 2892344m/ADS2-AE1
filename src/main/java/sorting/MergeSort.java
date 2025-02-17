package sorting;

public class MergeSort {

    private static void merge(int[] a, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int L[] = new int[n1+1];
        int R[] = new int[n2+1];

        for(int i = 0; i < n1;i++) {
            L[i] = a[p+i];
        }

        for(int j = 0; j < n2; j++) {
            R[j] = a[q + 1 + j];
        }

        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            }
            else {
                a[k] = R[j];
                j++;
            }
        }
    }

    public static void sort(int[] a, int p, int r) {
        if (p < r) {
            int q = (p+r)/2;
            sort(a, p, q);
            sort(a, q+1, r);
            merge(a, p, q, r);
        }
    }

    public static void insertionSort(int[] a, int p, int r, int n) {
        if (r <= p + n - 1) {
            InsertionSort.sort(a, p, r);
            return;
        }
        int q = p + (r-p) / 2;
        insertionSort(a, p, q, n);
        insertionSort(a, q+1, r, n);
        merge(a, p, q, r);
    }

    public static void bottomUpMergeSort(int a[], int p, int r) {
        int n = a.length;
        for (int sz = 1; sz < n; sz += sz) {
            for (p = 0; p < n-sz; p += sz+sz) {
                merge(a, p, p+sz-1, Math.min(p+sz+sz-1, n-1));
            }
        }
    } 
}
