/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepart1;

/**
 *
 * @author RC_Student_lab
 */
public class Login {
   
    private String username;
    private String password;
    private String cellPhone;
    private boolean loginStatus = false;

    // Constructor
    public Login(String username, String password, String cellPhone) {
        this.username = username;
        this.password = password;
        this.cellPhone = cellPhone;
    }

    // 1. checkUserName()
    public boolean checkUserName() {
        return username != null && username.contains("_") && username.length() <= 5;
    }

    // 2. checkPasswordComplexity()
    public boolean checkPasswordComplexity() {
        if (password == null) return false;
        boolean longEnough = password.length() >= 8;
        boolean hasUpper   = false;
        boolean hasDigit   = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else if (!Character.isLetterOrDigit(ch)) hasSpecial = true;
        }
        return longEnough && hasUpper && hasDigit && hasSpecial;
    }

    // 3. checkCellPhoneNumber()
    public boolean checkCellPhoneNumber() {
        if (cellPhone == null) return false;
        return cellPhone.matches("^\\+27\\d{1,10}$");
    }

    // 4. registerUser()
    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber()) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        return "Registration successful!";
    }

    // 5. loginUser()
    public boolean loginUser(String loginUser, String loginPass) {
        if (loginUser.equals(this.username) && loginPass.equals(this.password)) {
            loginStatus = true;
        } else {
            loginStatus = false;
        }
        return loginStatus;
    }

    // 6. returnLoginStatus()
    public String returnLoginStatus() {
        if (loginStatus) {
            String[] parts = username.split("_");
            String firstName = parts.length > 0 ? capitalize(parts[0]) : username;
            String lastName  = parts.length > 1 ? capitalize(parts[1]) : "";
            return "Welcome " + firstName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    // helper
    private String capitalize(String input) {
        if (input == null || input.isEmpty()) return input;
        return input.substring(0,1).toUpperCase() + input.substring(1).toLowerCase();
    }
}
    

