import java.util.*;

public class BMICalc {
    static double calcBMI(double wt, double htCm) {
        double htM = htCm / 100.0;
        return wt / (htM * htM);
    }

    static String status(double bmi) {
        if (bmi < 18.5)
            return "Underweight";
        else if (bmi < 25)
            return "Normal";
        else if (bmi < 30)
            return "Overweight";
        else
            return "Obese";
    }

    static String[][] computeBMI(double[][] data) {
        String[][] res = new String[data.length][4];
        for (int i = 0; i < data.length; i++) {
            double wt = data[i][0], ht = data[i][1];
            double bmi = Math.round(calcBMI(wt, ht) * 100.0) / 100.0;
            res[i][0] = String.valueOf(ht);
            res[i][1] = String.valueOf(wt);
            res[i][2] = String.valueOf(bmi);
            res[i][3] = status(bmi);
        }
        return res;
    }

    static void display(String[][] arr) {
        System.out.println("Ht(cm)\tWt(kg)\tBMI\tStatus");
        for (String[] row : arr) {
            System.out.println(row[0] + "\t" + row[1] + "\t" + row[2] + "\t" + row[3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][2];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight and height for person " + (i + 1) + ": ");
            data[i][0] = sc.nextDouble(); // weight
            data[i][1] = sc.nextDouble(); // height
        }
        String[][] result = computeBMI(data);
        display(result);
    }
}
