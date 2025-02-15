import java.io.FileNotFoundException;
import java.util.ArrayList;

import sorting.Utility;

public class FindMostViewed {
    
    private ArrayList<Integer> heap;
    private int size;
    private int maxSize;

    public FindMostViewed(int maxSize) throws FileNotFoundException {
        this.heap = new ArrayList<Integer>(maxSize);
        this.maxSize = maxSize;
        this.size = 0;
    }

    private int parent(int p) {return (p-1)/2;}

    private int leftChild(int p) {return (2*p+1);}

    private int rightChild(int p) {return (2*p+2);}

    private boolean isLeaf(int p) {
        if (p > (size/2) && p <= size) {
            return true;
        }
        return false;
    }

    private void swap(int f, int s) {
        int fi = heap.get(f);
        int si = heap.get(s);
        heap.set(s, fi);
        heap.set(f, si);
    }

    private void maxHeap(int p) {
        if (isLeaf(p)) return;

        if (heap.get(p) < heap.get(leftChild(p)) || heap.get(p) < heap.get(rightChild(p))) {
            if (heap.get(leftChild(p)) > heap.get(rightChild(p))) {
                swap(p, leftChild(p));
                maxHeap(leftChild(p));
            }
            else {
                swap(p, rightChild(p));
                maxHeap(rightChild(p));
            }
        }
    }

    public void insert(int e) {
        heap.set(size, e);

        int current = size;
        while (heap.get(current) > heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }
    
    public int extractMax() {
        int popped = heap.get(0);
        heap.set(0, --size);
        maxHeap(0);
        return popped;
    }

    public static void main(String[] args) throws FileNotFoundException {
        int[] data = ReadArrays.readArray("src/main/java/files/int10.txt");
        int maxSize = data.length;
        FindMostViewed f = new FindMostViewed(maxSize);

        int n = 10;

        for (int i : data) {
            f.insert(i);
        }

        

    }
}
