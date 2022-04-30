package com.sparta.gh;

import com.sparta.gh.calculator.Calculator;
import com.sparta.gh.userInputs.UserInputs;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuInstance {
    // Holds the inputted integers for the resulting calculation
    private static ArrayList<Integer> ints = new ArrayList<>();

    // A part of the singleton implementation to ensure only one menu exists at any given time
    // Also ensures only a single thread can access the menu at any one time - further ensures that the object
    // is constructed fully in memory before another thread can access it (half initialised), to ensure the object
    // is correctly initialised
    private static volatile MenuInstance singleInstance = null;

    // A private constructor - as is custom when implementing a singleton class
    private MenuInstance() {

    }

    // A static method to retrieve the single instance of the menu
    // Here lies the logic to ensure the menu is as efficient as possible and accessible by a
    // single thread at a time only
    public static MenuInstance getInstance() {
        MenuInstance result = singleInstance;
        if (result == null) {
            synchronized (MenuInstance.class) {
                if (singleInstance == null) {
                    singleInstance = new MenuInstance();
                }
            }
        }
        return result;
    }

    // A static method which returns the aesthetic menu for the console, in order to make use of the
    // calculator itself
    public static boolean showMenu() {
        System.out.println("\n\n\n\n\n\n\n\n  =-=-=-=-=-=-=-=\n  | Calculator  |\n  =-=-=-=-=-=-=-=");
        System.out.println("____________________\n|Addition       (1)|\n--------------------");
        System.out.println("____________________\n|Subtraction    (2)|\n--------------------");
        System.out.println("____________________\n|Multiplication (3)|\n--------------------");
        System.out.println("____________________\n|Division       (4)|\n--------------------");
        System.out.println("\n____________________\n|Exit           (0)|\n--------------------");

        // stores the menu choice inputted by the user
        int menuChoice = getMenuInput();

        // First condition evaluates whether to terminate the program
        if (menuChoice == 0) {
            return true;
        } else { // Switch operator which evaluates which operation the user has selected to use
            switch (menuChoice) {
                case 1:
                    while (true) { // Logic and implementation of the 'Addition' operation
                        // An array list of integers to hold the inputs of the user
                        ArrayList<Integer> ints = new ArrayList<>();

                        while (true) {
                            // Adds the users inputs for the calculation to the arraylist
                            ints.add(UserInputs.getIntInput());

                            // Evaluates whether the user has already entered two integers into the equation
                            if (ints.size() > 1) {
                                System.out.println("Current input:");
                                // Prints the current inputs to console
                                for (int i = 0; i < ints.size(); i++) {
                                    if (i == ints.size()) {
                                        System.out.print(ints.get(i));
                                    } else {
                                        System.out.print(ints.get(i) + " + ");
                                        continue;
                                    }
                                }
                                // Asks the user if the equation is ready for evaluation or not
                                System.out.println("\nEnter '1' to add another integer or any other key to finish and calculate: ");
                                String choice = "";
                                Scanner inp = new Scanner(System.in);
                                choice = inp.next();
                                if (choice.charAt(0) == '1') {
                                    continue;
                                } else {
                                    MenuInstance.ints = ints;
                                    break;
                                }
                                // Else statement runs when the user is yet to input the first integer of the
                                // equation
                            } else {
                                System.out.println("\nCurrent input: ");
                                for (int i = 0; i < ints.size(); i++) {
                                    System.out.print(' ');
                                    if (i == ints.size()) {
                                        System.out.print(ints.get(i));
                                    } else {
                                        System.out.print(ints.get(i) + " + ");
                                        continue;
                                    }
                                }
                                continue;
                            }
                        }
                        Calculator calculator = new Calculator();
                        // Calls the method that calculates the evaluation of the users inputs
                        int result = calculator.addition(ints);

                        // Prints the answer... obviously
                        System.out.println("\n\nAnswer:");
                        for (int i = 0; i < ints.size(); i++){
                            if (i == ints.size() - 1){
                                System.out.print(ints.get(i) + " = " + result);
                            } else{
                                System.out.print(ints.get(i) + " + ");
                            }
                        }
                        System.out.println("\n");

                        // Offers the user the opportunity to evaluate a new equation or return to the main menu
                        String enter = "";
                        System.out.println("\nEnter '1' to start over, or enter any character to return to the main menu: ");
                        Scanner inp = new Scanner(System.in);
                        enter = inp.next();
                        if (enter.charAt(0) == '1') {
                            continue;
                        } else {
                            break;
                        }
                    }
                    break;
                case 2:
                    while (true) { // Logic and implementation of the 'Subtraction' operation
                        // An array list of integers to hold the inputs of the user
                        ArrayList<Integer> ints = new ArrayList<>();

                        while (true) {
                            // Adds the users inputs for the calculation to the arraylist
                            ints.add(UserInputs.getIntInput());

                            // Evaluates whether the user has already entered two integers into the equation
                            if (ints.size() > 1) {
                                System.out.println("Current input:");
                                // Prints the current inputs to console
                                for (int i = 0; i < ints.size(); i++) {
                                    if (i == ints.size()) {
                                        System.out.print(ints.get(i));
                                    } else {
                                        System.out.print(ints.get(i) + " - ");
                                        continue;
                                    }
                                }
                                // Asks the user if the equation is ready for evaluation or not
                                System.out.println("\nEnter '1' to input another integer or any other key to finish and calculate: ");
                                String choice = "";
                                Scanner inp = new Scanner(System.in);
                                choice = inp.next();
                                if (choice.charAt(0) == '1') {
                                    continue;
                                } else {
                                    MenuInstance.ints = ints;
                                    break;
                                }
                                // Else statement runs when the user is yet to input the first integer of the
                                // equation
                            } else {
                                System.out.println("\nCurrent input: ");
                                for (int i = 0; i < ints.size(); i++) {
                                    System.out.print(' ');
                                    if (i == ints.size()) {
                                        System.out.print(ints.get(i));
                                    } else {
                                        System.out.print(ints.get(i) + " - ");
                                        continue;
                                    }
                                }
                                continue;
                            }
                        }
                        Calculator calculator = new Calculator();
                        // Calls the method that calculates the evaluation of the users inputs
                        int result = calculator.subtraction(ints);

                        // Prints the answer
                        System.out.println("\n\nAnswer:");
                        for (int i = 0; i < ints.size(); i++){
                            if (i == ints.size() - 1){
                                System.out.print(ints.get(i) + " = " + result);
                            } else{
                                System.out.print(ints.get(i) + " - ");
                            }
                        }
                        System.out.println("\n");

                        // Offers the user the opportunity to evaluate a new equation or return to the main menu
                        String enter = "";
                        System.out.println("\nEnter '1' to start over, or enter any character to return to the main menu: ");
                        Scanner inp = new Scanner(System.in);
                        enter = inp.next();
                        if (enter.charAt(0) == '1') {
                            continue;
                        } else {
                            break;
                        }
                    }
                    break;
                case 3:
            }
            return false;
        }
    }

    public static int getMenuInput() {
        int it = 0;
        int choice = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("\nEnter a menu input: ");

        while (true) {
            if (it > 0) {
                System.out.println("\nInvalid input. Please try again: ");
            }
            choice = input.nextInt();
            return choice;
        }
    }
}