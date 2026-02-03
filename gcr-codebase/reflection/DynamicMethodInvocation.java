import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvocation {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		MathOperations obj = new MathOperations();
		Class<?> cls = obj.getClass();
		
		System.out.print("Enter method name: ");
        String methodName = sc.nextLine();

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        
        Method method = cls.getDeclaredMethod(methodName, int.class,int.class);
        int ans = (int)method.invoke(obj, a, b);
        System.out.println("Output is: "+ans);

	}

}
