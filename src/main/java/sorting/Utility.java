package sorting;

public class Utility {
  
    public static boolean isSorted(int[] a) {
        int n = a.length;
        for (int i = 0; i < n-1; i++) {
            if (a[i] > a[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static void swap(int[] a, int i, int j) {
        int value = a[i];
        a[i] = a[j];
        a[j] = value;
    }

    public static double arrayAverage(long[] a, int n) {
        long total = 0;
        for (long x : a) {
            total += x;
        }
        return total/n;
    }

}
