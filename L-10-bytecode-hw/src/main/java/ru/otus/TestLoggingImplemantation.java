package ru.otus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLoggingImplemantation implements TestLoggingInterface {
    private static final Logger logger = LoggerFactory.getLogger(TestLoggingImplemantation.class);

    @Override
    public void calculation(int param) {
        logger.info("method: calculation, param: {}", param);
    }

    @Override
    @Log
    public void calculation(int param, int param2) {
        logger.info("method: calculation, params: {}, {} ", param, param2);
    }

    @Override
    @Log
    public void calculation(int param, int param2, String param3) {
        logger.info("method: calculation, params: {}, {}, {}", param, param2, param3);
    }

    @Override
    @Log
    public void print(String param) {
        logger.info("method: print, param: {}", param);
    }
}
