package com.chubanova;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@Builder
public class LogCommand implements ICommand{

    ICommand iCommand;
    Exception exception;
    @Override
    public void execute() {
        log.warning("При выполнении команды "+iCommand.getClass()+" произошла ошибка "+exception.getMessage());

    }
}
