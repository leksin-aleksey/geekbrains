package com.geekbrains.java.course.chat.objects;

import com.sun.istack.internal.NotNull;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
    private @NotNull Date date;
    private @NotNull String messageText;

    public Message(Date date, String messageText) {
        this.date = date;
        this.messageText = messageText;
    }

    @Override
    public String toString() {
        return messageText;
    }
}
