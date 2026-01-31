
public class IpValidator {

	public static void main(String[] args) {
		String ip = "192.168.1.1";

        String regex = "^((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\.){3}" +"(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])$";

        if (ip.matches(regex)) {
            System.out.println("Valid IP Address");
        } else {
            System.out.println("Invalid IP Address");
        }

	}

}
