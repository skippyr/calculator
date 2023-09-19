package com.github.skippyr.calculator.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Display extends JPanel
{
    private final JLabel textArea        = new JLabel();
    private final Font   textAreaFont    = new Font(Font.SANS_SERIF, Font.PLAIN, 25);
    private final int    heightInPixels  = 60;
    private final Color  backgroundColor = Color.WHITE;

    public Display()
    {
        this.setPreferredSize(new Dimension(0, this.heightInPixels));
        this.setBackground(this.backgroundColor);
        this.textArea.setFont(this.textAreaFont);
        this.add(this.textArea);
    }

    public void setText(Object text)
    {
        this.textArea.setText(text.toString());
    }
}
