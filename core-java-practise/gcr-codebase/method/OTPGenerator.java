import java.util.HashSet;

public class OTPGenerator {

    public static int generateOTP() {
        return 100000 + (int) (Math.random() * 900000); // ensures 6-digit
    }

    public static boolean validateUnique(int[] otps) {
        HashSet<Integer> set = new HashSet<>();
        for (int otp : otps) {
            if (!set.add(otp))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] otpArray = new int[10];

        System.out.println("Generated OTPs:");
        for (int i = 0; i < otpArray.length; i++) {
            otpArray[i] = generateOTP();
            System.out.println("OTP " + (i + 1) + ": " + otpArray[i]);
        }

        boolean unique = validateUnique(otpArray);
        System.out.println("Are all OTPs unique? " + unique);
    }
}
