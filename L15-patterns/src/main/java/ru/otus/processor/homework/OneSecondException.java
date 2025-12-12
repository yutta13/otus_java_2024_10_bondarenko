package ru.otus.processor.homework;

import ru.otus.model.Message;
import ru.otus.processor.Processor;

public class OneSecondException implements Processor {

    private final SystemDateTimeProvider systemDateTimeProvider;

    public OneSecondException(SystemDateTimeProvider systemDateTimeProvider) {
        this.systemDateTimeProvider = systemDateTimeProvider;
    }

    @Override
    public Message process(Message message) {
        int second = systemDateTimeProvider.getDateTime().getSecond();

        if (second % 2 == 0) {
            throw new RuntimeException("Get exception for second: 2");
        }
        return message;
    }
}
