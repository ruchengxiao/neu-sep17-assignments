package com.ruchengxiao.project2;

import java.util.Scanner;

public class GameDriver {

    public static void main(String[] args) {
        Game test = new Game(4);
        test.playAGame();
        Scanner scanner = new Scanner(System.in);
        while (scanner.next().equals("y")) {
            test = new Game(4);
            test.playAGame();
        }
    }
}
