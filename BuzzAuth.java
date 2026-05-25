/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.buzzapp;

/**
 *
 * @author Smart Axis
 */
import java.util.Scanner;

class BuzzAuth {

    public static boolean credentialsAreCorrect(String username, String password) {
        for (int i = 0; i < BuzzAccount.allUsernames.size(); i++) {
            if (BuzzAccount.allUsernames.get(i).equals(username) &&
                BuzzAccount.allPasswords.get(i).equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static String getSignInStatusMessage(boolean success) {
        if (success) {
            return "Sign in successful!";
        } else {
            return "Incorrect username or password.";
        }
    }

    public static String getFullName(String username) {
        for (int i = 0; i < BuzzAccount.allUsernames.size(); i++) {
            if (BuzzAccount.allUsernames.get(i).equals(username)) {
                return BuzzAccount.allFirstNames.get(i) + " " + BuzzAccount.allSurnames.get(i);
            }
        }
        return "";
    }

    public static void greetUser(String username) {
        String fullName = getFullName(username);
        System.out.println("Welcome back, " + fullName + "!\n");
    }

    public static boolean signInLoop(Scanner sc) {
        System.out.println("\n===== SIGN IN TO BUZZCHAT =====\n");

        String username;
        String password;
        boolean success = false;

        do {
            System.out.print("Username: ");
            username = sc.nextLine();

            System.out.print("Password: ");
            password = sc.nextLine();

            success = credentialsAreCorrect(username, password);
            System.out.println(getSignInStatusMessage(success));

            if (!success) {
                System.out.println("Please try again.\n");
            } else {
                greetUser(username);
            }
        } while (!success);

        return true;
    }
}
