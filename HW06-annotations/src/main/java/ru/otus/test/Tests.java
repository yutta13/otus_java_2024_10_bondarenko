package ru.otus.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.otus.annotations.*;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);

    @Before
    public void beforeTestExecute1() {
        logger.info("BeforeTestExecute1");
    }

    @Before
    public void beforeTestExecute2() {
        logger.info("BeforeTestExecute2");
    }

    @Test
    public void successfulTest1() {
        logger.info("Test1: this successfulTest1");
    }

    @Test
    public void failedTest2() {
        logger.info("Test2: this failedTest2");
        throw new AssertionError("Failed to perform failedTest2");
    }

    @Test
    public void successfulTest3() {
        logger.info("Test3: this successfulTest3");
    }

    @After
    public void afterTestExecute() {
        logger.info("afterTestExecute");
    }
}
