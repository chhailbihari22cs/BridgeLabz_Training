import java.lang.reflect.Field;

class Person{
	private int age;
	
}
public class AccessFileds {

	public static void main(String[] args) throws Exception{
		
		Person p = new Person();
        Class<?> cls = p.getClass();

        Field field = cls.getDeclaredField("age");
        field.setAccessible(true);

        field.setInt(p, 25);

        int ageValue = field.getInt(p);
        System.out.println("Age: " + ageValue);
	}

}
