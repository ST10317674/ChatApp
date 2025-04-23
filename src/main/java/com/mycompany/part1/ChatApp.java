import java.util.Scanner;

public class ChatApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== USER REGISTRATION ===");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        System.out.print("Enter your South African cellphone number: ");
        String cellphone = scanner.nextLine();

        Login user = new Login(username, password, cellphone);
        String registrationMessage = user.registerUser();
        System.out.println(registrationMessage);

        if (!registrationMessage.equals("User registered successfully.")) {
            System.out.println("Please restart the application and try again.");
            return;
        }

        System.out.println("\n=== USER LOGIN ===");
        System.out.print("Enter your username: ");
        String usernameInput = scanner.nextLine();

        System.out.print("Enter your password: ");
        String passwordInput = scanner.nextLine();

        boolean loginStatus = user.loginUser(usernameInput, passwordInput);
        System.out.println(user.returnLogin(loginStatus));

        scanner.close();
    }
}