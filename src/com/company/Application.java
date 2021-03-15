package com.company;

public class Application {
    public Application() {
        gui = new GUI(this);
        hasFocus = false;

    }

    public boolean hasFocus;


    private GUI gui;
}