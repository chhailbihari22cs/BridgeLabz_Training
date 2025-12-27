public class ReplaceWord {
    public static String replaceWord(String sentence, String oldWord, String newWord) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.equals(oldWord))
                result.append(newWord).append(" ");
            else
                result.append(word).append(" ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        String sentence = "Java is fun and Java is powerful";
        System.out.println(replaceWord(sentence, "Java", "Python"));
    }
}
