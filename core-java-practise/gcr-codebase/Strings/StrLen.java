import java.util.*;

public class StrLen {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println("User method length: " + myLen(s));
        System.out.println("Built-in length: " + s.length());
    }
}
