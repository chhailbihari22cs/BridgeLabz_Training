class Book {
    String title, author, genre;
    int id;
    boolean isAvailable;
    Book next, prev;

    Book(int id, String title, String author, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = true; // By default book available hogi
        this.next = null;
        this.prev = null;
    }
}

class Library {
    Book head = null;
    Book tail = null;

    // 1. Add Book (End mein)
    public void addBook(int id, String title, String author, String genre) {
        Book newNode = new Book(id, title, author, genre);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Book Added: " + title);
    }

    // 2. Remove Book by ID
    public void removeBook(int id) {
        Book temp = head;
        while (temp != null) {
            if (temp.id == id) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                System.out.println("Book ID " + id + " removed.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book nahi mili.");
    }

    // 3. Update Availability
    public void updateStatus(int id, boolean status) {
        Book temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.isAvailable = status;
                String s = status ? "Available" : "Borrowed";
                System.out.println("Status updated to: " + s);
                return;
            }
            temp = temp.next;
        }
    }

    // 4. Display Forward
    public void displayForward() {
        System.out.println("\n--- Library Catalog (A-Z) ---");
        Book temp = head;
        while (temp != null) {
            System.out.println("[" + temp.id + "] " + temp.title + " by " + temp.author + " | Status: " + (temp.isAvailable ? "Available" : "Out"));
            temp = temp.next;
        }
    }

    // 5. Display Reverse
    public void displayReverse() {
        System.out.println("\n--- Library Catalog (Z-A) ---");
        Book temp = tail;
        while (temp != null) {
            System.out.println("[" + temp.id + "] " + temp.title + " by " + temp.author);
            temp = temp.prev;
        }
    }

    // 6. Count Total Books
    public int countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library myLibrary = new Library();

        myLibrary.addBook(1, "The Great Gatsby", "F. Scott Fitzgerald", "Classic");
        myLibrary.addBook(2, "1984", "George Orwell", "Dystopian");
        myLibrary.addBook(3, "The Hobbit", "J.R.R. Tolkien", "Fantasy");

        myLibrary.displayForward();

        System.out.println("\nTotal books: " + myLibrary.countBooks());

        System.out.println("\nUpdating status of Book 2 (Borrowed)...");
        myLibrary.updateStatus(2, false);

        myLibrary.displayForward();
        
        System.out.println("\nReverse View:");
        myLibrary.displayReverse();
    }
}