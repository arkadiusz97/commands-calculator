package com.github.arkadiusz97.recruitment.commands_calculator;

import com.github.arkadiusz97.recruitment.commands_calculator.service.Calculator;

public class Main {

    static Calculator calculator;

    public static void main(String[] args) {
        calculator = new Calculator();
        if(args.length == 0) {
            System.out.println("File name is not provided");
            return;
        }
        String fileName = args[0];
        try {
            int result = calculator.runCalculator(fileName);
            System.out.println("Calculation result: " + result);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}