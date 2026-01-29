import java.util.*;

// Custom Exception
class TableAlreadyReservedException extends Exception {
    public TableAlreadyReservedException(String message) {
        super(message);
    }
}

// Table Class
class Table {
    int tableNumber;
    int capacity;

    public Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
    }
}

// Reservation Class
class Reservation {
    int tableNumber;
    String customerName;
    String timeSlot;

    public Reservation(int tableNumber, String customerName, String timeSlot) {
        this.tableNumber = tableNumber;
        this.customerName = customerName;
        this.timeSlot = timeSlot;
    }
}

// Main System Class
public class RestaurantReservationSystem {

    Map<Integer, Table> tableMap = new HashMap<>();
    List<Reservation> reservations = new ArrayList<>();

    // Reserve Table
    public void reserveTable(int tableNumber, String customerName, String timeSlot)
            throws TableAlreadyReservedException {

        for (Reservation r : reservations) {
            if (r.tableNumber == tableNumber && r.timeSlot.equals(timeSlot)) {
                throw new TableAlreadyReservedException(
                        "Table " + tableNumber + " is already reserved for " + timeSlot);
            }
        }

        reservations.add(new Reservation(tableNumber, customerName, timeSlot));
        System.out.println("Reservation successful for " + customerName);
    }

    // Cancel Reservation
    public void cancelReservation(int tableNumber, String timeSlot) {
        Iterator<Reservation> iterator = reservations.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Reservation r = iterator.next();
            if (r.tableNumber == tableNumber && r.timeSlot.equals(timeSlot)) {
                iterator.remove();
                found = true;
                System.out.println("Reservation cancelled.");
                break;
            }
        }

        if (!found) {
            System.out.println("No reservation found to cancel.");
        }
    }

    // Show Available Tables
    public void showAvailableTables(String timeSlot) {
        System.out.println("Available tables for " + timeSlot + ":");

        for (Table table : tableMap.values()) {
            boolean reserved = false;

            for (Reservation r : reservations) {
                if (r.tableNumber == table.tableNumber && r.timeSlot.equals(timeSlot)) {
                    reserved = true;
                    break;
                }
            }

            if (!reserved) {
                System.out.println("Table " + table.tableNumber);
            }
        }
    }

    // Main Method
    public static void main(String[] args) {
        RestaurantReservationSystem system = new RestaurantReservationSystem();

        // Add tables
        system.tableMap.put(1, new Table(1, 4));
        system.tableMap.put(2, new Table(2, 2));
        system.tableMap.put(3, new Table(3, 6));

        try {
            system.reserveTable(1, "Rahul", "7PM-8PM");
            system.reserveTable(2, "Aman", "7PM-8PM");

            // This will throw exception
            system.reserveTable(1, "Rohit", "7PM-8PM");

        } catch (TableAlreadyReservedException e) {
            System.out.println(e.getMessage());
        }

        system.showAvailableTables("7PM-8PM");
        system.cancelReservation(2, "7PM-8PM");
        system.showAvailableTables("7PM-8PM");
    }
}
