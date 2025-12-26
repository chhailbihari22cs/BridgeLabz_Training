public class NumberChecker2 {

    public static int[] getDigits(int num) {
        String s = String.valueOf(num);
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++)
            digits[i] = s.charAt(i) - '0';
        return digits;
    }

    public static int sumDigits(int[] digits) {
        int sum = 0;
        for (int d : digits)
            sum += d;
        return sum;
    }

    public static int sumSquares(int[] digits) {
        int sum = 0;
        for (int d : digits)
            sum += Math.pow(d, 2);
        return sum;
    }

    public static boolean isHarshad(int num) {
        int[] digits = getDigits(num);
        int sum = sumDigits(digits);
        return num % sum == 0;
    }

    public static int[][] digitFrequency(int num) {
        int[] digits = getDigits(num);
        int[][] freq = new int[10][2]; // digit, count
        for (int i = 0; i < 10; i++)
            freq[i][0] = i;
        for (int d : digits)
            freq[d][1]++;
        return freq;
    }

    public static void main(String[] args) {
        int num = 21;
        int[] digits = getDigits(num);

        System.out.println("Sum of digits: " + sumDigits(digits));
        System.out.println("Sum of squares: " + sumSquares(digits));
        System.out.println("Harshad number: " + isHarshad(num));

        int[][] freq = digitFrequency(num);
        System.out.println("Digit frequencies:");
        for (int[] row : freq) {
            if (row[1] > 0)
                System.out.println(row[0] + " -> " + row[1]);
        }
    }
}
