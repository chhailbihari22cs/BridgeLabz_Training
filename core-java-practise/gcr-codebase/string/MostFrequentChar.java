import java.util.HashMap;

public class MostFrequentChar {
    public static void main(String[] args) {
        String str = "success";
        HashMap<Character, Integer> freq = new HashMap<>();

        for (char c : str.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        char maxChar = ' ';
        int maxCount = 0;
        for (char c : freq.keySet()) {
            if (freq.get(c) > maxCount) {
                maxCount = freq.get(c);
                maxChar = c;
            }
        }
        System.out.println("Most Frequent Character: '" + maxChar + "'");
    }
}
