import java.util.*;

public class FreqNested {
    static String[] freqNested(String s) {
        char[] arr = s.toCharArray();
        int[] freq = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0')
                continue;
            freq[i] = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    freq[i]++;
                    arr[j] = '0'; // mark duplicate
                }
            }
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '0')
                list.add(arr[i] + " -> " + freq[i]);
        }
        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] res = freqNested(s);
        System.out.println("Char\tFreq");
        for (String row : res)
            System.out.println(row);
    }
}
