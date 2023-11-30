package com.github.arkadiusz97.recruitment.commands_calculator.service;

import com.github.arkadiusz97.recruitment.commands_calculator.domain.Command;
import com.github.arkadiusz97.recruitment.commands_calculator.domain.CommandWithValue;
import com.github.arkadiusz97.recruitment.commands_calculator.exception.CalculatorException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class FileParser {
    public LinkedList<CommandWithValue> parseFile(String fileName) throws FileNotFoundException, CalculatorException {
        LinkedList<CommandWithValue> commands = new LinkedList<>();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                String lineFromFile = scanner.nextLine();
                commands.add(parseCommand(lineFromFile));
            }

            scanner.close();
        } catch (FileNotFoundException exception) {
            throw exception;
        } catch (CalculatorException exception) {
            throw exception;
        }
        return commands;
    }

    private CommandWithValue parseCommand(String commandWithArgument) throws CalculatorException {
        String[] tokens = commandWithArgument.split(" ");
        if(tokens.length > 2) {
            throw new CalculatorException("Invalid number of arguments in line: " + commandWithArgument);
        }
        Command command = Command.valueOf(tokens[0]);
        Integer value = Integer.valueOf(tokens[1]);
        return new CommandWithValue(command, value);
    }

}
