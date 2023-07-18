package com.chubanova.command.impl;

import com.chubanova.command.ICommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RetryableCommandTest {
    @Mock
    ICommand iCommand;


    private RetryableCommand r;

    @BeforeEach
    void setUp() {
        r = new RetryableCommand(iCommand,1);
    }

    @Test
    void execute() {
        // Given

        // When

        // Then
        r.execute();
        verify(iCommand, times(1)).execute();
        assertEquals(0, r.attemptsLeft());
    }

}