import java.util.*;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class project8 {
    static ArrayList<Product> productList = new ArrayList<>();
    static HashMap<Integer, Integer> cart = new HashMap<>();

    static void addDefaultProducts() {
        productList.add(new Product(1, "Laptop", 50000));
        productList.add(new Product(2, "Mobile", 20000));
        productList.add(new Product(3, "Headphones", 2000));
        productList.add(new Product(4, "Keyboard", 1500));
    }

    static Product findProduct(int id) {
        for (Product p : productList) {
            if (p.id == id) {
                return p;
            }
        }
        return null;
    }

    static void viewProducts() {
        System.out.println("\nID\tProduct\t\tPrice");
        System.out.println("------------------------------");
        for (Product p : productList) {
            System.out.println(p.id + "\t" + p.name + "\t\t" + p.price);
        }
    }

    static void addToCart(Scanner sc) {
        viewProducts();
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        Product p = findProduct(id);
        if (p == null) {
            System.out.println("Product Not Found");
            return;
        }

        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        if (qty <= 0) {
            System.out.println("Invalid Quantity");
            return;
        }

        cart.put(id, cart.getOrDefault(id, 0) + qty);
        System.out.println("Item Added to Cart");
    }

    static void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Cart is Empty");
            return;
        }

        double total = 0;
        System.out.println("\nProduct\t\tQty\tPrice\tTotal");
        System.out.println("------------------------------------------");

        for (int id : cart.keySet()) {
            Product p = findProduct(id);
            int qty = cart.get(id);
            double cost = qty * p.price;
            total += cost;

            System.out.println(p.name + "\t\t" + qty + "\t" + p.price + "\t" + cost);
        }

        System.out.println("\nTotal Amount: " + total);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        addDefaultProducts();

        while (true) {
            System.out.println("\n1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                viewProducts();
            } 
            else if (choice == 2) {
                addToCart(sc);
            } 
            else if (choice == 3) {
                viewCart();
            } 
            else if (choice == 4) {
                System.out.println("Thank You");
                break;
            } 
            else {
                System.out.println("Invalid Choice");
            }
        }
    }
}
