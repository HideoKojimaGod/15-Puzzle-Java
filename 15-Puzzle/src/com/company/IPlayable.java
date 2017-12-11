package com.company;

public interface IPlayable {
    void Shift(Integer value);
    void Randomize();
    boolean IsFinished();
    int getSizeOfFrame();
    int getValue(int x, int y);
}
