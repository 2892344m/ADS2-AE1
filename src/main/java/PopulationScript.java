import java.util.Random;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PopulationScript {

    private static final int size = 1_000_000;

    private static int[] generateArray() {
        int[] a = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            a[i] = random.nextInt(Integer.MAX_VALUE-0) + 0;
        }
        return a;
    }

    private static void storeArray(String filename, int[] a) throws IOException {
        FileWriter w = new FileWriter(filename);
        BufferedWriter out = new BufferedWriter(w);
        for (int x : a) {
            out.write(Integer.toString(x));out.newLine();
        }
    }

    public static void main(String[] args) throws IOException {
        storeArray("src/main/java/files/views.txt", generateArray());
    }
}
