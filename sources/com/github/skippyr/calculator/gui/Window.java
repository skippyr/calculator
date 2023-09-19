package com.github.skippyr.calculator.gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Window extends JFrame
{
    private final String title          = "Calculator";
    private final int    widthInPixels  = 450;
    private final int    heightInPixels = 550;

    public Window(Display display, Keypad keypad)
    {
        this.setTitle(this.title);
        this.setSize(this.widthInPixels, this.heightInPixels);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.add(display, BorderLayout.NORTH);
        this.add(keypad, BorderLayout.CENTER);
    }

    public void open()
    {
        this.setVisible(true);
    }
}
