package com.chubanova.handler;

import com.chubanova.command.ICommand;
import com.chubanova.command.impl.LogCommand;
import com.chubanova.log.LoggerDelegate;
import lombok.RequiredArgsConstructor;

import java.util.Queue;

@RequiredArgsConstructor
public class LogCommandHandler implements ExceptionHandler {

    private final ICommand c;
    private final Exception e;
    private final LoggerDelegate loggerDelegate = new LoggerDelegate();

    @Override
    public void handle(Queue<ICommand> queue) {
        LogCommand com = new LogCommand(c, e, loggerDelegate);
        queue.add(com);
    }
}
