package sorting;

public class InsertionSort {

    public static void sort(int a[], int l , int r) {
        for (int j = l; j < r; j++) {
            int key = a[j];
            int i = j-1;
            while ((i >= 0) && (a[i] > key)) {
                a[i+1] = a[i];
                i--;
            }
            a[i+1] = key;
        }
    }
}
