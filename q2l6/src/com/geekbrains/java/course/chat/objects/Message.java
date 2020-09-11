package com.geekbrains.java.course.chat.objects;


import com.sun.istack.internal.NotNull;
import java.util.Date;

public class Message {
    private @NotNull Date date;
    private @NotNull String messageText;

    public Message(Date date, String messageText) {
        this.date = date;
        this.messageText = messageText;
    }

    public Date getDate() {
        return date;
    }

    public String getMessageText() {
        return messageText;
    }

    @Override
    public String toString() {
        return messageText;
    }
}
