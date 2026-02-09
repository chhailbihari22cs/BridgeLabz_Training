
interface SecurityUtils {

    static boolean isStrongPassword(String password) {
        if (password == null) return false;

        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*[a-z].*") &&
               password.matches(".*[0-9].*") &&
               password.matches(".*[@#$%!].*");
    }
}
public class InsurancePortal {

	public static void main(String[] args) {
		String password = "Secure@123";

        if (SecurityUtils.isStrongPassword(password)) {
            System.out.println("Strong password accepted");
        } else {
            System.out.println("Weak password. Please follow policy rules.");
        }

	}

}
