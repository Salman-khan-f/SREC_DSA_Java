import java.util.Arrays;

public class bubble {

    public static void printarr(int[] arr){
            System.out.print(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        
        int[] arr = {8,3,9,2,7,5}; //6
        int temp;
        for(int r =0; r<arr.length; r++){
            for(int c =0; c<arr.length -r-1 ; c++){
                if(arr[c] > arr[c+1]){
                    temp = arr[c];
                    arr[c] = arr[c+1];
                    arr[c+1] = temp;
                }
            }
        }
        printarr(arr);

    }
}
