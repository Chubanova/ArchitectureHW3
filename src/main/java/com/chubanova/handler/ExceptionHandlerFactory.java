package com.chubanova.handler;

import com.chubanova.command.ICommand;
import com.chubanova.command.IRetryable;

public class ExceptionHandlerFactory {

    public static ExceptionHandler getFor(ICommand c, Exception e) {
        if (!(c instanceof IRetryable) || ((IRetryable) c).attemptsLeft() > 0) {
            return new RetryCommandHandler(c, e);
        } else {
            return new LogCommandHandler(c, e);
        }
    }

}
