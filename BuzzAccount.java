/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.buzzapp;

/**
 *
 * @author Smart Axis
 */
import java.util.ArrayList;
import java.util.Scanner;

class BuzzAccount {

    static ArrayList<String> allUsernames = new ArrayList<>();
    static ArrayList<String> allPasswords = new ArrayList<>();
    static ArrayList<String> allPhoneNumbers = new ArrayList<>();
    static ArrayList<String> allFirstNames = new ArrayList<>();
    static ArrayList<String> allSurnames = new ArrayList<>();

    public static boolean isValidName(String name) {
        if (name.length() == 0) return false;
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isLetter(name.charAt(i))) return false;
        }
        return true;
    }

    public static boolean isValidUsername(String username) {
        return username.length() <= 5 && username.contains("_");
    }

    public static boolean isValidPassword(String password) {
        boolean longEnough = password.length() >= 8;
        boolean hasCapital = password.matches(".*[A-Z].*");
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");
        return longEnough && hasCapital && hasDigit && hasSpecial;
    }

    public static boolean isValidPhone(String phone) {
        return phone.matches("^\\+27\\d{9}$");
    }

    public static boolean usernameAlreadyExists(String username) {
        return allUsernames.contains(username);
    }

    public static String collectFirstName(Scanner sc) {
        String firstName;
        do {
            System.out.print("Enter your first name (letters only): ");
            firstName = sc.nextLine();
            if (!isValidName(firstName)) {
                System.out.println("⚠ Invalid first name. Please use letters only.\n");
            }
        } while (!isValidName(firstName));
        return firstName;
    }

    public static String collectSurname(Scanner sc) {
        String surname;
        do {
            System.out.print("Enter your surname (letters only): ");
            surname = sc.nextLine();
            if (!isValidName(surname)) {
                System.out.println("⚠ Invalid surname. Please use letters only.\n");
            }
        } while (!isValidName(surname));
        return surname;
    }

    public static String collectUsername(Scanner sc) {
        String username;
        do {
            System.out.print("Enter a username (max 5 characters, must include '_'): ");
            username = sc.nextLine();
            if (!isValidUsername(username)) {
                System.out.println("⚠ Username must be 5 characters or less and contain an underscore.\n");
            } else if (usernameAlreadyExists(username)) {
                System.out.println("⚠ That username is already taken. Try another one.\n");
                username = "";
            }
        } while (!isValidUsername(username) || username.equals(""));
        return username;
    }

    public static String collectPassword(Scanner sc) {
        String password;
        do {
            System.out.print("Enter a password (min 8 characters, 1 capital, 1 number, 1 special character): ");
            password = sc.nextLine();
            if (!isValidPassword(password)) {
                System.out.println("⚠ Password does not meet requirements. Please try again.\n");
            }
        } while (!isValidPassword(password));
        return password;
    }

    public static String collectPhone(Scanner sc) {
        String phone;
        do {
            System.out.print("Enter your phone number (+27XXXXXXXXX): ");
            phone = sc.nextLine();
            if (!isValidPhone(phone)) {
                System.out.println("⚠ Phone number must start with +27 and have 9 digits after it.\n");
            }
        } while (!isValidPhone(phone));
        return phone;
    }

    public static String createAccount(Scanner sc) {
        System.out.println("\n===== CREATE YOUR BUZZCHAT ACCOUNT =====\n");
        String firstName = collectFirstName(sc);
        String surname = collectSurname(sc);
        String username = collectUsername(sc);
        String password = collectPassword(sc);
        String phone = collectPhone(sc);

        allFirstNames.add(firstName);
        allSurnames.add(surname);
        allUsernames.add(username);
        allPasswords.add(password);
        allPhoneNumbers.add(phone);

        return "✅ Account created successfully! Welcome to BuzzChat, " + firstName + "!";
    }
}
