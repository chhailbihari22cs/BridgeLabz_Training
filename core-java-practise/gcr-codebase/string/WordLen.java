import java.util.*;

public class WordLen {
    static int myLen(String s) {
        int c = 0;
        try {
            while (true) {
                s.charAt(c);
                c++;
            }
        } catch (Exception e) {
        }
        return c;
    }

    static String[] mySplit(String s) {
        int n = myLen(s);
        ArrayList<String> list = new ArrayList<>();
        String w = "";
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                if (!w.equals(""))
                    list.add(w);
                w = "";
            } else
                w += ch;
        }
        if (!w.equals(""))
            list.add(w);
        return list.toArray(new String[0]);
    }

    static String[][] wordLen(String[] arr) {
        String[][] res = new String[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            res[i][0] = arr[i];
            res[i][1] = String.valueOf(myLen(arr[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] words = mySplit(s);
        String[][] tab = wordLen(words);
        System.out.println("Word\tLength");
        for (String[] row : tab) {
            System.out.println(row[0] + "\t" + Integer.parseInt(row[1]));
        }
    }
}
