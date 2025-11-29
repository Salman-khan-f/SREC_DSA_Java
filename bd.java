import java.util.HashMap;
import java.util.Map;

public class bd {
    static class Product{
        String Brand;
        String Pdtname;
        double Price;

        Product(String Brand, String Pdtname, double Price){
            this.Brand = Brand;
            this.Pdtname = Pdtname;
            this.Price = Price;
        }
    }

    public static void main(String[] args) {

        
        
        Map<Integer,Product>  snaks = new HashMap<>();

        snaks.put(1, new Product("Kissan","jam",99.00));
        snaks.put(2, new Product("Kissan","jam",99.00));
        snaks.put(3, new Product("Kissan","jam",99.00));
        snaks.put(4, new Product("Kissan","jam",99.00));


        Map<Integer, Product> chocolate = new HashMap<>();

        chocolate.put(1, new Product("Cadbe","dairy milk",80.00));
        chocolate.put(2, new Product("Cadbe","dairy milk",20.00));
        chocolate.put(3, new Product("Cadbe","dairy milk",10.00));
        chocolate.put(4, new Product("Cadbe","dairy milk",5.00));
        
        
        
        Map<Integer, Map<Integer,Product>> catalog = new HashMap<>();
        
        catalog.put(1, snaks);
        catalog.put(2, chocolate);
        
        
        // System.out.println(snaks);
        // System.out.println(snaks.get(1));
        
        // Product cat = snaks.get(1);

        // System.out.println(cat.Brand+"  "+cat.Pdtname+"  "+ cat.Price);

    }
}

