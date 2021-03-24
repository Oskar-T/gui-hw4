package com.company;

import javax.swing.*;
import java.awt.BorderLayout;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements DocumentListener
{
    public GUI (Application application)
    {
        super ("Complex event demo");
        this.application = application;
        setSize (400, 300);


        Obj obj = new Obj() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
                application.hasFocus = true;
                showFocus();
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                application.hasFocus = false;
                showFocus();
            }
        };
        addWindowFocusListener (obj);

        menuBar = new JMenuBar ();
        JMenu fileMenu = new JMenu ("File");
        JMenuItem quitItem = new JMenuItem ("Quit");
        quitItem.addActionListener ((ActionEvent e) ->
                System.exit (0));
        fileMenu.add (quitItem);
        menuBar.add (fileMenu);
        setJMenuBar (menuBar);


        textField = new JTextField (10);
        add (textField, BorderLayout.CENTER);

        textField.getDocument().addDocumentListener(this);
        focusLabel = new JLabel ();
        showFocus ();
        add (focusLabel, BorderLayout.PAGE_START);

        textLengthLabel = new JLabel ();
        showTextLength ();
        add (textLengthLabel, BorderLayout.PAGE_END);

        setVisible (true);
    }

    public void updateTextLength ()
    {
        application.textLength = textField.getText ().length ();
        showTextLength ();
    }

    void showTextLength ()
    {
        textLengthLabel.setText (application.textLength + "");
    }

    void showFocus ()
    {
        focusLabel.setText (application.hasFocus + "");
    }

    private Application application;
    private JMenuBar menuBar;
    private JLabel focusLabel, textLengthLabel;
    private JTextField textField;

    @Override
    public void insertUpdate(DocumentEvent e) {
        updateTextLength();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        updateTextLength();
    }

    @Override
    public void changedUpdate(DocumentEvent e) { }

}