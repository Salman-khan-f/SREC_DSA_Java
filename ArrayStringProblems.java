public class ArrayStringProblems {
    // Problem 1: Find largest element in array
    public static int findLargest(int[] arr) {
        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    // Problem 2: Reverse an array
    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while(left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    
    // Problem 3: Check if string is palindrome
    public static boolean isPalindrome(String str) {
        str = str.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0, right = str.length() - 1;
        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    // Problem 4: Count vowels in string
    public static int countVowels(String str) {
        int count = 0;
        str = str.toLowerCase();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || 
               ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }
    
    // Problem 5: Remove duplicates from sorted array
    public static int removeDuplicates(int[] arr) {
        if(arr.length == 0) return 0;
        
        int uniqueIndex = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[uniqueIndex]) {
                uniqueIndex++;
                arr[uniqueIndex] = arr[i];
            }
        }
        return uniqueIndex + 1;
    }
    
    // Problem 6: Find all anagrams
    public static boolean areAnagrams(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        
        char[] arr1 = s1.toLowerCase().toCharArray();
        char[] arr2 = s2.toLowerCase().toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        return Arrays.equals(arr1, arr2);
    }
    
    // Problem 7: Rotate array by k positions
    public static void rotateArray(int[] arr, int k) {
        k = k % arr.length;
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
    }
    
    private static void reverse(int[] arr, int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
    public static void main(String[] args) {
        // Test all problems
        int[] arr1 = {3, 5, 1, 9, 2, 8};
        System.out.println("Largest: " + findLargest(arr1));
        
        int[] arr2 = {1, 2, 3, 4, 5};
        reverseArray(arr2);
        System.out.println("Reversed: " + Arrays.toString(arr2));
        
        System.out.println("Is 'racecar' palindrome? " + 
                          isPalindrome("racecar"));
        System.out.println("Is 'A man, a plan, a canal: Panama' palindrome? " + 
                          isPalindrome("A man, a plan, a canal: Panama"));
        
        System.out.println("Vowels in 'Hello World': " + 
                          countVowels("Hello World"));
        
        int[] arr3 = {1, 1, 2, 2, 3, 4, 4, 5};
        int newLength = removeDuplicates(arr3);
        System.out.println("Array after removing duplicates:");
        for(int i = 0; i < newLength; i++) {
            System.out.print(arr3[i] + " ");
        }
        System.out.println();
        
        System.out.println("'listen' and 'silent' are anagrams? " + 
                          areAnagrams("listen", "silent"));
        
        int[] arr4 = {1, 2, 3, 4, 5, 6, 7};
        rotateArray(arr4, 3);
        System.out.println("Rotated by 3: " + Arrays.toString(arr4));
    }
}
