class PalindromeChecker {
    private String text;

    PalindromeChecker(String text) {
        this.text = text;
    }

    void check() {
        String clean = text.replaceAll("\\s+", "").toLowerCase();
        String rev = new StringBuilder(clean).reverse().toString();

        if (clean.equals(rev))
            System.out.println(text + " is palindrome");
        else
            System.out.println(text + " is not Palindrome");
    }

    public static void main(String[] args) {
        new PalindromeChecker("A man a plan a canal Panama").check();
        new PalindromeChecker("Hello").check();
    }
}
