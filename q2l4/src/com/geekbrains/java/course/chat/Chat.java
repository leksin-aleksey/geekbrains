package com.geekbrains.java.course.chat;

import javax.swing.*;
import java.awt.*;

public class Chat extends JFrame {
    private TextHistory textHistory = new TextHistory();
    private final JTextField inputField = new JTextField();
    private final JTextArea outputField = new JTextArea();

    private final JButton sendButton = new JButton("Send");

    public Chat() throws HeadlessException {
        setTitle("Chat v0.1");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getRootPane().setDefaultButton(sendButton);
        setBounds(new Rectangle(0, 0, 300, 500));

        setLayout(new BorderLayout());

        setChatTop();

        setChatBottom();

        setVisible(true);
    }

    private void setChatTop(){
        outputField.setEditable(false);
        outputField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        outputField.setBackground(new Color(200, 250, 200));
        add(outputField, BorderLayout.CENTER);
    }

    private void setChatBottom(){
        JPanel bottom = new JPanel();
        bottom.setLayout(new BorderLayout());

        inputField.setEditable(true);
        bottom.add(inputField, BorderLayout.CENTER);

        sendButton.addActionListener(new SendButtonListener(this));
        bottom.add(sendButton, BorderLayout.EAST);

        add(bottom, BorderLayout.SOUTH);
    }

    public TextHistory getTextHistory() {
        return textHistory;
    }

    public JTextField getInputField() {
        return inputField;
    }

    public JTextArea getOutputField() {
        return outputField;
    }

    public JButton getSendButton() {
        return sendButton;
    }
}
