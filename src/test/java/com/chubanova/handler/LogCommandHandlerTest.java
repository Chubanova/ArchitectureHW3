package com.chubanova.handler;

import com.chubanova.command.ICommand;
import com.chubanova.command.impl.LogCommand;
import com.chubanova.log.LoggerDelegate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class LogCommandHandlerTest {
    @Mock
    ICommand iCommand;
    @Mock
    Exception e;

    private LogCommandHandler handler;
    Queue<ICommand> queue;

    @BeforeEach
    void init() {
        queue = new LinkedList<>();
        handler = new LogCommandHandler(iCommand, e);
    }

    @Test
    void handle() {
        // Given
        // When
        // Then
        handler.handle(queue);
        assertEquals(1, queue.size());
        assertEquals(LogCommand.class, queue.poll().getClass());
    }
}