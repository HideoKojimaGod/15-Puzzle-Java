package com.company;

public class Position {
    public int X;
    public int Y;
    public Position(int x, int y)
    {
        this.X = x;
        this.Y = y;
    }
    public double Minus(Position b)
    {
        return Math.sqrt(Math.pow(this.Y - b.Y, 2) + Math.pow(this.X - b.X, 2));
    }
}
