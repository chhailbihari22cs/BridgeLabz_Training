import java.util.Scanner;
import java.util.Arrays;

class GeometryComparison {

    // UC 1--> calculating the length of the line
    public static double lineLength(double[] p1, double[] p2) {
        return Math.sqrt(
                Math.pow(p1[0] - p2[0], 2) +
                        Math.pow(p1[1] - p2[1], 2)
        );
    }

    // UC 2--> checking if both lines are equal or not
    public static int isEqualLines(double[] p1,double[] p2,double[] p3,double[] p4) {
        double l1 = lineLength(p1, p2);
        double l2 = lineLength(p3, p4);

        if (Math.abs(l1 - l2) < 0.0001) {
            return 0; // Equal
        }
        return 1; // Not Equal
    }

    // UC 3--> getting the greatest length
    public static void getGreaterLength(double[] p1, double[] p2, double[] p3, double[] p4) {
        double l1 = lineLength(p1, p2);
        double l2 = lineLength(p3, p4);

        if (l1 > l2) {
            System.out.println("Line "+Arrays.toString(p1)+" is greater to "+Arrays.toString(p2));
        } else if (l1 < l2) {
            System.out.println("Line "+Arrays.toString(p3)+" is greater to " +Arrays.toString(p4));
        } else {
            System.out.println("Both lines are equal");
        }
    }
}
public class LineComparison {
    static void readPoint(Scanner sc, double[] p) {
        p[0] = sc.nextDouble();
        p[1] = sc.nextDouble();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Line Comparison Computation Program");
        System.out.println("1 → Length of line");
        System.out.println("2 → Check equality");
        System.out.println("3 → Compare length");
        int choice = sc.nextInt();
        System.out.println("<=====================================================>");
        double[] p1 = new double[2];
        double[] p2 = new double[2];
        double[] p3 = new double[2];
        double[] p4 = new double[2];

        switch (choice) {

            case 1:
                System.out.println("Enter the coordinates p1(x1 y1):");
                readPoint(sc, p1);
                System.out.println("Enter the coordinates p2(x2 y2):");
                readPoint(sc, p2);
                System.out.println("Length of the line is--> " + GeometryComparison.lineLength(p1, p2));
                break;

            case 2:
                System.out.println("Enter coordinates of line 1 (x1 y1 x2 y2):");
                readPoint(sc, p1);
                readPoint(sc, p2);
                System.out.println("Enter coordinates of line 2 (x3 y3 x4 y4):");
                readPoint(sc, p3);
                readPoint(sc, p4);
                System.out.println("(0-→Equal, 1-→Not Equal)");
                System.out.println("Result--> " +GeometryComparison.isEqualLines(p1, p2, p3, p4));
                break;

            case 3:
                System.out.println("Enter coordinates of line 1 (x1 y1 x2 y2):");
                readPoint(sc, p1);
                readPoint(sc, p2);
                System.out.println("Enter coordinates of line 2 (x3 y3 x4 y4):");
                readPoint(sc, p3);
                readPoint(sc, p4);
                GeometryComparison.getGreaterLength(p1, p2, p3, p4);
                break;
            default:
                System.out.println("Enter coordinates of line 1 (x1 y1 x2 y2):");
                readPoint(sc, p1);
                readPoint(sc, p2);
                System.out.println("Enter coordinates of line 2 (x3 y3 x4 y4):");
                readPoint(sc, p3);
                readPoint(sc, p4);
                System.out.println("Length of the line is--> " + GeometryComparison.lineLength(p1, p2));
                System.out.println("(0 → Equal, 1 → Not Equal)");
                System.out.println("Result-->" +GeometryComparison.isEqualLines(p1, p2, p3, p4));
                GeometryComparison.getGreaterLength(p1, p2, p3, p4);
        }
        sc.close();
    }
}

