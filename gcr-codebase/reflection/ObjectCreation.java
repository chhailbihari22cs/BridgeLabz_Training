import java.lang.reflect.Constructor;

class Student2 {
    private String name;

    public Student2(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("Name: " + name);
    }
}

public class ObjectCreation {

	public static void main(String[] args) throws Exception{
		Class<?> cls = Class.forName("Student2");
        Constructor<?> constructor = cls.getDeclaredConstructor(String.class);

        Object obj = constructor.newInstance("Rahul");

        Student2 s = (Student2) obj;
        s.show();

	}

}
