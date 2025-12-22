import java.util.*;

public class FreqUnique {
    // Find unique characters using charAt()
    static char[] uniqueChars(String s) {
        int n = s.length();
        char[] res = new char[n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            boolean found = false;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == ch) {
                    found = true;
                    break;
                }
            }
            if (!found)
                res[k++] = ch;
        }
        return Arrays.copyOf(res, k);
    }

    // Frequency using ASCII array
    static String[][] freqTable(String s) {
        int[] freq = new int[256];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i)]++;
        char[] uniq = uniqueChars(s);
        String[][] res = new String[uniq.length][2];
        for (int i = 0; i < uniq.length; i++) {
            res[i][0] = String.valueOf(uniq[i]);
            res[i][1] = String.valueOf(freq[uniq[i]]);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[][] table = freqTable(s);
        System.out.println("Char\tFreq");
        for (String[] row : table)
            System.out.println(row[0] + "\t" + row[1]);
    }
}
