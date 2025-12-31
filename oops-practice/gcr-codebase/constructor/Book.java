class Book {

    private String title;
    private String author;
    private double price;

    // Default constructor
    Book() {
        this.title = "Unknown";
        this.author = "Not Assigned";
        this.price = 0.0;
    }

    // Parameterized constructor
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void displayBook() {
        System.out.println(title + " | " + author + " | ₹" + price);
    }
}
