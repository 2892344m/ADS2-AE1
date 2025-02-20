import java.util.Random;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PopulationScript {

    private static final int SIZE = 1_000_000;

    private static int[] generateArray() {
        int[] a = new int[SIZE];
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
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
