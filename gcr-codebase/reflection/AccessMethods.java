import java.lang.reflect.Method;

class Calculator{
	private int multiply(int a,int b) {
		return a*b;
	}
}
public class AccessMethods {

	public static void main(String[] args) throws Exception{
		Calculator calc = new Calculator();
		Class<?> cls = Calculator.class;
		
		Method method = cls.getDeclaredMethod("multiply", int.class,int.class);
		method.setAccessible(true);
		
		int result = (int) method.invoke(calc,5,10);
		System.out.println("Result: " + result);
	}

}
