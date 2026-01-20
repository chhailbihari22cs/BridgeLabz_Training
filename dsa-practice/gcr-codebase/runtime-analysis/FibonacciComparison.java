public class FibonacciComparison {

    // 1. Recursive Approach - O(2^n)
    public static long fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // 2. Iterative Approach - O(N)
    public static long fibonacciIterative(int n) {
        if (n <= 1)
            return n;
        long a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 40; // N=50 recursion one will hang

        // Testing Iterative
        long start = System.nanoTime();
        long resIter = fibonacciIterative(n);
        long end = System.nanoTime();
        System.out.println("Iterative Result (" + n + "): " + resIter);
        System.out.println("Iterative Time: " + (end - start) / 1000000.0 + " ms");

        // Testing Recursive
        System.out.println("\nWait... Recursive calculation chal rahi hai...");
        start = System.nanoTime();
        long resRec = fibonacciRecursive(n);
        end = System.nanoTime();
        System.out.println("Recursive Result (" + n + "): " + resRec);
        System.out.println("Recursive Time: " + (end - start) / 1000000.0 + " ms");
    }
}
