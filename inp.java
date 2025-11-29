import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner; 

public class inp {

    static class Product {
        String name;
        double price;

        Product(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    static class CartItem {
        Product product;
        int qty;

        CartItem(Product p, int q) {
            product = p;
            qty = q;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Product catalog: category -> (id -> Product)
        Map<Integer, Map<Integer, Product>> catalog = new HashMap<>();
        // {int:{int:{String,double}}}  --> {3:{1:"Milk 250ml",12.0}}

        // Category 1: Dairy
        Map<Integer, Product> dairy = new HashMap<>();
        // {int:"String",double;int:String,double}
        // {1:"Milk",12.0; 2:"curd",5.0}
        dairy.put(1, new Product("Milk 250ml", 12.0));
        dairy.put(2, new Product("Milk 500ml", 30.0));
        dairy.put(3, new Product("Milk 1L", 60.0));
        dairy.put(4, new Product("Curd 200g", 25.0));
        dairy.put(5, new Product("Paneer 200g", 90.0));

        dairy.put(55,new Product("Cheese 1kg",700.99));

        catalog.put(1, dairy);

        // Category 2: Snacks
        Map<Integer, Product> snacks = new HashMap<>();
        snacks.put(1, new Product("Lays", 5.0));
        snacks.put(2, new Product("Bingo", 10.0));
        snacks.put(3, new Product("Pota Chips", 20.0));
        snacks.put(4, new Product("Biscuits", 15.0));
        catalog.put(2, snacks);

        // Category 3: Drinks
        Map<Integer, Product> drinks = new HashMap<>();
        drinks.put(1, new Product("Water 500ml", 8.0));
        drinks.put(2, new Product("Soda 330ml", 25.0));
        drinks.put(3, new Product("Juice 1L", 80.0));
        catalog.put(3, drinks);

        ArrayList<CartItem> cart = new ArrayList<>();

        System.out.println("Welcome to GrocerX Billing");

        mainLoop:
        while (true) {
            System.out.println();
            System.out.println("Select a category:");
            System.out.println("1. Dairy\n2. Snacks\n3. Drinks\n4. Checkout / Exit");
            System.out.print("Enter choice: ");

            int catChoice = readInt(scanner);

            if (catChoice == 4) {
                // Checkout
                if (cart.isEmpty()) {
                    System.out.println("Cart is empty. Exiting.");
                    break;
                }
                printReceipt(cart, scanner);
                break;
            }

            Map<Integer, Product> cat = catalog.get(catChoice);
            if (cat == null) {
                System.out.println("Invalid category. Try again.");
                continue;
            }

            // show products in selected category
            System.out.println("Products:");
            for (Map.Entry<Integer, Product> e : cat.entrySet()) {
                System.out.printf("%d. %s - Rs %.2f\n", e.getKey(), e.getValue().name, e.getValue().price);
            }
            System.out.println("0. Back to categories");
            System.out.print("Choose product id: ");

            int prodId = readInt(scanner);
            if (prodId == 0) continue;
            Product chosen = cat.get(prodId);
            if (chosen == null) {
                System.out.println("Invalid product id.");
                continue;
            }

            System.out.print("Enter quantity: ");
            int qty = readInt(scanner);
            if (qty <= 0) {
                System.out.println("Quantity must be at least 1.");
                continue;
            }

            // Add to cart (merge if exists)
            boolean merged = false;
            for (CartItem ci : cart) {
                if (ci.product.name.equals(chosen.name)) {
                    ci.qty += qty;
                    merged = true;
                    break;
                }
            }
            if (!merged) cart.add(new CartItem(chosen, qty));

            System.out.println(qty + " x " + chosen.name + " added to cart.");
            System.out.println("Press Enter to continue shopping or type 'checkout' to finish.");
            String next = scanner.nextLine().trim();
            if (next.equalsIgnoreCase("checkout")) {
                printReceipt(cart, scanner);
                break mainLoop;
            }
        }

        scanner.close();
        System.out.println("Goodbye!");
    }

    private static int readInt(Scanner scanner) {
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("Invalid number, try again: ");
            }
        }
    }

    private static void printReceipt(ArrayList<CartItem> cart, Scanner scanner) {
        double subtotal = 0.0;
        System.out.println();
        System.out.println("===== Receipt =====");
        System.out.printf("%-3s %-20s %-8s %-8s\n", "#", "Item", "Qty", "Total(Rs)");
        int i = 1;
        for (CartItem ci : cart) {
            double line = ci.qty * ci.product.price;
            subtotal += line;
            System.out.printf("%-3d %-20s %-8d %-8.2f\n", i++, ci.product.name, ci.qty, line);
        }

        double taxRate = 0.05; // 5% GST for example
        double tax = subtotal * taxRate;
        double grand = subtotal + tax;

        System.out.println("-------------------------------");
        System.out.printf("%-25s: Rs %.2f\n", "Subtotal", subtotal);
        System.out.printf("%-25s: Rs %.2f\n", "Tax (5%)", tax);
        System.out.printf("%-25s: Rs %.2f\n", "Total", grand);

        System.out.println();
        System.out.println("Payment method: 1. Cash  2. Card/Online");
        System.out.print("Choose method: ");
        int pm = readInt(scanner);
        if (pm == 1) {
            System.out.println("Paid by Cash.");
        } else {
            System.out.println("Paid by Card/Online.");
        }

        System.out.println("Thank you for shopping with GrocerX!");
        System.out.println("====================");
    }
}
