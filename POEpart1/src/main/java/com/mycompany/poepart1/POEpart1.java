/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poepart1;
import java.util.Scanner;
/**
 *
 * @author RC_Student_lab
 */


public class POEpart1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Collect registration details
        System.out.print("Enter username: ");
        String username = sc.nextLine().trim();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        System.out.print("Enter South African cell phone number: ");
        String cell = sc.nextLine().trim();

        // Create Login object
        Login user = new Login(username, password, cell);

        // Register
        System.out.println(user.registerUser());

        // Login
        System.out.println("\n--- LOGIN ---");
        System.out.print("Re-enter username: ");
        String loginUser = sc.nextLine().trim();

        System.out.print("Re-enter password: ");
        String loginPass = sc.nextLine();

        user.loginUser(loginUser, loginPass);
        System.out.println(user.returnLoginStatus());

        sc.close();
    }
}

