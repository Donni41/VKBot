package ru.donni.vkbot.service;

/**
 * Sender service that allows to send messages.
 * @param <T> is a message data transfer object
 */
public interface SenderInterface<T> {
    void send(T message);
}
