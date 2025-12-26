import java.util.*;

public class Trim {
    static int[] trimIndex(String s) {
        int st = 0, en = s.length() - 1;
        while (st < s.length() && s.charAt(st) == ' ')
            st++;
        while (en >= 0 && s.charAt(en) == ' ')
            en--;
        return new int[] { st, en + 1 };
    }

    static String subStr(String s, int st, int en) {
        String r = "";
        for (int i = st; i < en; i++)
            r += s.charAt(i);
        return r;
    }

    static boolean cmpStr(String a, String b) {
        if (a.length() != b.length())
            return false;
        for (int i = 0; i < a.length(); i++)
            if (a.charAt(i) != b.charAt(i))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] idx = trimIndex(s);
        String r1 = subStr(s, idx[0], idx[1]);
        String r2 = s.trim();
        System.out.println("Compare: " + cmpStr(r1, r2));
    }
}
