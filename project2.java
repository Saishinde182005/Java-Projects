import java.util.ArrayList;
import java.util.Scanner;

class Room {
    int roomNo;
    boolean booked;
    String guestName;

    Room(int num) {
        roomNo = num;
        booked = false;
        guestName = "";
    }

    public String toString() {
        if (booked)
            return "Room " + roomNo + " - Booked by " + guestName;
        else
            return "Room " + roomNo + " - Available";
    }
}

class project2 {
    static ArrayList<Room> rooms = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            rooms.add(new Room(i));
        }

        while (true) {
            menu();
            int ch = getInt("Enter choice: ");

            if (ch == 1) bookRoom();
            else if (ch == 2) cancelRoom();
            else if (ch == 3) showAvailable();
            else if (ch == 4) showAll();
            else if (ch == 5) {
                System.out.println("Exiting...");
                break;
            } else System.out.println("Invalid choice!");
        }
    }

    static void menu() {
        System.out.println("\n--- Hotel Booking System ---");
        System.out.println("1. Book a Room");
        System.out.println("2. Cancel Booking");
        System.out.println("3. View Available Rooms");
        System.out.println("4. View All Rooms");
        System.out.println("5. Exit");
    }

    static void bookRoom() {
        int r = getInt("Enter room number to book: ");

        Room room = findRoom(r);

        if (room == null) {
            System.out.println("Room doesn't exist!");
            return;
        }

        if (room.booked) {
            System.out.println("Room already booked!");
            return;
        }

        System.out.print("Enter guest name: ");
        String name = getString();

        room.booked = true;
        room.guestName = name;

        System.out.println("Room booked successfully!");
    }

    static void cancelRoom() {
        int r = getInt("Enter room number to cancel: ");

        Room room = findRoom(r);

        if (room == null) {
            System.out.println("Room not found!");
            return;
        }

        if (!room.booked) {
            System.out.println("Room is not booked!");
            return;
        }

        room.booked = false;
        room.guestName = "";

        System.out.println("Booking cancelled!");
    }

    static void showAvailable() {
        System.out.println("\n--- Available Rooms ---");
        boolean found = false;

        for (Room r : rooms) {
            if (!r.booked) {
                System.out.println("Room " + r.roomNo);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No available rooms!");
        }
    }

    static void showAll() {
        System.out.println("\n--- All Rooms ---");
        for (Room r : rooms) {
            System.out.println(r);
        }
    }

    static Room findRoom(int num) {
        for (Room r : rooms) {
            if (r.roomNo == num) return r;
        }
        return null;
    }

    static int getInt(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Enter valid number!");
            }
        }
    }

    static String getString() {
        while (true) {
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.print("Input cannot be empty. Enter again: ");
        }
    }
}

