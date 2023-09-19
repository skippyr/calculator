package com.github.skippyr.calculator.core;

public enum MathOperator
{
    ADDITION("+", MathOperatorPrecedence.LOW),
    SUBTRACTION("-", MathOperatorPrecedence.LOW),
    MULTIPLICATION("×", MathOperatorPrecedence.HIGH),
    DIVISION("÷", MathOperatorPrecedence.HIGH);

    private final String                 symbol;
    private final MathOperatorPrecedence precedence;

    private MathOperator(String symbol, MathOperatorPrecedence precedence)
    {
        this.symbol     = symbol;
        this.precedence = precedence;
    }

    public MathOperatorPrecedence getPrecedence()
    {
        return (this.precedence);
    }

    public float operate(float firstNumber, float secondNumber)
    {
        switch (this)
        {
        case ADDITION:
            return (firstNumber + secondNumber);
        case SUBTRACTION:
            return (firstNumber - secondNumber);
        case MULTIPLICATION:
            return (firstNumber * secondNumber);
        case DIVISION:
            return (firstNumber / secondNumber);
        default:
            return (0);
        }
    }

    @Override
    public String toString()
    {
        return (this.symbol);
    }

    public static MathOperator fromString(String string)
    {
        for (MathOperator mathOperator : values())
        {
            if (mathOperator.toString().equals(string))
            {
                return (mathOperator);
            }
        }
        return (null);
    }

    public static boolean isMathOperator(String string)
    {
        return (fromString(string) != null);
    }
}
