public class RemoveCharacter {
    public static void main(String[] args) {
        String str = "Hello World";
        char remove = 'l';
        StringBuilder result = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c != remove)
                result.append(c);
        }
        System.out.println("Modified String: " + result);
    }
}
