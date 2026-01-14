import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow {
    public static void main(String[] args) {

        int[] arr = {12, 15, 14, 1, 23, 17, 21};
        int k = 3;

        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {

            // Remove elements out of window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove smaller elements from back
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }

            // Add current index
            dq.addLast(i);

            // Print max when first window is complete
            if (i >= k - 1) {
                System.out.print(arr[dq.peekFirst()] + " ");
            }
        }
    }
}
