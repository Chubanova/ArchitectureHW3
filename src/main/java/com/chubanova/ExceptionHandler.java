package com.chubanova;

import java.lang.reflect.Type;
import java.util.Map;

public class ExceptionHandler {
     Map<Type, Map<Type, ICommand>> store;

    public  ICommand handle(Exception e, ICommand c) {
        Type et = e.getClass();
        Type ct = c.getClass();


        return store.get(ct).get(et);
    }
}
