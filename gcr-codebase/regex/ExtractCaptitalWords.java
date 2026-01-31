import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractCaptitalWords {

	public static void main(String[] args) {
		String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
		String regex = "\\b[A-Z][a-z]*\\b";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(text);
		
		while (match.find()) {
            System.out.println(match.group());
        }
	}

}
