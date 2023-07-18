package com.chubanova;

import com.chubanova.command.ICommand;
import com.chubanova.handler.ExceptionHandler;
import com.chubanova.handler.ExceptionHandlerFactory;
import com.chubanova.log.LoggerDelegate;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.Queue;

@RequiredArgsConstructor
public class Executor {

    private final Queue<ICommand> q;

    public void run() {
        while (!q.isEmpty()) {
            var cmd = q.poll();
            try {
                cmd.execute();
            } catch (Exception e) {
                ExceptionHandlerFactory.getFor(cmd, e).handle(q);
            }
        }
    }

    public void push(ICommand c) {
        q.add(c);
    }
}
