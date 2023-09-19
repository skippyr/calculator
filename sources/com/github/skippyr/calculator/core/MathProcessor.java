package com.github.skippyr.calculator.core;

import com.github.skippyr.calculator.gui.Display;

public class MathProcessor
{
    private final MathProcessorCache cache = new MathProcessorCache();
    private final Display            display;

    public MathProcessor(Display display)
    {
        this.display = display;
        this.display.setText(this.cache);
    }

    public void calculateResult()
    {
        this.cache.removeTrailingOperator();
        for (MathOperatorPrecedence precedence : MathOperatorPrecedence.values())
        {
            for (int itemIndex = 0; itemIndex < this.cache.getTotalOfItems(); itemIndex++)
            {
                String       item         = this.cache.getItemByIndex(itemIndex);
                MathOperator mathOperator = MathOperator.fromString(item);
                if (mathOperator != null && mathOperator.getPrecedence() == precedence)
                {
                    this.cache.cacheResult(itemIndex, mathOperator);
                    itemIndex -= 1;
                }
            }
        }
    }

    public void digitNumber(int number)
    {
        this.cache.cacheNumber(number);
        this.display.setText(this.cache);
    }

    public void digitMathOperator(MathOperator mathOperator)
    {
        this.cache.cacheMathOperator(mathOperator);
        this.display.setText(this.cache);
    }

    public void digitActionOperator(ActionOperator actionOperator)
    {
        switch (actionOperator)
        {
        case CLEAR:
            this.cache.clear();
            this.display.setText(this.cache);
            break;
        case DELETE:
            this.cache.delete();
            this.display.setText(this.cache);
            break;
        case EVALUATE:
            this.calculateResult();
            this.display.setText(this.cache);
            this.cache.clear();
            break;
        default:;
        }
    }
}
