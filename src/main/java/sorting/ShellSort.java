package sorting;

public class ShellSort {
    public static int[] sort(int a[]) {
        int h = 1;
        int n = a.length;

        while (h < n/3) {
            h = 3*h + 1;
        }

        while (h >= 1) {
            for (int i = h; i<n; i++) {
                for (int j = i; j>=h && a[j] < a[j-h]; j=j-h) {
                    Utility.swap(a, j, j-h);
                }
            }
            h = h/3;
        }
        return a;
    }
}
