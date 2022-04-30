package com.sparta.gh.menu;

import com.sparta.gh.calculator.Calculator;

import java.util.Scanner;

public class MenuInstance {
    // Holds the current display
    public static int calculationsMade = 0;
    public static double currentInput = 0;
    public static double currentOperationValue = 0;
    public static double currentEquationResult = 0;
    public static char EqualOperator = '=';
    public static String currentOperator = "";

    public static Calculator calculator = new Calculator();

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
    public static boolean showMainMenu() {
        boolean exitCalc = false;
        if (calculationsMade == 0){
            System.out.println("\n\n\n\n\n\n\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  =-=-=-=-=-=-=-=\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  | Calculator  |\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  =-=-=-=-=-=-=-=");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  |" + "\t\t\t\t|");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  |" + "\t\t\t\t|__");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t   Current Result:" + "|" + MenuInstance.currentInput);
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  =-=-=-=-=-=-=-=" + "\n\n");

            while (true) {
                MenuInstance.currentInput = getCalculatorInput();

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

    public static boolean showOperationMenu() {
        boolean exitCalc = false;
        while(true){
            System.out.println("\n\n\n\n\n\n\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  =-=-=-=-=-=-=-=\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  | Calculator  |\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  =-=-=-=-=-=-=-=");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  |" + "\t\t\t\t|");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  |" + "\t\t\t\t|__");
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t   Current Result:" + "|" + MenuInstance.currentInput + " "
                    + MenuInstance.currentOperator + " ");
            if (MenuInstance.currentOperationValue > 0){
                System.out.print(MenuInstance.currentOperationValue + " " + MenuInstance.EqualOperator + " ");
            }
            if (MenuInstance.currentEquationResult > 0){
                System.out.print(MenuInstance.currentEquationResult);
            }
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  =-=-=-=-=-=-=-=" + "\n\n");

            exitCalc = showOperationTable();

            return exitCalc;
        }
    }


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

    public static boolean showOperationTable() {
        char menuChoice;
        System.out.println("____________________\t____________________\t____________________\t____________________\t\t\t\t____________________\t____________________" +
                "\n|Addition       (A)|\t|Subtraction    (S)|\t|Multiplication (M)|\t|Division       (D)|\t\t\t\t|Clear Display  (C)|\t|Exit           (E)|" +
                "\n--------------------\t--------------------\t--------------------\t--------------------\t\t\t\t--------------------\t--------------------");
        menuChoice = getMenuInput();

        switch (menuChoice){
            case 'A':
                currentOperator = "+";
                currentOperationValue = getCalculatorInput();
                currentEquationResult = calculator.addition(currentInput, currentOperationValue);
                currentInput = currentEquationResult;
                clean();
                calculationsMade++;
                break;
            case 'S':
                currentOperator = "-";
                currentOperationValue = getCalculatorInput();
//                currentEquationResult = calculator.subtraction(currentInput, currentOperationValue);
                break;
            case 'E':
                return true;
        }
        return false;
    }

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
                    case 'C', 'c':
                        return 'C';
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

    public static void clean(){
        currentOperationValue = 0;
        currentOperator = "";
        currentEquationResult = 0;
    }
}

