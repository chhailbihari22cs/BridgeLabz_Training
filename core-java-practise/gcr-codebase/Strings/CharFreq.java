import java.util.*;

public class CharFreq {
    static String[][] freqTable(String s) {
        int[] freq = new int[256];
        for (int i = 0; i < s.length(); i++)
            freq[s.charAt(i)]++;
        boolean[] done = new boolean[256];
        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!done[ch]) {
                list.add(new String[] { String.valueOf(ch), String.valueOf(freq[ch]) });
                done[ch] = true;
            }
        }
        return list.toArray(new String[0][0]);
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
