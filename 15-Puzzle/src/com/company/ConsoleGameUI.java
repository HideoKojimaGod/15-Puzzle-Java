package com.company;
import java.util.Scanner;
import java.io.Console;

public class ConsoleGameUI {
    public IPlayable Puzzle;
    public ConsoleGameUI(IPlayable Puzzle)
    {
        this.Puzzle = Puzzle;
    }
    public void Input()
    {
        Integer value = Integer.parseInt((new Scanner(System.in)).nextLine());
        Puzzle.Shift(value);
    }
    public void Output()
    {
        String output = new String("");
        for (int i = 0; i < Puzzle.getSizeOfFrame(); i++)
        {
            for (int j = 0; j < Puzzle.getSizeOfFrame(); j++)
            {
                output += Puzzle.getValue(i,j) + "   ";
            }
            output += "\n";
        }
        System.out.println(output);
        //Console.WriteLine(Puzzle);
    }
    public void StartGame()
    {
        while(true)
        {
            Output();
            Input();
        }
    }
}
