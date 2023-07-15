package com.chubanova;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertTrue;

public class LogExceptionTest {
    Queue<ICommand> queue;
    LogCommandHandler logCommandHandler;
    LogCommand logCommand;
    @Test
    public void dummy() {
        queue = new LinkedList<>();
        logCommandHandler = new LogCommandHandler(queue);
        logCommand= new LogCommand();
        assertTrue(true);
    }
}
