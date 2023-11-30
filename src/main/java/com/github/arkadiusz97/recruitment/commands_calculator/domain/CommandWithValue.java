package com.github.arkadiusz97.recruitment.commands_calculator.domain;

public class CommandWithValue {
    public Command command;
    public Integer value;

    public CommandWithValue(Command command, Integer value) {
        this.command = command;
        this.value = value;
    }
}
