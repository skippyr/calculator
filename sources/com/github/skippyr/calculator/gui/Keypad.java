package com.github.skippyr.calculator.gui;

import com.github.skippyr.calculator.core.ActionOperator;
import com.github.skippyr.calculator.core.MathOperator;
import com.github.skippyr.calculator.core.MathProcessor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

public class Keypad extends JPanel
{
    private final GridBagLayout      layout      = new GridBagLayout();
    private final GridBagConstraints constraints = new GridBagConstraints();
    private final MathProcessor      mathProcessor;

    private void addButton(KeypadButton button)
    {
        button.addMathProcessorListener(this.mathProcessor);
        this.add(button, this.constraints);
        this.constraints.gridx += 1;
    }

    private void addHorizontalButton(KeypadButton button)
    {
        this.constraints.gridwidth += 1;
        this.addButton(button);
        this.constraints.gridwidth -= 1;
        this.constraints.gridx += 1;
    }

    private void addRow()
    {
        this.constraints.gridx = 0;
        this.constraints.gridy += 1;
    }

    public Keypad(MathProcessor mathProcessor)
    {
        this.mathProcessor          = mathProcessor;
        this.constraints.gridx      = 0;
        this.constraints.gridy      = 0;
        this.constraints.gridwidth  = 1;
        this.constraints.gridheight = 1;
        this.constraints.weightx    = 1;
        this.constraints.weighty    = 1;
        this.constraints.fill       = GridBagConstraints.BOTH;
        this.setLayout(this.layout);
        this.addHorizontalButton(new KeypadActionOperatorButton(ActionOperator.CLEAR));
        this.addButton(new KeypadActionOperatorButton(ActionOperator.DELETE));
        this.addButton(new KeypadMathOperatorButton(MathOperator.MULTIPLICATION));
        this.addRow();
        this.addButton(new KeypadNumberButton(7));
        this.addButton(new KeypadNumberButton(8));
        this.addButton(new KeypadNumberButton(9));
        this.addButton(new KeypadMathOperatorButton(MathOperator.DIVISION));
        this.addRow();
        this.addButton(new KeypadNumberButton(4));
        this.addButton(new KeypadNumberButton(5));
        this.addButton(new KeypadNumberButton(6));
        this.addButton(new KeypadMathOperatorButton(MathOperator.ADDITION));
        this.addRow();
        this.addButton(new KeypadNumberButton(1));
        this.addButton(new KeypadNumberButton(2));
        this.addButton(new KeypadNumberButton(3));
        this.addButton(new KeypadMathOperatorButton(MathOperator.SUBTRACTION));
        this.addRow();
        this.addHorizontalButton(new KeypadNumberButton(0));
        this.addHorizontalButton(new KeypadActionOperatorButton(ActionOperator.EVALUATE));
    }
}
