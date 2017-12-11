package com.company;

public class History {
    public int Value;
    public Position ShiftTo;
    public Position ShiftFrom;
    public History(Integer value, Position pos1, Position pos2)
    {
        Value = value;
        ShiftFrom = pos1;
        ShiftTo = pos2;
    }
    @Override
    public String toString()
    {
        return Value + " with (" + ShiftFrom.X +";" + ShiftFrom.Y +") replaced to (" + ShiftTo.X +";" + ShiftTo.Y +")";
    }
}
