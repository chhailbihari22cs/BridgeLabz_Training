import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "Author Name")
class Book {
}


public class RetrieveAnnotation {

	public static void main(String[] args) {
		Class<Book> cls = Book.class;

        Author author = cls.getAnnotation(Author.class);

        if (author != null) {
            System.out.println("Author Name: " + author.name());
        }

	}

}
