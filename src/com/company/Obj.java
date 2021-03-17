package com.company;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

abstract class Obj implements WindowFocusListener {

    abstract public void windowGainedFocus(WindowEvent e);

    abstract public void windowLostFocus(WindowEvent e);

}
