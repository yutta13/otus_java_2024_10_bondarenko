package ru.otus.processor.homework;

import java.time.LocalDateTime;

public interface SystemDateTimeProvider {
    LocalDateTime getDateTime();
}
