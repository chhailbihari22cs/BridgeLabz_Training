import java.util.*;

public class SearchDataStructures {
    public static void main(String[] args) {
        int n = 100000; // 1 Lakh elements
        int target = 99999; // Jo hume dhundhna hai

        // 1. Array Setup
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i;

        // 2. HashSet Setup
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) hashSet.add(i);

        // 3. TreeSet Setup
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) treeSet.add(i);

        // --- Searching Performance Check ---

        // Array Search (Linear)
        long start = System.nanoTime();
        boolean foundArr = false;
        for (int x : arr) {
            if (x == target) { foundArr = true; break; }
        }
        System.out.println("Array Search Time: " + (System.nanoTime() - start) / 1000000.0 + " ms");

        // HashSet Search (O(1))
        start = System.nanoTime();
        hashSet.contains(target);
        System.out.println("HashSet Search Time: " + (System.nanoTime() - start) / 1000000.0 + " ms");

        // TreeSet Search (O(log N))
        start = System.nanoTime();
        treeSet.contains(target);
        System.out.println("TreeSet Search Time: " + (System.nanoTime() - start) / 1000000.0 + " ms");
    }
}