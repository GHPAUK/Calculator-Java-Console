package com.sparta.gh.runner;

import com.sparta.gh.menu.MenuInstance;

public class Runner {

    public static void main(String[] args) {
        boolean exitCalc = false;

        while (!exitCalc) {
            MenuInstance menu = MenuInstance.getInstance();
            if (MenuInstance.calculationsMade == 0) {
                exitCalc = menu.showMainMenu();
            } else {
                exitCalc = menu.showOperationMenu();
            }

            if (exitCalc == true) {
                break;
            } else {
                continue;
            }
        }

    }
}
