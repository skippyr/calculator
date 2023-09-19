package com.github.skippyr.calculator.gui;

import com.github.skippyr.calculator.core.MathProcessor;
import java.awt.Font;
import javax.swing.JButton;

public abstract class KeypadButton extends JButton
{
    private final Font font = new Font(Font.SANS_SERIF, Font.BOLD, 18);

    public abstract void addMathProcessorListener(MathProcessor mathProcessor);

    protected void setText(Object text)
    {
        this.setText(text.toString());
    }

    public KeypadButton()
    {
        this.setFont(this.font);
    }
}
