package com.chubanova.command.impl;

import com.chubanova.command.ICommand;
import com.chubanova.command.IRetryable;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RetryableCommand implements ICommand, IRetryable {

    private final ICommand iCommand;
    private int attemptsLeft;


    @Override
    public void execute() {
        if (attemptsLeft <= 0) {
            throw new IllegalStateException("No attempts left");
        }
        attemptsLeft--;
        iCommand.execute();
    }

    @Override
    public int attemptsLeft() {
        return attemptsLeft;
    }
}
