public class PyramidPattern {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int rows = 4; // number of rows to print (1..4)

        for (int r = 1; r <= rows; r++) {
            // compute start index for this row
            int start = (r == 1) ? 0 : 2 * r - 3;
            
            if (start > arr.length - 1) {start = arr.length - 1;}

            // print descending indices: start, start-2, ..., 1
            for (int i = start; i >= 1; i -= 2) {
                System.out.print(arr[i]);
            }

            // print arr[0] (the center)
            System.out.print(arr[0]);

            // print ascending indices: 2, 4, ..., up to start+1 (but within array)
            int upper = Math.min(arr.length - 1, start + 1);
            for (int i = 2; i <= upper; i += 2) {
                System.out.print(arr[i]);
            }

            System.out.println();
        }
    }
}
