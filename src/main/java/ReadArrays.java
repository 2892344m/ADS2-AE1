import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadArrays {
    public static int[] readArray(String filename) throws FileNotFoundException {
        ArrayList<Integer> data;
        try (Scanner sc = new Scanner(new File(filename))) {
            data = new ArrayList<>();
            while (sc.hasNextInt()) {
                data.add(sc.nextInt());
            }
        }
        return copyArray(data);
    }

    private static int[] copyArray(ArrayList<Integer> data) {
        int n = data.size();
        int[] res = new int[n];

        for (int i = 0; i<n; i++) {
            res [i] = data.get(i);
        }

        return res;
    }
}
