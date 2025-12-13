import java.util.ArrayList;
import java.util.Scanner;

class Item {
    int id;
    String name;
    double price;
    int stock;

    Item(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}

public class project6 {
    static ArrayList<Item> inventory = new ArrayList<>();

    static void addItem(Scanner sc) {
        System.out.print("Enter Item ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Item Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Stock Quantity: ");
        int stock = sc.nextInt();

        inventory.add(new Item(id, name, price, stock));
        System.out.println("Item Added");
    }

    static void viewItems() {
        if (inventory.isEmpty()) {
            System.out.println("No Items Available");
            return;
        }

        System.out.println("\nID\tName\tPrice\tStock");
        System.out.println("--------------------------------");
        for (Item i : inventory) {
            System.out.println(i.id + "\t" + i.name + "\t" + i.price + "\t" + i.stock);
        }
    }

    static Item findItem(int id) {
        for (Item i : inventory) {
            if (i.id == id) {
                return i;
            }
        }
        return null;
    }

    static void updateStock(Scanner sc) {
        System.out.print("Enter Item ID: ");
        int id = sc.nextInt();

        Item item = findItem(id);
        if (item == null) {
            System.out.println("Item Not Found");
            return;
        }

        System.out.print("Enter Stock to Add: ");
        int qty = sc.nextInt();
        if (qty > 0) {
            item.stock += qty;
            System.out.println("Stock Updated");
        } else {
            System.out.println("Invalid Quantity");
        }
    }

    static void generateBill(Scanner sc) {
        double total = 0;

        System.out.println("\nEnter 0 to Finish Billing");

        while (true) {
            System.out.print("Enter Item ID: ");
            int id = sc.nextInt();

            if (id == 0) break;

            Item item = findItem(id);
            if (item == null) {
                System.out.println("Item Not Found");
                continue;
            }

            System.out.print("Enter Quantity: ");
            int qty = sc.nextInt();

            if (qty <= 0 || qty > item.stock) {
                System.out.println("Invalid Quantity");
                continue;
            }

            double cost = qty * item.price;
            total += cost;
            item.stock -= qty;

            System.out.println(item.name + " x " + qty + " = " + cost);
        }

        System.out.println("\nTotal Amount: " + total);
        System.out.println("Bill Generated");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Item");
            System.out.println("2. View Inventory");
            System.out.println("3. Update Stock");
            System.out.println("4. Generate Bill");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                addItem(sc);
            } 
            else if (choice == 2) {
                viewItems();
            } 
            else if (choice == 3) {
                updateStock(sc);
            } 
            else if (choice == 4) {
                generateBill(sc);
            } 
            else if (choice == 5) {
                System.out.println("Program Ended");
                break;
            } 
            else {
                System.out.println("Invalid Choice");
            }
        }
    }
}
