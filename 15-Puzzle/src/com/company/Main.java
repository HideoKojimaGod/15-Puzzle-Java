package com.company;


public class Main {

    public static void main(String[] args) {
        int[] numberedSquare = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0 };
        PuzzleAdvanced game = new PuzzleAdvanced(numberedSquare);

        game.Shift(15);
        game.Randomize();
        //Console.WriteLine(game.GetAllHistory().Count);
        game.GetAllHistory();

        ConsoleGameUI c = new ConsoleGameUI(game);
        c.StartGame();

    }
}
