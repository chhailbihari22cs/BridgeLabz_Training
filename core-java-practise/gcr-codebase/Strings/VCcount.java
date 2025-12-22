import java.util.*;

public class VCcount {
    static String typeChar(char c) {
        if (c >= 'A' && c <= 'Z')
            c = (char) (c + 32);
        if (c >= 'a' && c <= 'z') {
            if ("aeiou".indexOf(c) >= 0)
                return "Vowel";
            else
                return "Consonant";
        }
        return "Not a Letter";
    }

    static int[] countVC(String s) {
        int v = 0, c = 0;
        for (int i = 0; i < s.length(); i++) {
            String t = typeChar(s.charAt(i));
            if (t.equals("Vowel"))
                v++;
            else if (t.equals("Consonant"))
                c++;
        }
        return new int[] { v, c };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] res = countVC(s);
        System.out.println("Vowels: " + res[0] + " Consonants: " + res[1]);
    }
}
