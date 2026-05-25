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
import java.util.Random;
import java.util.Scanner;

class BuzzMessenger {

    static ArrayList<String> sentMessageIDs = new ArrayList<>();
    static ArrayList<String> sentMessageHashes = new ArrayList<>();
    static ArrayList<String> sentRecipients = new ArrayList<>();
    static ArrayList<String> sentMessageTexts = new ArrayList<>();
    static int totalMessagesSent = 0;

    private String buzzID;
    private String buzzRecipient;
    private String buzzText;
    private String buzzHash;

    public BuzzMessenger(String recipient, String text) {
        this.buzzRecipient = recipient;
        this.buzzText = text;
        this.buzzID = generateBuzzID();
        this.buzzHash = buildMessageHash();
    }

    public String generateBuzzID() {
        Random rand = new Random();
        String id = "";
        for (int i = 0; i < 10; i++) {
            id = id + rand.nextInt(10);
        }
        return id;
    }

    public boolean checkMessageID() {
        return buzzID.length() <= 10;
    }

    public String checkRecipientCell() {
        if (buzzRecipient.length() <= 12 && buzzRecipient.startsWith("+")) {//10->12
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    public String buildMessageHash() {
        String idStart = buzzID.substring(0, 2);
        int msgNumber = totalMessagesSent;
        String[] words = buzzText.trim().split(" ");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        String hash = idStart + ":" + msgNumber + ":" + firstWord + lastWord;
        return hash.toUpperCase();
    }

    public String handleMessageAction(Scanner sc) {
        System.out.println("\nWhat would you like to do with this message?");
        System.out.println("1. Send Message");
        System.out.println("2. Disregard Message");
        System.out.println("3. Store Message to send later");
        System.out.print("Your choice (1-3): ");

        String action = sc.nextLine();

        if (action.equals("1")) {
            totalMessagesSent++;
            sentMessageIDs.add(buzzID);
            sentMessageHashes.add(buzzHash);
            sentRecipients.add(buzzRecipient);
            sentMessageTexts.add(buzzText);
            return "Message successfully sent.";
        } else if (action.equals("2")) {
            return "Press 0 to delete the message.";
        } else if (action.equals("3")) {
            return "Message successfully stored.";
        } else {
            return "Invalid option selected.";
        }
    }

    public void displayMessageDetails() {
        System.out.println("\n--- Message Details ---");
        System.out.println("Message ID   : " + buzzID);
        System.out.println("Message Hash : " + buzzHash);
        System.out.println("Recipient    : " + buzzRecipient);
        System.out.println("Message      : " + buzzText);
    }

    public static String printMessages() {
        if (sentMessageIDs.size() == 0) {
            return "No messages have been sent yet.";
        }
        String result = "\n===== ALL SENT MESSAGES =====\n";
        for (int i = 0; i < sentMessageIDs.size(); i++) {
            result += "\nMessage ID   : " + sentMessageIDs.get(i);
            result += "\nMessage Hash : " + sentMessageHashes.get(i);
            result += "\nRecipient    : " + sentRecipients.get(i);
            result += "\nMessage      : " + sentMessageTexts.get(i);
            result += "\n-----------------------------";
        }
        return result;
    }

    public static int returnTotalMessages() {
        return totalMessagesSent;
    }

    public static int collectNumberOfMessages(Scanner sc) {
        int num = 0;
        boolean valid = false;
        System.out.print("\nHow many messages would you like to send? ");
        do {
            String input = sc.nextLine();
            boolean isDigit = true;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                    isDigit = false;
                }
            }
            if (isDigit && input.length() > 0) {
                num = Integer.parseInt(input);
                valid = true;
            } else {
                System.out.print("Please enter a valid whole number: ");
            }
        } while (!valid);
        return num;
    }

    public static String collectRecipient(Scanner sc) {
        String recipient;
        do {
            System.out.print("Enter recipient cell number (e.g. +27XXXXXXXXX, max 10 characters): ");
            recipient = sc.nextLine();
            if (!recipient.startsWith("+") || recipient.length() > 12) {//10->12
                System.out.println("Number must start with + and be no more than 10 characters.\n");
            }
        } while (!recipient.startsWith("+") || recipient.length() > 12);//->10-12
        return recipient;
    }

    public static String collectMessageText(Scanner sc) {
        String text;
        do {
            System.out.print("Type your message (max 250 characters): ");
            text = sc.nextLine();
            if (text.length() > 250) {
                int over = text.length() - 250;
                System.out.println("Please enter a message of less than 250 characters.");
                System.out.println("Message exceeds 250 characters by " + over + "; please reduce the size.\n");
            } else {
                System.out.println("Message sent.");
            }
        } while (text.length() > 250);
        return text;
    }

    public static void runMessagingSession(Scanner sc) {
        int numMessages = collectNumberOfMessages(sc);
        for (int i = 0; i < numMessages; i++) {
            System.out.println("\n===== MESSAGE " + (i + 1) + " OF " + numMessages + " =====");
            String recipient = collectRecipient(sc);
            String text = collectMessageText(sc);
            BuzzMessenger buzz = new BuzzMessenger(recipient, text);
            buzz.displayMessageDetails();
            String result = buzz.handleMessageAction(sc);
            System.out.println(result);
        }
        System.out.println(printMessages());
        System.out.println("\nTotal messages sent this session: " + returnTotalMessages());
    }

    public static void openMessagingMenu(Scanner sc) {
        System.out.println("\n**************************************************************************");
        System.out.println("Welcome to BuzzChat Messaging.");
        System.out.println("**************************************************************************");

        String option;
        do {
            System.out.println("\n===== BUZZCHAT MESSAGING MENU =====");
            System.out.println("1. Send Messages");
            System.out.println("2. Show recently sent messages");
            System.out.println("3. Quit");
            System.out.print("\nYour choice (1-3): ");
            option = sc.nextLine();
            System.out.println();

            if (option.equals("1")) {
                runMessagingSession(sc);
            } else if (option.equals("2")) {
                System.out.println(printMessages());
            } else if (option.equals("3")) {
                System.out.println("Goodbye! Thanks for using BuzzChat!");
            } else {
                System.out.println("Invalid choice. Please choose 1, 2 or 3.");
            }
        } while (!option.equals("3"));
    }
}