package com.mycompany.part1;

public class Login {

    private String username;
    private String password;
    private String cellphone;

    public Login(String username, String password, String cellphone) {
        this.username = username;
        this.password = password;
        this.cellphone = cellphone;
    }

    public boolean checkUsername() {
        return username.length() <= 12 && username.contains("$");
    }

    /*
    Title: Java Regex Password Validation
    Author: W3Schools
    Date: 14/04/2025
    Availability: https://www.w3schools.com/java/java_regex.asp
    */
    public boolean checkPassword() {
        final String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        return password.matches(passwordRegex);
    }

    public boolean checkCellphone() {
        // Valid SA cellphone numbers start with 0 and have 10 digits.
        return cellphone.matches("0[6-8][0-9]{8}");
    }

    public String registerUser() {
        if (!checkUsername()) {
            return "Username format not correct (must contain $ and be under 12 characters)";
        } else if (!checkPassword()) {
            return "Password format not correct (must include uppercase, number, and symbol)";
        } else if (!checkCellphone()) {
            return "Cellphone number format not correct (must be a valid SA number)";
        } else {
            return "User registered successfully.";
        }
    }

    public boolean loginUser(String usernameInput, String passwordInput) {
        return usernameInput.equals(username) && passwordInput.equals(password);
    }

    public String returnLogin(boolean loginStatus) {
        return loginStatus ? "Welcome Okuhle" : "Invalid credentials";
    }
}