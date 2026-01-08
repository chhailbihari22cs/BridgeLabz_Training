
class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    Ticket(int id, String name, String movie, String seat, String time) {
        this.ticketId = id;
        this.customerName = name;
        this.movieName = movie;
        this.seatNumber = seat;
        this.bookingTime = time;
        this.next = null;
    }
}

class TicketSystem {
    private Ticket head = null;
    private Ticket tail = null;

    // 1. Add Ticket (End mein add karke circle banana)
    public void addTicket(int id, String name, String movie, String seat, String time) {
        Ticket newTicket = new Ticket(id, name, movie, seat, time);
        if (head == null) {
            head = newTicket;
            tail = newTicket;
            newTicket.next = head; // Circle ban gaya
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head; // Last node ko head se link kiya
        }
        System.out.println("Ticket booked for: " + name);
    }

    // 2. Display All Tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("Koi ticket booked nahi hai.");
            return;
        }
        Ticket temp = head;
        System.out.println("\n--- Current Bookings ---");
        do {
            System.out.println("ID: " + temp.ticketId + " | Customer: " + temp.customerName + 
                               " | Movie: " + temp.movieName + " | Seat: " + temp.seatNumber);
            temp = temp.next;
        } while (temp != head);
    }

    // 3. Search by Movie Name
    public void searchByMovie(String movie) {
        if (head == null) return;
        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.movieName.equalsIgnoreCase(movie)) {
                System.out.println("Mila: " + temp.customerName + " (Seat: " + temp.seatNumber + ")");
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println(movie + " ke liye koi ticket nahi mili.");
    }

    // 4. Remove Ticket by ID
    public void removeTicket(int id) {
        if (head == null) return;

        Ticket curr = head, prev = tail;
        do {
            if (curr.ticketId == id) {
                if (head == tail) { // Sirf ek hi ticket ho
                    head = tail = null;
                } else {
                    prev.next = curr.next;
                    if (curr == head) head = head.next;
                    if (curr == tail) tail = prev;
                }
                System.out.println("Ticket ID " + id + " cancel ho gayi.");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
        System.out.println("Ticket ID nahi mili.");
    }

    // 5. Calculate Total Tickets
    public int countTickets() {
        if (head == null) return 0;
        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
}

public class TicketReservationSystem {
    public static void main(String[] args) {
        TicketSystem system = new TicketSystem();

        system.addTicket(101, "Rahul", "Avatar 2", "A1", "10:00 AM");
        system.addTicket(102, "Sneha", "Inception", "B5", "01:00 PM");
        system.addTicket(103, "Amit", "Avatar 2", "A2", "10:00 AM");

        system.displayTickets();

        System.out.println("\nSearching for 'Avatar 2' bookings:");
        system.searchByMovie("Avatar 2");

        System.out.println("\nTotal booked: " + system.countTickets());

        system.removeTicket(102);
        system.displayTickets();
    }
}