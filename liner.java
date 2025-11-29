import java.util.Arrays;

public class liner {
    public static int linearSearch(int[] arr, int target) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                return i; // Element found at index i
            }
        }
        return -1; // Element not found
    }
    
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int target = 22;
        
        // System.out.println("Array: " + Arrays.toString(arr));
        // System.out.println("Searching for: " + target);
        // System.out.println("\nDry Run:");
        
        for(int i = 0; i < arr.length; i++) {
            // System.out.println("Step " + (i+1) + ": Checking index " + i + 
            //                  " -> " + arr[i] + " == " + target + "? " + 
            //                  (arr[i] == target));
            if(arr[i] == target) {
                System.out.println("\nElement found at index: " + i);
                return;
            }
        }
    }
}
