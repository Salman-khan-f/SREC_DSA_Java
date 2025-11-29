import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        
        for(int i = 0; i < n - 1; i++) {
            int minIndex = i;
            
            // Find minimum element in unsorted portion
            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Swap minimum with first unsorted element
            if(minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
    
    public static void selection(int[] arr) {
        int n = arr.length;
        System.out.println("Initial: " + Arrays.toString(arr));
        
        for(int i = 0; i < n - 1; i++) {
            // System.out.println("\n--- Pass " + (i + 1) + " ---");
            int minIndex = i;   // 0
            // System.out.println("Current minimum: " + arr[minIndex] + 
            //                  " at index " + minIndex);
            
            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                    // System.out.println("New minimum found: " + arr[minIndex] + 
                    //                  " at index " + minIndex);
                }
            }
            
            if(minIndex != i) {
                // System.out.println("Swapping " + arr[i] + " and " + arr[minIndex]);
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
            
            System.out.println("Array: " + Arrays.toString(arr));
            System.out.print("Sorted portion: [");
            for(int k = 0; k <= i; k++) {
                System.out.print(arr[k]);
                if(k < i) System.out.print(", ");
            }
            System.out.println("]");
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        selection(arr);
    }
}
