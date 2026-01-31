import java.util.*;
public class ValidateLicenseNumber {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter License Plate Number: ");
		String platenumber = sc.nextLine();
		String regex = "^[A-Z]{2}[0-9]{4}";
		if(platenumber.matches(regex)) {
			System.out.println("Valid");
		}else {
			System.out.println("Invalid");
		}
	}

}
