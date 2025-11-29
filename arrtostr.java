public class arrtostr {
    
    public static void main(String[] args) {
        
// a = [1,1,1,23,3,2,1]

// a = {1,2,3,4,1,2} -> {3,2,4,1} -> Set - unorder



        String str = "Surya Vijay ajith";

        String[] arr = str.split(" ");

        System.out.println(arr); // ["Surya","Vijay","ajith"]

        for (String data : arr) {
            System.out.println(data);
        }

    }
}
