package ru.otus.listener.homework;

import java.util.*;
import ru.otus.listener.Listener;
import ru.otus.model.Message;

public class HistoryListener implements Listener, HistoryReader {

    Map<Long, Message> messageMap = new HashMap<>();

    @Override
    public void onUpdated(Message message) {
        messageMap.put(message.getId(), message.clone());
    }

    @Override
    public Optional<Message> findMessageById(long id) {
        return Optional.ofNullable(messageMap.get(id));
    }
}
