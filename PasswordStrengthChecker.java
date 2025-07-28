import java.util.Scanner;

public class PasswordChecker {

    public static String checkStrength(String password) {
        int length = password.length();
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else hasSpecial = true;
        }

        int score = 0;
        if (length >= 8) score++;
        if (hasUpper) score++;
        if (hasLower) score++;
        if (hasDigit) score++;
        if (hasSpecial) score++;

        switch (score) {
            case 5:
                return "Very Strong";
            case 4:
                return "Strong";
            case 3:
                return "Moderate";
            case 2:
                return "Weak";
            default:
                return "Very Weak";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        String result = checkStrength(password);
        System.out.println("Password Strength: " + result);

        sc.close();
    }
}
