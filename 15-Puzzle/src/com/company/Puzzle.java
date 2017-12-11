package com.company;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;


public class Puzzle implements IPlayable {
    protected Integer[][] frame;
    protected Integer SizeOfFrame;
    protected HashMap<Integer, Position> positions;
    public Puzzle(int... numberedSquare)
    {
        positions = new HashMap<Integer,Position>();
        SizeOfFrame = Integer.valueOf((int)Math.sqrt(numberedSquare.length));
        frame = new Integer[SizeOfFrame][SizeOfFrame];
        for (int i = 0; i < SizeOfFrame; i++)
        {
            for (int j = 0; j < SizeOfFrame; j++)
            {
                int value = numberedSquare[i * SizeOfFrame + j];
                frame[i][j] = value;
                positions.put(value, new Position(i, j));
            }
        }
    }

    public int getSizeOfFrame() {
        return SizeOfFrame;
    }

    public int getValue(int x, int y)
    {
        return frame[x][y];
    }

    protected void setValue(int x, int y, int value)
    {
        frame[x][y] = value;
    }

    public Position GetLocation(Integer value)
    {
        return positions.get(value);
    }

    public void Shift(Integer value)
    {
        try
        {
            if (positions.get(value).Minus(positions.get(0)) == 1)
            {
                Position positionZero = positions.get(0);
                frame[positions.get(0).X][positions.get(0).Y] = value;
                frame[positions.get(value).X][positions.get(value).Y] = 0;
                positions.put(0, positions.get(value));
                positions.put(value, positionZero);
            }
            else throw new IllegalArgumentException("Невозможно передвинуть фишку");
        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public String toString()
    {
        String output = "";
        for (int i = 0; i < SizeOfFrame; i++)
        {
            for (int j = 0; j < SizeOfFrame; j++)
            {
                output += frame[i][j] + "   ";
            }
            output += "\n";
        }
        return output;
    }
    protected ArrayList<Integer> CheckVarinatsOfReplace()
    {
        ArrayList<Integer> variants = new ArrayList<Integer>();
        if (GetLocation(0).X != SizeOfFrame - 1)
            variants.add(frame[GetLocation(0).X + 1][GetLocation(0).Y]);
        if (GetLocation(0).X != 0)
            variants.add(frame[GetLocation(0).X - 1][GetLocation(0).Y]);
        if (GetLocation(0).Y != SizeOfFrame - 1)
            variants.add(frame[GetLocation(0).X][GetLocation(0).Y + 1]);
        if (GetLocation(0).Y != 0)
            variants.add(frame[GetLocation(0).X][GetLocation(0).Y] - 1);
        return variants;
    }
    public void Randomize()
    {
        Integer n = SizeOfFrame * SizeOfFrame;
        Random rand = new Random();
        for (int i = 0; i < n; i++)
        {
            ArrayList<Integer> variants = CheckVarinatsOfReplace();
            Shift(variants.get(rand.nextInt(variants.size() - 1)));
        }
    }

    public boolean IsFinished()
    {
        for (int i = 0; i < SizeOfFrame; i++)
        {
            for (int j = 0; j < SizeOfFrame; j++)
            {
                if (i == SizeOfFrame - 1 && j == SizeOfFrame - 1 && frame[i][ j] == 0)
                continue;
                    else if (frame[i][j] == i * SizeOfFrame + j + 1 && (i != SizeOfFrame - 1 || j != SizeOfFrame - 1))
                continue;
                    else return false;
            }
        }
        return true;
    }
}
