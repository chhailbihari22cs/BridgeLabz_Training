import java.util.*;

public class Split {
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

    static boolean cmpArr(String[] a, String[] b) {
        if (a.length != b.length)
            return false;
        for (int i = 0; i < a.length; i++)
            if (!a[i].equals(b[i]))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] r1 = mySplit(s);
        String[] r2 = s.split(" ");
        System.out.println("Compare arrays: " + cmpArr(r1, r2));
    }
}
