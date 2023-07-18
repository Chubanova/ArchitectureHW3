package com.chubanova.command.impl;

import com.chubanova.command.ICommand;
import com.chubanova.log.LoggerDelegate;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LogCommand implements ICommand {

    private final ICommand iCommand;
    private final Exception exception;
    private final LoggerDelegate log;

    @Override
    public void execute() {
        log.error("При выполнении команды " + iCommand.getClass() + " произошла ошибка", exception);
    }
}
