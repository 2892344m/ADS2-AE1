package sorting;

public class InsertionSort {

    public static void sort(int a[], int l , int r) {
        for(int i = l + 1; i < r; i++) {
            for (int j = i; j > l && a[j] < a[j-1]; j--){
                Utility.swap(a, j, j-1);
            }
        }
    }
}
