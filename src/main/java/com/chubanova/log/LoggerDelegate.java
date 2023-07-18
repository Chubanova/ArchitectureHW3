package com.chubanova.log;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicLong;

// For test purpose
@Slf4j
public class LoggerDelegate {

    private AtomicLong callsCount = new AtomicLong();

    public void info(String s) {
        log.info(s);
        callsCount.incrementAndGet();
    }
    public void warning(String s) {
        log.warn(s);
        callsCount.incrementAndGet();
    }
    public void error(String s, Throwable t) {
        log.error(s, t);
        callsCount.incrementAndGet();
    }
    public void debug(String s) {
        log.debug(s);
        callsCount.incrementAndGet();
    }

    public long getCallsCount() {
        return callsCount.get();
    }

}
