import java.util.Stack;

public class StackSorting {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(15);
        stack.push(3);
        stack.push(12);

        Stack<Integer> sortedStack = new Stack<>();

        while (!stack.isEmpty()) {
            int temp = stack.pop();

            // move elements back to stack until correct position found

            while (!sortedStack.isEmpty() && sortedStack.peek() > temp) {
                stack.push(sortedStack.pop());
            }
            sortedStack.push(temp);
        }

        System.out.println(sortedStack);
    }
}
