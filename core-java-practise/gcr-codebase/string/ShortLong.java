import java.util.*;

public class ShortLong {
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

    static int[] findMinMax(String[][] arr) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (String[] row : arr) {
            int l = Integer.parseInt(row[1]);
            if (l < min)
                min = l;
            if (l > max)
                max = l;
        }
        return new int[] { min, max };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] words = mySplit(s);
        String[][] tab = wordLen(words);
        int[] res = findMinMax(tab);
        System.out.println("Shortest length: " + res[0]);
        System.out.println("Longest length: " + res[1]);
    }
}
