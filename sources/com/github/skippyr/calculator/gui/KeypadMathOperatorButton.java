package com.github.skippyr.calculator.gui;

import com.github.skippyr.calculator.core.MathOperator;
import com.github.skippyr.calculator.core.MathProcessor;

public class KeypadMathOperatorButton extends KeypadButton
{
    private final MathOperator mathOperator;

    public KeypadMathOperatorButton(MathOperator mathOperator)
    {
        this.mathOperator = mathOperator;
        this.setText(this.mathOperator);
    }

    @Override
    public void addMathProcessorListener(MathProcessor mathProcessor)
    {
        this.addActionListener((_actionEvent) -> { mathProcessor.digitMathOperator(this.mathOperator); });
    }
}
