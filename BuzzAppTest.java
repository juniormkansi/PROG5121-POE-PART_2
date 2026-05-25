/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.buzzapp;

import java.util.Scanner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Smart Axis
 */
public class BuzzAppTest {
    
    public BuzzAppTest() {
    }

    /**
     * Test of main method, of class BuzzApp.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        BuzzApp.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showBanner method, of class BuzzApp.
     */
    @Test
    public void testShowBanner() {
        System.out.println("showBanner");
        BuzzApp.showBanner();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showMainMenu method, of class BuzzApp.
     */
    @Test
    public void testShowMainMenu() {
        System.out.println("showMainMenu");
        BuzzApp.showMainMenu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleMainMenuChoice method, of class BuzzApp.
     */
    @Test
    public void testHandleMainMenuChoice() {
        System.out.println("handleMainMenuChoice");
        String choice = "";
        Scanner sc = null;
        BuzzApp.handleMainMenuChoice(choice, sc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
