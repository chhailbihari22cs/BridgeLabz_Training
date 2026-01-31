import java.util.*;
public class ValidateUserName {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter UserName: ");
		String username = sc.nextLine();
		String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
		if(username.matches(regex)) {
			System.out.println("Valid");
		}else {
			System.out.println("Invalid");
		}

	}

}
