import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    int year;

    Book(String t, String a, int y) {
        title = t;
        author = a;
        year = y;
    }

    public String toString() {
        return "Title: " + title + " | Author: " + author + " | Year: " + year;
    }
}

class LibrarySystem {
    static ArrayList<Book> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            menu();
            int ch = getInt("Enter choice: ");

            if (ch == 1) {
                add();
            } else if (ch == 2) {
                remove();
            } else if (ch == 3) {
                search();
            } else if (ch == 4) {
                show();
            } else if (ch == 5) {
                break;
            } else {
                System.out.println("Wrong choice...");
            }
        }
    }

    static void menu() {
        System.out.println("\n--- Library Menu ---");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Search Book");
        System.out.println("4. Show All Books");
        System.out.println("5. Exit");
    }

    static void add() {
        System.out.print("Enter title: ");
        String t = getString();

        System.out.print("Enter author: ");
        String a = getString();

        int y = getInt("Enter year: ");

        Book b = new Book(t, a, y);
        list.add(b);

        System.out.println("Book added!");
    }

    static void remove() {
        System.out.print("Enter title to remove: ");
        String t = sc.nextLine().trim();

        boolean ok = list.removeIf(b -> b.title.equalsIgnoreCase(t));

        if (ok)
            System.out.println("Removed!");
        else
            System.out.println("Book not found.");
    }

    static void search() {
        System.out.print("Enter title to search: ");
        String t = sc.nextLine().trim();

        boolean found = false;

        for (Book b : list) {
            if (b.title.equalsIgnoreCase(t)) {
                System.out.println("Book found:");
                System.out.println(b);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Not found.");
        }
    }

    static void show() {
        if (list.isEmpty()) {
            System.out.println("No books.");
            return;
        }

        System.out.println("--- All Books ---");
        for (Book b : list) {
            System.out.println(b);
        }
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

    static String getString() {
        while (true) {
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.print("Can't be empty. Enter again: ");
        }
    }
}
