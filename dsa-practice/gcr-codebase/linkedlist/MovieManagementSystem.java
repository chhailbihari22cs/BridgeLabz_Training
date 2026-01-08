class Movie {
    String title, director;
    int year;
    double rating;
    Movie next, prev; // Do pointers: aage aur peeche ke liye

    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieList {
    Movie head = null;
    Movie tail = null; // Tail pointer se reverse display aasaan ho jata hai

    // 1. Add Movie at the End
    public void addMovie(String t, String d, int y, double r) {
        Movie newNode = new Movie(t, d, y, r);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Movie added: " + t);
    }

    // 2. Display Forward
    public void displayForward() {
        System.out.println("\n--- Movies (Forward Order) ---");
        Movie temp = head;
        while (temp != null) {
            System.out.println(temp.title + " | Dir: " + temp.director + " | Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    // 3. Display Reverse
    public void displayReverse() {
        System.out.println("\n--- Movies (Reverse Order) ---");
        Movie temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " | Dir: " + temp.director + " | Rating: " + temp.rating);
            temp = temp.prev;
        }
    }

    // 4. Update Rating by Title
    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated for: " + title);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie nahi mili.");
    }

    // 5. Remove Movie by Title
    public void removeMovie(String title) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
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
                System.out.println("Removed: " + title);
                return;
            }
            temp = temp.next;
        }
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieList list = new MovieList();

        list.addMovie("Inception", "Christopher Nolan", 2010, 8.8);
        list.addMovie("Interstellar", "Christopher Nolan", 2014, 8.6);
        list.addMovie("The Dark Knight", "Christopher Nolan", 2008, 9.0);

        list.displayForward();
        list.displayReverse();

        list.updateRating("Inception", 9.2);
        list.removeMovie("Interstellar");

        list.displayForward();
    }
}