package com.geekbrains.java.course.chat;

public class TextHistory{
    private String text;

    public TextHistory() {
        text = "";
    }

    public void add(String str){
        StringBuilder sb = new StringBuilder(text);
        sb.append("\n").append(str);
        text = sb.toString();
    }

    public String getText() {
        return text;
    }
}
