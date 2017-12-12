package com.company;

import java.util.ArrayList;


public class PuzzleAdvanced extends Puzzle {
    private ArrayList<History> history;
    private int currentStep;
    public PuzzleAdvanced(int... numberedSquare)
    {
        super(numberedSquare);
        history = new ArrayList<History>();
        currentStep = 0;
    }

    @Override
    public void Shift(Integer value)
    {
        super.Shift(value);
        if (currentStep < history.size())
        {
            for (int i = history.size() - 1; i > currentStep - 1; i--)
                history.remove(i);
        }
        history.add(new History(value, GetLocation(0), GetLocation(value)));
        currentStep++;
    }

    public void Redo(int amountOfSteps)
    {
        for (int i = 0; i < amountOfSteps; i++)
        {
            if (currentStep < history.size())
            {
                super.Shift(history.get(currentStep).Value);
                currentStep++;
            }
            else throw new IllegalArgumentException("Невозможно вернуться вперед");
        }
    }
    public void Undo(int amountOfSteps)
    {
        for (int i = 0; i < amountOfSteps; i++)
        {
            if (currentStep > 0)
            {
                super.Shift(history.get(currentStep - 1).Value);
                currentStep--;
            }
            else throw new IllegalArgumentException("Невозможно вернуться назад");
        }
    }
    public void GetAllHistory()
    {
        for (int i = 0; i < currentStep; i++)
        {
            System.out.println(history.get(i).toString());
        }
    }
    public String GetStep(int value)
    {
        if (value <= currentStep)
        {
            return history.get(value - 1).toString();
        }
        else return "Не существует шага";
    }
    public void ClearHistory()
    {
        history.clear();
    }
    @Override
    public void Randomize()
    {
        super.Randomize();
        ClearHistory();
    }
}
