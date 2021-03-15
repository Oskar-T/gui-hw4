package com.company;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.ActionEvent;



public class GUI extends JFrame implements WindowFocusListener {
    public GUI(Application application) {
        super("Title");
        this.application = application;
        setSize(400, 300);


        addWindowFocusListener(this);


        menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.addActionListener((ActionEvent e) ->
                System.exit(0));
        fileMenu.add(quitItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        focusLabel = new JLabel();
        showFocus();
        add(focusLabel, BorderLayout.PAGE_START);


        setVisible(true);
    }


    public void windowGainedFocus(WindowEvent e) {
        application.hasFocus = true;
        showFocus();
    }

    public void windowLostFocus(WindowEvent e) {
        application.hasFocus = false;
        showFocus();
    }

    void showFocus() {
        focusLabel.setText(application.hasFocus + "");
    }

    private Application application;
    private JMenuBar menuBar;
    private JLabel focusLabel;
}
