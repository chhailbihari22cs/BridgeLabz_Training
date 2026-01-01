class checkInstance {
    public static void main(String[] args) {
        Book bs = new Book("the alchemist", "jatin", "970-4398765");
        Book.displayLibraryName();

        if (bs instanceof Book) {
            bs.displayDetail();
        } else {
            System.out.println("it is not instance of class book");
        }

    }
}

class Book {
    static String libraryName = "vidhya Mandir";
    private String title;
    private String author;
    private final String isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public static void displayLibraryName() {
        System.out.println("name of the library is : " + libraryName);
    }

    public void displayDetail() {
        System.out.println(
                "isbn name is : " + isbn + "\nsuthor name is : " + author + "\nTitle of the book is : " + title);
    }

}