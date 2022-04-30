package com.sparta.gh.runner;

import com.sparta.gh.MenuInstance;
import com.sparta.gh.calculator.Calculator;

public class Runner {

    public static void main(String[] args) {
        boolean exitCalc = false;

        while(!exitCalc){
            MenuInstance menu = MenuInstance.getInstance();
            exitCalc = menu.showMenu();

            if (exitCalc == true){
                break;
            } else{
                continue;
            }
        }

    }
}
