import java.lang.reflect.Method;

class Task {

    public void fastTask() {
        for (int i = 0; i < 1000; i++);
    }

    public void slowTask() {
        for (int i = 0; i < 1000000; i++);
    }
}

public class MethodTimingDemo {

	public static void main(String[] args) throws Exception{
		Task task = new Task();
        Class<?> cls = task.getClass();

        Method[] methods = cls.getDeclaredMethods();

        for (Method method : methods) {

            long startTime = System.nanoTime();

            method.invoke(task);

            long endTime = System.nanoTime();

            long duration = endTime - startTime;
            System.out.println(method.getName() + " executed in " + duration + " ns");
        }

	}

}
