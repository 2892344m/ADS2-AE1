package sorting;

public class SelectionSort{
    public static int[] sort(int a[]) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int index = i;

            //Find minimum
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[index]) {
                    index = j;
                }
            }
            Utility.swap(a, index, i);
        }
        return a;
    }
}
