package com.chubanova;

import com.chubanova.command.ICommand;
import com.chubanova.command.impl.LogCommand;
import com.chubanova.command.impl.RetryableCommand;
import com.chubanova.config.RetryConfiguration;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExecutorTest {

    Queue<ICommand> queue = spy(new LinkedList<>());
    Executor executor = new Executor(queue);

    @Test
    void retry_one_time_and_log() {
        // Given
        RetryConfiguration.retriesCount = 1;
        ICommand c = mock(ICommand.class);
        // When
        doThrow(new RuntimeException()).when(c).execute();
        doCallRealMethod().when(queue).add(any());
        doCallRealMethod().when(queue).isEmpty();
        doCallRealMethod().when(queue).poll();

        // Then
        executor.push(c);
        executor.run();
        verify(c, times(2)).execute();
        verify(queue, times(1)).add(any(RetryableCommand.class));
        verify(queue, times(1)).add(any(LogCommand.class));
    }

    @Test
    void retry_two_times_and_log() {
        // Given
        RetryConfiguration.retriesCount = 2;
        ICommand c = mock(ICommand.class);
        // When
        doThrow(new RuntimeException()).when(c).execute();
        doCallRealMethod().when(queue).add(any());
        doCallRealMethod().when(queue).isEmpty();
        doCallRealMethod().when(queue).poll();
        // Then
        executor.push(c);
        executor.run();
        verify(c, times(3)).execute();
        verify(queue, times(2)).add(any(RetryableCommand.class));
        verify(queue, times(1)).add(any(LogCommand.class));
    }
}