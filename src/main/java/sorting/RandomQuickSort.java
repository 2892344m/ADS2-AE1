package sorting;

import java.util.Random;
import static sorting.QuickSort.partition;

public class RandomQuickSort {
        public static void sort(int[] a, int p , int r) {
        if (r <= p) return;
        Random random = new Random();
        Utility.swap(a, random.nextInt(r-p) + p, r);
        int q = partition(a, p, r);
        sort(a, p, q-1);
        sort(a, q+1, r);
    }
}
