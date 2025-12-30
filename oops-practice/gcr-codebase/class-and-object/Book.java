class Book {
    private String title, author;
    private double price;

    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void display() {
        System.out.println("Title of the book: " + title);
        System.out.println("Author of the book: " + author);
        System.out.println("Price of the book: " + price);
    }

    public static void main(String[] args) {
        new Book("2States", "Chetan Bhagat", 500).display();
        new Book("Wings Of Fire", "Abdul Kalam A.P.J", 500).display();
    }
}
