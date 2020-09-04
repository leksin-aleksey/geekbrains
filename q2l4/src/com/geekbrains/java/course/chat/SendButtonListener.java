package com.geekbrains.java.course.chat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendButtonListener implements ActionListener {
    private final TextHistory textHistory;
    private final JTextField inputField;
    private final JTextArea outputField;

    public SendButtonListener(Chat chat) {
        this.inputField = chat.getInputField();
        this.outputField = chat.getOutputField();
        this.textHistory = chat.getTextHistory();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textHistory.add(inputField.getText());
        outputField.setText(textHistory.getText());
        inputField.setText("");
    }
}
