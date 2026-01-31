
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ExtractEmail {

	public static void main(String[] args) {
		
		String text = "Contact us at support@example.com and info@company.org";
		String regex = "[a-zA-Z0-9+-_.]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(text);
		
		while (match.find()) {
            System.out.println(match.group());
        }
	}

}
