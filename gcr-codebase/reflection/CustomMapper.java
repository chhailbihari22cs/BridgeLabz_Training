
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class ObjectMapperUtil {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {

        T obj = clazz.getDeclaredConstructor().newInstance();
        for (Map.Entry<String, Object> entry : properties.entrySet()) {

            Field field = clazz.getDeclaredField(entry.getKey());
            field.setAccessible(true);
            field.set(obj, entry.getValue());
        }

        return obj;
    }
}

class Student3 {
    private String name;
    private int age;

    public Student3() {}

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class CustomMapper {

	public static void main(String[] args) throws Exception{
		Map<String, Object> data = new HashMap<>();
        data.put("name", "Aman");
        data.put("age", 22);

        Student3 student = ObjectMapperUtil.toObject(Student3.class, data);
        student.display();

	}

}
