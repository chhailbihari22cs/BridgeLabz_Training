import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int[] price = {100, 80, 60, 70, 60, 75, 85};
        int n = price.length;

        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>(); // stores indices

        // Step 1: first day
        span[0] = 1;
        stack.push(0);

        // Step 2: process rest of the days
        for (int i = 1; i < n; i++) {

            // pop indices with smaller or equal price
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }

            // calculate span
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - stack.peek();
            }

            // push current index
            stack.push(i);
        }

        // print result
        for (int s : span) {
            System.out.print(s + " ");
        }
    }
}
