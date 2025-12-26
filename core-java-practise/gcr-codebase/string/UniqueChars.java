import java.util.*;

public class UniqueChars {
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

    static char[] findUnique(String s) {
        int n = myLen(s);
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] unique = findUnique(s);
        System.out.println("Unique characters:");
        for (char c : unique)
            System.out.print(c + " ");
    }
}
