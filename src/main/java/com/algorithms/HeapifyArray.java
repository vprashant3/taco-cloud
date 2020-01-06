package com.algorithms;

import java.util.Arrays;

public class HeapifyArray {

    public static void main(String[] args) {
        int[] arr = {1,3,13,5,4,6,10};

        for(int i= arr.length-1; i>=0; i--) {
            heapify(arr,arr.length,i);
        }

        Arrays.stream(arr).forEach(System.out::println);

    }

    private static void heapify(int[] arr, int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
}
