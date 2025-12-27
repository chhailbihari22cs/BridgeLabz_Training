public class LongestWord {
    public static void main(String[] args) {
        String sentence = "Java programming is powerful";
        String[] words = sentence.split(" ");
        String longest = "";

        for (String word : words) {
            if (word.length() > longest.length())
                longest = word;
        }
        System.out.println("Longest word: " + longest);
    }
}
