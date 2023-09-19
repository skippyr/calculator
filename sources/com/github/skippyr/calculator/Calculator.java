package com.github.skippyr.calculator;

import com.github.skippyr.calculator.core.MathProcessor;
import com.github.skippyr.calculator.gui.Display;
import com.github.skippyr.calculator.gui.Keypad;
import com.github.skippyr.calculator.gui.Window;

public class Calculator
{
    private static final Display       display       = new Display();
    private static final MathProcessor mathProcessor = new MathProcessor(display);
    private static final Keypad        keypad        = new Keypad(mathProcessor);
    private static final Window        window        = new Window(display, keypad);

    public static void main(String[] _arguments)
    {
        window.open();
    }
}
