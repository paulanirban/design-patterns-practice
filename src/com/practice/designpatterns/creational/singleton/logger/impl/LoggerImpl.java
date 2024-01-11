package com.practice.designpatterns.creational.singleton.logger.impl;

import com.practice.designpatterns.creational.singleton.logger.Logger;
import org.springframework.boot.logging.LogLevel;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class LoggerImpl implements Logger {
    private static volatile Logger instance;
    private static String loggerPath;
    private static PrintWriter printWriter;
    private static boolean isPrinterClosed = false;

    private LoggerImpl() {}

    @Override
    public void log(LogLevel level, String message) {
        if(isPrinterClosed) {
            throw new IllegalStateException();
        }
        try {
            final String completeMessage = String.format("%s %s %s", new Date(), level.name(), message);
            printWriter.println(completeMessage);
        } catch (Exception e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public void setLogFile(String filePath) {
        try {
            printWriter = new PrintWriter(new FileWriter(filePath,true));
            loggerPath = filePath;
            isPrinterClosed = false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getLogFile() {
        if(loggerPath != null && !loggerPath.isEmpty()) {
            return loggerPath;
        }
        return null;
    }

    @Override
    public void flush() {
        if(printWriter!=null) {
            printWriter.flush();
        }
    }

    @Override
    public void close() {
        if(printWriter!=null) {
            isPrinterClosed = true;
            printWriter.close();
        }
    }

    public static Logger getInstance() {
        if(instance == null) {
            synchronized (LoggerImpl.class) {
                if(instance == null) {
                    instance = new LoggerImpl();
                }
            }
        }
        return instance;
    }

    public static void resetInstance() {
        if(instance != null) {
            instance = null;
        }
    }
}
