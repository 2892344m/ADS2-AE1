package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

//Sourced from https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
//Second method, using priority queue
public class MinHeap {
    
    public static ArrayList<Integer> findKLargest(int[] a, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int i = 0; i < k; i++) {
            minHeap.add(a[i]);
        }

        for (int i = k; i < a.length; i++) {
            if (a[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(a[i]);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while(!minHeap.isEmpty()) {
            res.add(minHeap.poll());
        }

        Collections.reverse(res);
        return res;
    }
} 
