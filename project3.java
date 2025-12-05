import java.util.ArrayList;
import java.util.Scanner;

class MenuItem {
    String name;
    double price;

    MenuItem(String n, double p) {
        name = n;
        price = p;
    }

    public String toString() {
        return name + " - ₹" + price;
    }
}

class OrderItem {
    MenuItem item;
    int qty;

    OrderItem(MenuItem i, int q) {
        item = i;
        qty = q;
    }
}

public class project3 {
    static ArrayList<MenuItem> menu = new ArrayList<>();
    static ArrayList<OrderItem> cart = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // initial menu items
        menu.add(new MenuItem("Pizza", 150));
        menu.add(new MenuItem("Burger", 80));
        menu.add(new MenuItem("Fries", 60));

        while (true) {
            showMenu();
            int ch = getInt("Enter choice: ");

            if (ch == 1) addMenuItem();
            else if (ch == 2) removeMenuItem();
            else if (ch == 3) orderFood();
            else if (ch == 4) printBill();
            else if (ch == 5) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }

    static void showMenu() {
        System.out.println("\n--- Restaurant Billing System ---");
        System.out.println("1. Add New Menu Item");
        System.out.println("2. Remove Menu Item");
        System.out.println("3. Order Food");
        System.out.println("4. Generate Bill");
        System.out.println("5. Exit");
    }

    static void addMenuItem() {
        System.out.print("Enter item name: ");
        String name = getString();

        double price = getDouble("Enter price: ");

        menu.add(new MenuItem(name, price));
        System.out.println("Item added!");
    }

    static void removeMenuItem() {
        System.out.print("Enter item name to remove: ");
        String name = sc.nextLine().trim();

        boolean ok = menu.removeIf(m -> m.name.equalsIgnoreCase(name));

        if (ok) System.out.println("Item removed!");
        else System.out.println("Item not found.");
    }

    static void orderFood() {
        System.out.println("\n--- Available Items ---");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }

        int itemNo = getInt("Choose item number: ");
        if (itemNo < 1 || itemNo > menu.size()) {
            System.out.println("Invalid choice!");
            return;
        }

        int qty = getInt("Enter quantity: ");
        if (qty <= 0) {
            System.out.println("Invalid quantity!");
            return;
        }

        MenuItem m = menu.get(itemNo - 1);
        cart.add(new OrderItem(m, qty));

        System.out.println("Added to order!");
    }

    static void printBill() {
        if (cart.isEmpty()) {
            System.out.println("No items ordered!");
            return;
        }

        double total = 0;

        System.out.println("\n-------- Bill Receipt --------");

        for (OrderItem o : cart) {
            double cost = o.item.price * o.qty;
            System.out.println(o.item.name + " x " + o.qty + " = ₹" + cost);
            total += cost;
        }

        double gst = total * 0.05; 
        double finalAmount = total + gst;

        System.out.println("------------------------------");
        System.out.println("Subtotal: ₹" + total);
        System.out.println("GST (5%): ₹" + gst);
        System.out.println("Total Payable: ₹" + finalAmount);
        System.out.println("------------------------------");

        cart.clear(); 
    }

    static int getInt(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Enter valid number.");
            }
        }
    }

    static double getDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Enter valid amount.");
            }
        }
    }

    static String getString() {
        while (true) {
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.print("Can't be empty. Enter again: ");
        }
    }
}
