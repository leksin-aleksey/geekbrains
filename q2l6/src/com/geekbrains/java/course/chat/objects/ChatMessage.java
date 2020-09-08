package com.geekbrains.java.course.chat.objects;

import com.sun.istack.internal.NotNull;
import java.util.Date;

public class ChatMessage {
    private Date date;
    private @NotNull String messageText;

    public ChatMessage(Date date, String messageText) {
        this.date = date;
        this.messageText = messageText;
    }

    @Override
    public String toString() {
        return date + ":\t\t\t" + messageText;
    }
}
