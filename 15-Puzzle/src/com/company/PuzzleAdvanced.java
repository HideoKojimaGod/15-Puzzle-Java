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
        System.out.println((new History(value, GetLocation(0), GetLocation(value))).toString());
        history.add(new History(value, GetLocation(0), GetLocation(value)));
        currentStep++;
    }
}
