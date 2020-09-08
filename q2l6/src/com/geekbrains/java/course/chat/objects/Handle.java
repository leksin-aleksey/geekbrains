package com.geekbrains.java.course.chat.objects;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface Handle {
    void handleMessages() throws IOException;
}
