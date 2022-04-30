package com.sparta.gh.userInputs;

import java.util.Scanner;

public class UserInputs {

    public static int getIntInput() {
        int input = 0;

        while (true) {
            try {
                Scanner inp = new Scanner(System.in);
                System.out.println("\nEnter an integer: ");
                input = inp.nextInt();
                return input;
            } catch (Exception e) {
                System.out.println("\nError, please enter an integer.");
                continue;
            }
        }
    }
}
