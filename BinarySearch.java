import java.util.Arrays;

public class BinarySearch {
    // Iterative approach
    public static int binarySearchIterative(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            if(arr[mid] == target) {
                return mid; // Found
            } else if(arr[mid] < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }
        return -1; // Not found
    }
    
    // Recursive approach
    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if(left > right) {
            return -1; // Not found
        }
        
        int mid = left + (right - left) / 2;
        
        if(arr[mid] == target) {
            return mid;
        } else if(arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, right);
        } else {
            return binarySearchRecursive(arr, target, left, mid - 1);
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {11, 12, 22, 25, 34, 64, 90};
        int target = 64;
        
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println("Searching for: " + target);
        System.out.println("\nDry Run (Iterative):");
        
        int left = 0, right = arr.length - 1; // index position - 0 - 6
        int iteration = 1;
        
        while(left <= right) {
            int mid = left + (right - left) / 2;  // 0 + (6 - 0)/2 -> 3 // 4 +(6-4)/2 -> 5
            System.out.println("Iteration " + iteration++);
            System.out.println("  Left: " + left + ", Right: " + right + ", Mid: " + mid);
            System.out.println("  arr[mid] = " + arr[mid]);
            
            if(arr[mid] == target) {
                System.out.println("  Found at index: " + mid);
                break;
            } else if(arr[mid] < target) {
                System.out.println("  " + arr[mid] + " < " + target + " -> Search right half");
                left = mid + 1;
            } else {
                System.out.println("  " + arr[mid] + " > " + target + " -> Search left half");
                right = mid - 1;
            }
        }
        
        // Test recursive version
        int result = binarySearchRecursive(arr, target, 0, arr.length - 1);
        System.out.println("\nRecursive result: " + result);
    }
}
