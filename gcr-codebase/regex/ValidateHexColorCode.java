import java.util.*;
public class ValidateHexColorCode {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Hex Color Code: ");
		String hexcode = sc.nextLine();
		String regex = "^[#]{1}[0-9A-Fa-f]{6}";
		if(hexcode.matches(regex)){
			System.out.println("Valid");
		}else {
			System.out.println("Invalid");
		}
	}

}
