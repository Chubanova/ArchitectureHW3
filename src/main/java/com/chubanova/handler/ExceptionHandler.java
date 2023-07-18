package com.chubanova.handler;

import com.chubanova.command.ICommand;

import java.util.Queue;

public interface ExceptionHandler {
    void handle(Queue<ICommand> q);

}
