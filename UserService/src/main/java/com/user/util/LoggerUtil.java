package com.user.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {

    private static volatile Logger logger;

    private LoggerUtil() {
    }

    public static Logger getLogger(Class<?> clazz) {
        if (logger == null) {
            synchronized (LoggerUtil.class) {
                if (logger == null) {
                    logger = LoggerFactory.getLogger(clazz);
                }
            }
        }
        return logger;
    }
}
