package com.chubanova.handler;

import com.chubanova.command.ICommand;
import com.chubanova.command.IRetryable;
import com.chubanova.command.impl.RetryableCommand;
import com.chubanova.config.RetryConfiguration;
import lombok.RequiredArgsConstructor;

import java.util.Queue;

@RequiredArgsConstructor
public class RetryCommandHandler implements ExceptionHandler {

    private final ICommand c;
    private final Exception e;

    @Override
    public void handle(Queue<ICommand> queue) {
        ICommand command = c;
        if (!(c instanceof IRetryable)) {
            command = new RetryableCommand(c, RetryConfiguration.retriesCount);
        }
        queue.add(command);
    }
}
