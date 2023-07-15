package com.chubanova;


import java.util.Queue;
public class LogCommandHandler  extends ExceptionHandler{
    public LogCommandHandler(Queue<ICommand> queue) {
        this.queue = queue;
    }

    Queue<ICommand> queue;

    @Override
    public ICommand handle(Exception e, ICommand c) {
        LogCommand com =  LogCommand.builder().iCommand(c).exception(e).build();
        queue.add(com);
        return super.handle(e, c);

    }
}
