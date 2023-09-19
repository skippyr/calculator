package com.github.skippyr.calculator.core;

import java.util.ArrayList;

public class MathProcessorCache
{
    private final ArrayList<String> storage                             = new ArrayList<>();
    private final int               maximumQuantityOfCharactersInNumber = 9;

    private int getLastItemIndex()
    {
        return (this.storage.size() - 1);
    }

    private String getLastItem()
    {
        return (this.storage.isEmpty() ? null : this.storage.get(this.getLastItemIndex()));
    }

    private int getTotalOfNumbers()
    {
        int totalOfNumbers = 0;
        for (String item : this.storage)
        {
            if (!MathOperator.isMathOperator(item))
            {
                totalOfNumbers++;
            }
        }
        return (totalOfNumbers);
    }

    private void add(Object item)
    {
        this.storage.add(item.toString());
    }

    private void append(Object item)
    {
        this.storage.set(this.getLastItemIndex(), this.getLastItem() + item.toString());
    }

    public int getTotalOfItems()
    {
        return (this.storage.size());
    }

    public void removeTrailingOperator()
    {
        if (MathOperator.isMathOperator(this.getLastItem()))
        {
            this.storage.remove(this.getLastItemIndex());
        }
    }

    public String getItemByIndex(int index)
    {
        return (this.storage.get(index));
    }

    public void clear()
    {
        this.storage.clear();
    }

    public void delete()
    {
        if (this.storage.isEmpty())
        {
            return;
        }
        String lastItem       = this.getLastItem();
        int    lastItemIndex  = this.getLastItemIndex();
        int    lastItemLength = lastItem.length();
        if (lastItemLength == 1)
        {
            this.storage.remove(lastItemIndex);
            return;
        }
        this.storage.set(lastItemIndex, lastItem.substring(0, lastItemLength - 1));
    }

    public void cacheNumber(int number)
    {
        String lastItem = this.getLastItem();
        if (this.storage.isEmpty() || MathOperator.isMathOperator(lastItem))
        {
            if (number == 0)
            {
                return;
            }
            this.add(number);
        }
        else if (lastItem.length() < this.maximumQuantityOfCharactersInNumber)
        {
            this.append(number);
        }
    }

    public void cacheMathOperator(MathOperator mathOperator)
    {
        if (!this.storage.isEmpty() && !MathOperator.isMathOperator(this.getLastItem()))
        {
            this.add(mathOperator);
        }
    }

    public void cacheResult(int mathOperatorIndex, MathOperator mathOperator)
    {
        int   firstNumberIndex  = mathOperatorIndex - 1;
        int   secondNumberIndex = mathOperatorIndex + 1;
        float firstNumber       = Float.parseFloat(this.storage.get(firstNumberIndex));
        float secondNumber      = Float.parseFloat(this.storage.get(secondNumberIndex));
        float result            = mathOperator.operate(firstNumber, secondNumber);
        int   resultAsInteger   = (int)result;
        this.storage.remove(secondNumberIndex);
        this.storage.remove(mathOperatorIndex);
        this.storage.set(firstNumberIndex,
                         resultAsInteger == result ? Integer.toString(resultAsInteger) : String.format("%.1f", result));
    }

    @Override
    public String toString()
    {
        return (this.storage.isEmpty() ? "0" : String.join(" ", this.storage));
    }
}
