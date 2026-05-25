/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.buzzapp;

/**
 *
 * @author Smart Axis
 */
import java.util.Scanner;

public class BuzzApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        showBanner();

        String choice;
        do {
            showMainMenu();
            choice = sc.nextLine();
            System.out.println("\n_________________________\n");
            handleMainMenuChoice(choice, sc);
        } while (!choice.equals("3"));
    }

    public static void showBanner() {
        System.out.println("**************************************************************************");
        System.out.println("WELCOME TO BUZZCHAT");
        System.out.println("**************************************************************************\n");
    }

    public static void showMainMenu() {
        System.out.println("===== BUZZCHAT MAIN MENU =====");
        System.out.println("1. Create a BuzzChat account");
        System.out.println("2. Sign in to BuzzChat");
        System.out.println("3. Exit BuzzChat");
        System.out.print("\nYour choice (1-3): ");
    }

    public static void handleMainMenuChoice(String choice, Scanner sc) {
        if (choice.equals("1")) {
            String outcome = BuzzAccount.createAccount(sc);
            System.out.println("\n" + outcome + "\n");
        } else if (choice.equals("2")) {
            boolean signedIn = BuzzAuth.signInLoop(sc);
            if (signedIn) {
                BuzzMessenger.openMessagingMenu(sc);
            }
        } else if (choice.equals("3")) {
            System.out.println("Goodbye! Thanks for using BuzzChat!");
        } else {
            System.out.println("Invalid choice. Please choose 1, 2 or 3.");
        }
    }
}