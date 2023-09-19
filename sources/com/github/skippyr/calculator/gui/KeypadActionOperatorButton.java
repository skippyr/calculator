package com.github.skippyr.calculator.gui;

import com.github.skippyr.calculator.core.ActionOperator;
import com.github.skippyr.calculator.core.MathProcessor;

public class KeypadActionOperatorButton extends KeypadButton
{
    private final ActionOperator actionOperator;

    public KeypadActionOperatorButton(ActionOperator actionOperator)
    {
        this.actionOperator = actionOperator;
        this.setText(actionOperator);
    }

    @Override
    public void addMathProcessorListener(MathProcessor mathProcessor)
    {
        this.addActionListener((_actionEvent) -> { mathProcessor.digitActionOperator(this.actionOperator); });
    }
}
