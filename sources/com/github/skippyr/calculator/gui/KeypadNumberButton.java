package com.github.skippyr.calculator.gui;

import com.github.skippyr.calculator.core.MathProcessor;

public class KeypadNumberButton extends KeypadButton
{
    private final int number;

    public KeypadNumberButton(int number)
    {
        this.number = number;
        this.setText(this.number);
    }

    @Override
    public void addMathProcessorListener(MathProcessor mathProcessor)
    {
        this.addActionListener((_actionEvent) -> { mathProcessor.digitNumber(this.number); });
    }
}
