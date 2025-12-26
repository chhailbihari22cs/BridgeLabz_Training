import java.util.Scanner;

public class FactorOperations {

    // Method to find factors of a number
    public static int[] findFactors(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0)
                count++;
        }

        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0)
                factors[index++] = i;
        }
        return factors;
    }

    // Method to find greatest factor
    public static int greatestFactor(int[] factors) {
        int max = factors[0];
        for (int f : factors)
            if (f > max)
                max = f;
        return max;
    }

    // Method to find sum of factors
    public static int sumFactors(int[] factors) {
        int sum = 0;
        for (int f : factors)
            sum += f;
        return sum;
    }

    // Method to find product of factors
    public static long productFactors(int[] factors) {
        long product = 1;
        for (int f : factors)
            product *= f;
        return product;
    }

    // Method to find product of cube of factors
    public static long productCubeFactors(int[] factors) {
        long product = 1;
        for (int f : factors)
            product *= Math.pow(f, 3);
        return product;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int[] factors = findFactors(num);

        System.out.print("Factors: ");
        for (int f : factors)
            System.out.print(f + " ");
        System.out.println();

        System.out.println("Greatest Factor: " + greatestFactor(factors));
        System.out.println("Sum of Factors: " + sumFactors(factors));
        System.out.println("Product of Factors: " + productFactors(factors));
        System.out.println("Product of Cubes of Factors: " + productCubeFactors(factors));
    }
}
