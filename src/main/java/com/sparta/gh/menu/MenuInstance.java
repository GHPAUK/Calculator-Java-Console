package com.sparta.gh.menu;

import com.sparta.gh.calculator.Calculator;

import java.util.Scanner;

public class MenuInstance {
    // Counts the calculations made in the instance, used to control what menu is displayed
    public static int calculationsMade = 0;
    // Tracks the previous input
    public static double previousInput = 0;
    // Tracks current input
    public static double currentInput = 0;
    // Tracks the value entered which will be used to complete the chosen operation
    public static double currentOperationValue = 0;
    // Tracks the evaluated result of the chosen equation
    public static double currentEquationResult = 0;
    // The equals sign for aesthetics
    public static char EqualOperator = '=';
    // Tracks the current operator for the chosen operator for aesthetics
    public static String currentOperator = "";

    // Creates an instance of the calculator to conduct operations
    public static Calculator calculator = new Calculator();

    // A part of the singleton implementation to ensure only one menu exists at any given time
    // Also ensures only a single thread can access the menu at any one time - further ensures that the object
    // is constructed fully in memory before another thread can access it (while it is half initialised)
    private static volatile MenuInstance singleInstance = null;

    // A private constructor - as is custom when implementing a singleton class
    private MenuInstance() {}

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
    public static boolean showMainMenu() {
        boolean exitCalc = false;
        // Checks if a previous calculation has been made - if so, displays the alternative menu
        if (calculationsMade == 0){
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  =-=-=-=-=-=-=-=" +
                    "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  | Calculator  |\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  =-=-=-=-=-=-=-=");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  |" + "*-*-*-*-*-*-*|");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  |" + "*-*-*-*-*-*-*|");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  |" + "*-*-*-*-*-*-*|");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  |" + "*-*-*-*-*-*-*|");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  |" + "*-*-*-*-*-*-*|");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  =-=-=-=-=-=-=-=");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t   Current Result:" + "|" + MenuInstance.previousInput);

            // Prompts the user for the initial number input
            while (true) {
                MenuInstance.previousInput = getCalculatorInput();
                currentInput = previousInput;
                System.out.println("Enter (1) to continue or (0) to clear and re-enter input: ");
                int choice = 0;

                Scanner inp = new Scanner(System.in);
                choice = inp.nextInt();

                if (choice == 1) {
                    break;
                } else {
                    continue;
                }
            }
            exitCalc = showOperationMenu();
        } else {
         exitCalc = showOperationMenu();
        }
        return exitCalc;
    }

    // The alternative menu for when calculations have already been made
    public static boolean showOperationMenu() {
        boolean exitCalc = false;
        while(true){
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  =-=-=-=-=-=-=-=" +
                    "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  | Calculator  |\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  =-=-=-=-=-=-=-=");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  |" + "*-*-*-*-*-*-*|");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  |" + "*-*-*-*-*-*-*|");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  |" + "*-*-*-*-*-*-*|");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  |" + "*-*-*-*-*-*-*|");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  |" + "*-*-*-*-*-*-*|");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  =-=-=-=-=-=-=-=");

            // Checks if an equation is under construction or evaluated - if so, prints that information to the console
            if (currentOperationValue != 0 ){
                System.out.print("\n\t\t\t\t\t\t\t\t\t\t\tPrevious Equation:" + "|");
                System.out.print(MenuInstance.previousInput + " "
                        + MenuInstance.currentOperator + " ");
                if (MenuInstance.currentOperationValue != 0){
                    System.out.print(MenuInstance.currentOperationValue + " " + MenuInstance.EqualOperator + " ");
                }
                if (MenuInstance.currentEquationResult != 0){
                    System.out.print(MenuInstance.currentEquationResult);
                }
                System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t===============================================");
            }
            System.out.println("\t\t\t\t\t\t\t\t\t\t\tCurrent  Input   :" + "|" + MenuInstance.currentInput);
            System.out.println("\n\n");

            // Offers the menu options to the user to use the calculator - exit calc tracks whether the user
            // has decided to exit the program
            exitCalc = showOperationTable();

            // If true, program terminates
            return exitCalc;
        }
    }


    // Asks the user for a number
    public static double getCalculatorInput() {
        int it = 0;
        double choice = 0;

        while (true) {
            try {
                System.out.println("\nEnter a number: ");
                Scanner inp = new Scanner(System.in);
                choice = inp.nextDouble();
                return choice;
            } catch (Exception e) {
                System.out.println("\nInvalid input. Please try again: ");
                continue;
            }
        }
    }

    // Shows menu options and prompts user for a decision
    public static boolean showOperationTable() {
        char menuChoice;
        System.out.println("____________________\t____________________\t____________________\t____________________\t\t\t\t____________________\t____________________" +
                "\n|Addition       (A)|\t|Subtraction    (S)|\t|Multiplication (M)|\t|Division       (D)|\t\t\t\t|Reset          (R)|\t|Exit           (E)|" +
                "\n--------------------\t--------------------\t--------------------\t--------------------\t\t\t\t--------------------\t--------------------");
        menuChoice = getMenuInput();
        clean();

        // Evaluates the users decision and executes the requested operation
        switch (menuChoice){
            case 'A':
                currentOperator = "+";
                currentOperationValue = getCalculatorInput();
                currentEquationResult = calculator.addition(currentInput, currentOperationValue);
                if (calculationsMade > 0){
                    if (calculationsMade > calculationsMade - 1){
                        previousInput = currentInput;
                    }
                }
                currentInput = currentEquationResult;
                calculationsMade++;
                break;
            case 'S':
                currentOperator = "-";
                currentOperationValue = getCalculatorInput();
                currentEquationResult = calculator.subtraction(currentInput, currentOperationValue);
                if (calculationsMade > 0){
                    if (calculationsMade > calculationsMade - 1){
                        previousInput = currentInput;
                    }
                }
                currentInput = currentEquationResult;
                calculationsMade++;
                break;
            case 'M':
                currentOperator = "*";
                currentOperationValue = getCalculatorInput();
                currentEquationResult = calculator.multiplication(currentInput, currentOperationValue);
                if (calculationsMade > 0){
                    if (calculationsMade > calculationsMade - 1){
                        previousInput = currentInput;
                    }
                }
                currentInput = currentEquationResult;
                calculationsMade++;
                break;
            case 'D':
                currentOperator = "/";
                currentOperationValue = getCalculatorInput();
                currentEquationResult = calculator.division(currentInput, currentOperationValue);
                if (calculationsMade > 0){
                    if (calculationsMade > calculationsMade - 1){
                        previousInput = currentInput;
                    }
                }
                currentInput = currentEquationResult;
                calculationsMade++;
                break;
            case 'R':
                currentInput = 0;
                previousInput = 0;
                calculationsMade = 0;
                clean();
                break;
            case 'E':
                return true;
        }
        return false;
    }

    // Handles the user's menu choice
    public static char getMenuInput() {
        String choice = "";

        while (true) {
            try {
                System.out.println("\nSelect a menu item: ");
                Scanner inp = new Scanner(System.in);
                choice = inp.next();

                switch (choice.charAt(0)) {
                    case 'A', 'a':
                        return 'A';
                    case 'S', 's':
                        return 'S';
                    case 'M', 'm':
                        return 'M';
                    case 'D', 'd':
                        return 'D';
                    case 'R', 'r':
                        return 'R';
                    case 'E', 'e':
                        return 'E';
                    default:
                        continue;
                }
            } catch (Exception e) {
                System.out.println("\nInvalid input. Please try again: ");
                continue;
            }
        }
    }

    // Cleans up variables that are needed to be reset
    public static void clean(){
        currentOperationValue = 0;
        currentOperator = "";
        currentEquationResult = 0;
    }
}

