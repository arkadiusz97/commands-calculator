package com.github.arkadiusz97.recruitment.commands_calculator.service;

import com.github.arkadiusz97.recruitment.commands_calculator.domain.Command;
import com.github.arkadiusz97.recruitment.commands_calculator.domain.CommandWithValue;
import com.github.arkadiusz97.recruitment.commands_calculator.exception.CalculatorException;

import java.io.FileNotFoundException;
import java.util.LinkedList;

public class Calculator {
    private LinkedList<CommandWithValue> commands;
    private FileParser fileParser;

    public Calculator() {
        commands = new LinkedList<CommandWithValue>();
        fileParser = new FileParser();
    }
    public Integer runCalculator(String fileName) throws FileNotFoundException, CalculatorException {
        commands = fileParser.parseFile(fileName);
        for (int i = 0; i < commands.size(); i++) {
            CommandWithValue command = commands.get(i);
        }
        Integer result = 0;
        try {
            result = calculate();
        } catch (CalculatorException exception) {
            throw exception;
        }
        return result;
    }

    private Integer calculate() throws CalculatorException {
        if(commands.getLast().command != Command.apply) {
            throw new CalculatorException("The last command is not apply");
        }
        Integer result = commands.getLast().value;
        for(CommandWithValue command : commands) {
            result = attachCommandToResult(command, result);
        }
        return result;
    }
    private Integer attachCommandToResult(CommandWithValue command, Integer currentResult) {
        switch (command.command) {
            case add:
                return currentResult + command.value;
            case multiply:
                return currentResult * command.value;
            default:
                return currentResult;
        }
    }
}
