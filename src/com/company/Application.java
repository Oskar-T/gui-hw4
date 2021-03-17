package com.company;

public class Application {
    public Application() {
        gui = new GUI(this);
        hasFocus = false;
        textLength = 0;

    }

    public boolean hasFocus;
    public int textLength;

    private GUI gui;
}