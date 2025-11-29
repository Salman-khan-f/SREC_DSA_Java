import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr) {

        // arr = [3,7,5,8,4,9] -> [3,5,7,8,4,9] -> 
        
        // [3,5,7,8,4,9] -> [3,4,5,7,8,9] 

        int n = arr.length; // 6
        
        for(int i = 1; i < n; i++) {  // i = 4
            int key = arr[i]; // 4

            int j = i - 1; // 3 -> 8
            
            // Move elements greater than key one position ahead
            while(j >= 0 && arr[j] > key) {  // 8>4 || 7 > 4
                arr[j + 1] = arr[j]; // 
                j--;
            }
            arr[j + 1] = key;
        }

        System.out.println(Arrays.toString(arr));
    }
    
    public static void insertionSortWithVisualization(int[] arr) {
        int n = arr.length;
        System.out.println("Initial: " + Arrays.toString(arr));
        
        for(int i = 1; i < n; i++) {
            System.out.println("\n--- Pass " + i + " ---");
            int key = arr[i];
            System.out.println("Key to insert: " + key);
            
            int j = i - 1;
            System.out.println("Sorted portion: " + 
                             Arrays.toString(Arrays.copyOfRange(arr, 0, i)));
            
            while(j >= 0 && arr[j] > key) {
                System.out.println("  Shifting " + arr[j] + 
                                 " from position " + j + " to " + (j+1));
                arr[j + 1] = arr[j];
                j--;
            }
            
            arr[j + 1] = key;
            System.out.println("  Inserting " + key + " at position " + (j+1));
            System.out.println("Array: " + Arrays.toString(arr));
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        insertionSortWithVisualization(arr);

        // insertionSort(arr);
    }
}
