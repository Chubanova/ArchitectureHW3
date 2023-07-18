package com.chubanova.handler;

import com.chubanova.command.ICommand;
import com.chubanova.command.IRetryable;
import com.chubanova.command.impl.RetryableCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class RetryCommandHandlerTest {
    @Mock
    ICommand iCommand;
    @Mock
    Exception e;

    Queue<ICommand> queue;

    @BeforeEach
    void init() {
        queue = new LinkedList<>();
    }
    @Test
    void handle_first_time() {
        // Given
        ICommand c = () -> {
            // dummy
        };
        RetryCommandHandler handler = new RetryCommandHandler(c, e);

        // When
        // Then
        handler.handle(queue);
        assertEquals(1, queue.size());
        assertEquals(RetryableCommand.class, queue.peek().getClass());
        assertEquals(2, ((IRetryable) queue.peek()).attemptsLeft());
    }


    @Test
    void handle_second_time() {
        // Given
        ICommand c = () -> {
            // dummy
        };
        RetryCommandHandler handler = new RetryCommandHandler(c, e);

        // When
        handler.handle(queue);
        c = queue.poll();
        c.execute();
        handler = new RetryCommandHandler(c, e);

        // Then
        handler.handle(queue);
        assertEquals(1, queue.size());
        assertEquals(RetryableCommand.class, queue.peek().getClass());
        assertEquals(1, ((IRetryable) queue.peek()).attemptsLeft());
    }

}