
public class Library {
    public static void main(String[] args) {
        Book bc=new Author("Clean Code",2008,"Robert C. Martin","Software engineer and author known for clean coding practices");
        bc.displayInfo();

        
    }
}
class Book
{
    String title;
    int publicationYear;
    public Book(String title,int publicationYear)
    {
        this.title=title;
        this.publicationYear=publicationYear;
    }
    public void displayInfo()
    {
        System.out.println("title : "+title+"\npublication year is : "+publicationYear);
    }
}
class Author extends Book
{
    String name;
    String Bio;
    public Author(String title,int publicationYear,String name,String Bio)
    {
        super(title,publicationYear);
        this.name=name;
        this.Bio=Bio;
    }
    public void displayInfo()
    {
    super.displayInfo();
    System.out.println("name is : "+name+"\nBio is : "+Bio);
     
    }
}
