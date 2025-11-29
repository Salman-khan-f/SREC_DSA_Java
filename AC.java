import java.util.*;

public class AC {
    public static void compareAlgorithms() {
        int[] sizes = {100, 1000, 5000, 10000};
        
        for(int size : sizes) {
            System.out.println("\n=== Array Size: " + size + " ===");
            
            // Generate random array
            int[] original = new int[size];
            Random rand = new Random();
            for(int i = 0; i < size; i++) {
                original[i] = rand.nextInt(10000);
            }
            
            // Test Bubble Sort
            int[] arr1 = Arrays.copyOf(original, size);
            long start = System.nanoTime();
            bubbleSort(arr1);
            long end = System.nanoTime();
            System.out.printf("Bubble Sort: %.3f ms\n", (end - start) / 1_000_000.0);
            
            // Test Selection Sort
            int[] arr2 = Arrays.copyOf(original, size);
            start = System.nanoTime();
            selectionSort(arr2);
            end = System.nanoTime();
            System.out.printf("Selection Sort: %.3f ms\n", (end - start) / 1_000_000.0);
            
            // Test Insertion Sort
            int[] arr3 = Arrays.copyOf(original, size);
            start = System.nanoTime();
            insertionSort(arr3);
            end = System.nanoTime();
            System.out.printf("Insertion Sort: %.3f ms\n", (end - start) / 1_000_000.0);
            
            // Test Merge Sort
            int[] arr4 = Arrays.copyOf(original, size);
            start = System.nanoTime();
            mergeSort(arr4, 0, size - 1);
            end = System.nanoTime();
            System.out.printf("Merge Sort: %.3f ms\n", (end - start) / 1_000_000.0);
            
            // Test Quick Sort
            int[] arr5 = Arrays.copyOf(original, size);
            start = System.nanoTime();
            quickSort(arr5, 0, size - 1);
            end = System.nanoTime();
            System.out.printf("Quick Sort: %.3f ms\n", (end - start) / 1_000_000.0);
            
            // Test Java's built-in sort (Dual-Pivot Quicksort)
            int[] arr6 = Arrays.copyOf(original, size);
            start = System.nanoTime();
            Arrays.sort(arr6);
            end = System.nanoTime();
            System.out.printf("Arrays.sort(): %.3f ms\n", (end - start) / 1_000_000.0);
        }
    }
    
    // Helper methods (implementations from previous sections)
    // ... bubbleSort, selectionSort, insertionSort, mergeSort, quickSort
}
