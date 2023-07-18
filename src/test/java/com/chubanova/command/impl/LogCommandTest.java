package com.chubanova.command.impl;

import com.chubanova.command.ICommand;
import com.chubanova.log.LoggerDelegate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LogCommandTest {

    @Mock
    LoggerDelegate loggerDelegate;
    @Mock
    ICommand command;
    @Mock
    Exception e;
    @Captor
    ArgumentCaptor<String> messageCaptor;
    @Captor
    ArgumentCaptor<Exception> exceptionCaptor;

    private LogCommand l;

    @BeforeEach
    public void init() {
        l = new LogCommand(command, e, loggerDelegate);
    }

    @Test
    public void testExecute() {
        // Given
        String exceptionMessage = "Ошибка!";
        // When
        when(e.getMessage()).thenReturn(exceptionMessage);
        // Then
        l.execute();

        verify(loggerDelegate).error(messageCaptor.capture(), exceptionCaptor.capture());
        assertEquals(e.getMessage(), exceptionCaptor.getValue().getMessage());
        assertTrue(messageCaptor.getValue().contains(command.getClass().toString()));
    }
}