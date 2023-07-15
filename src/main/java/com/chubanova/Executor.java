package com.chubanova;

import java.util.Queue;

public class Executor {
    Queue<ICommand> q;

    public void run() {

        while (true) {
            var cmd = q.poll();
            try {
                cmd.execute();
            } catch (Exception e) {
//                ExceptionHandler.handle(e, cmd).execute();
            }
        }
    }
}
