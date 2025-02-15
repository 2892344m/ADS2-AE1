import java.io.FileNotFoundException;
import java.util.ArrayList;

import sorting.Utility;

public class FindMostViewedOld {
    
    private int[] heap;
    private int size;
    private int maxSize;

    public FindMostViewedOld(int maxSize) throws FileNotFoundException {
        this.heap = new int[maxSize];
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

    private void maxHeap(int p) {
        if (isLeaf(p)) return;

        if (heap[p] < heap[leftChild(p)] || heap[p] < heap[rightChild(p)]) {
            if (heap[leftChild(p)] > heap[rightChild(p)]) {
                Utility.swap(heap, p, leftChild(p));
                maxHeap(leftChild(p));
            }
            else {
                Utility.swap(heap, p, rightChild(p));
                maxHeap(rightChild(p));
            }
        }
    }

    public void insert(int e) {
        heap[size] = e;

        int current = size;
        while (heap[current] > heap[parent(current)]) {
            Utility.swap(heap, current, parent(current));
            current = parent(current);
        }
        size++;
    }
    
    public int extractMax() {
        int popped = heap[0];
        heap[0] = heap[--size];
        maxHeap(0);
        return popped;
    }

    public static void main(String[] args) throws FileNotFoundException {
        int[] data = ReadArrays.readArray("src/main/java/files/int10.txt");
        int maxSize = data.length;
        FindMostViewedOld f = new FindMostViewedOld(maxSize);

        int n = 10;

        for (int i : data) {
            f.insert(i);
        }

        for (int k = 0; k < 10; k++) {
            System.out.println(f.extractMax());
        }

    }
}
