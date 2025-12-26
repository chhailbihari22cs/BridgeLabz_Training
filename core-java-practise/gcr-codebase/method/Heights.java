import java.util.Random;

public class Heights {

    public static int sumHeights(int[] heights) {
        int total = 0;
        for (int h : heights)
            total += h;
        return total;
    }

    public static double meanHeight(int[] heights) {
        return (double) sumHeights(heights) / heights.length;
    }

    public static int shortestHeight(int[] heights) {
        int min = heights[0];
        for (int h : heights)
            if (h < min)
                min = h;
        return min;
    }

    public static int tallestHeight(int[] heights) {
        int max = heights[0];
        for (int h : heights)
            if (h > max)
                max = h;
        return max;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] heights = new int[11];

        for (int i = 0; i < heights.length; i++) {
            heights[i] = 150 + rand.nextInt(101); // 150–250
        }

        System.out.println("Players' Heights:");
        for (int h : heights)
            System.out.print(h + " ");
        System.out.println();

        System.out.println("Shortest: " + shortestHeight(heights));
        System.out.println("Tallest: " + tallestHeight(heights));
        System.out.printf("Mean Height: %.2f\n", meanHeight(heights));
    }
}
