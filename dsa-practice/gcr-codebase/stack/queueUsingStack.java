import java.util.Stack;

public class queueUsingStack {
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(10);
        stack1.push(20);
        stack1.push(30);
        System.out.println(stack1);
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        System.out.println(stack2);
    }
}
