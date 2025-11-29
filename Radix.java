import java.util.Arrays;

public class Radix {
    public static void radixSort(int[] arr) {
        // Find maximum number to determine number of digits
        int max = getMax(arr);
        
        // Do counting sort for every digit
        for(int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }
    
    private static int getMax(int[] arr) {
        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length; // 8
        int[] output = new int[n];
        int[] count = new int[10]; // 0-9 digits
        
        // Store count of occurrences
        for(int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10; // (170 / 1) % 10 
            count[digit]++;
        }
        
        // Change count[i] to actual position
        for(int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        
        // Build output array
        for(int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }
        
        // Copy output to arr
        for(int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
    
    public static void radixSortWithVisualization(int[] arr) {
        System.out.println("Original: " + Arrays.toString(arr));
        int max = getMax(arr);
        
        int digitPlace = 1;

        for(int exp = 1; max / exp > 0; exp *= 10) { // 802 / 1, 10, 100
            System.out.println("\nSorting by digit at position " + digitPlace++);
            System.out.println("Exp = " + exp);
            
            countingSortByDigit(arr, exp);
            System.out.println("After sorting: " + Arrays.toString(arr));
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSortWithVisualization(arr);
    }
}
