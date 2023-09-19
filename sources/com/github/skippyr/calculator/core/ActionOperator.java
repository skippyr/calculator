package com.github.skippyr.calculator.core;

public enum ActionOperator
{
    CLEAR("CL"),
    DELETE("DL"),
    EVALUATE("=");

    private final String symbol;

    private ActionOperator(String symbol)
    {
        this.symbol = symbol;
    }

    @Override
    public String toString()
    {
        return (this.symbol);
    }
}
