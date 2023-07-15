package com.chubanova;

public class RepeatCommand implements ICommand{
    ICommand iCommand;
    @Override
    public void execute() {
        iCommand.execute();

    }
}
