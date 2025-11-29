import java.util.Arrays;

public class array {


    public static void main(String[] args) {
        int[] numbers = {5, 2, 8, 1, 9, 3};
        
        

        // Sorting
        Arrays.sort(numbers);
        System.out.println("Sorted: " + Arrays.toString(numbers));
        // Output: [1, 2, 3, 5, 8, 9]
        
        // Binary Search (array must be sorted)
        int index = Arrays.binarySearch(numbers, 5);
        System.out.println("Index of 5: " + index);
        
        // Fill array
        int[] filled = new int[5];
        Arrays.fill(filled, 100);
        System.out.println("Filled: " + Arrays.toString(filled));
        
        // Copy array
        int[] copy = Arrays.copyOf(numbers, numbers.length);
        System.out.println("Copy: " + Arrays.toString(copy));
        
        // Copy range
        int[] partial = Arrays.copyOfRange(numbers, 1, 4);
        System.out.println("Partial: " + Arrays.toString(partial));
        
        // Compare arrays
        boolean areEqual = Arrays.equals(numbers, copy);
        System.out.println("Arrays equal: " + areEqual);


    }
}
