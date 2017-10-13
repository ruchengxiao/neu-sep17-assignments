package com.ruchengxiao.project1;

import java.io.Console;
import java.util.*;

public class Hangman {
    private ArrayList<String> words;
    private ArrayList<Character> wrongList;
    private String correctList;
    private char[][] hangman;
    char[] dpWord;
    private String choseWord;

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("abcd");
        Hangman test = new Hangman(list);

        test.playGame();

//        List<Integer> lists = new ArrayList<>();
        //System.out.println(1<<3);
    }

    public Hangman(ArrayList<String> words) {
        this.words = words;
        hangman = new char[10][18];
        wrongList = new ArrayList<>();
        for (int i = 0; i < hangman[0].length; i++) {
            if (i != 0 && i < 12) {
                hangman[0][i] = '-';
            } else {
                hangman[0][i] = ' ';
            }


        }

        for (int i = 1; i < hangman.length; i++) {
            for (int j = 0; j < hangman[0].length; j++) {
                if (j == 0 && i != hangman.length - 1) {
                    hangman[i][j] = '|';
                    continue;
                }

                if (i != hangman.length - 1) {
                    hangman[i][j] = ' ';
                }

            }
        }

        for (int i = 0; i < hangman[0].length; i++) {
            if (i != 0) {
                hangman[hangman.length - 1][i] = '-';
                continue;
            }

            hangman[hangman.length - 1][i] = ' ';
        }

        hangman[1][11] = '|';
    }

    private void chooseWord() {
        choseWord = words.get((int) (Math.random() * words.size()));
    }

    private void handleGuess(char letter) {
        if (choseWord.contains(String.valueOf(letter))) {
            for (int i = 0; i < choseWord.length(); i++) {
                if (choseWord.charAt(i) == letter) {
                    dpWord[i] = letter;
                }
            }

            correctList = correctList.replaceAll(String.valueOf(letter), "");
            displayWord();
        } else {
            wrongList.add(letter);
            int times = wrongList.size();

            if (times == 1) {
                hangman[2][11] = '0';
            }

            if (times == 2) {
                hangman[3][11] = '|';
            }

            if (times == 3) {
                for (int i = 0; i < 3; i++) {
                    hangman[4][11 - i - 1] = '-';
                }
            }

            if (times == 4) {
                for (int i = 0; i < 3; i++) {
                hangman[4][11 + i + 1] = '-';
                }
            }

            if (times == 5) {
                hangman[5][10] = '/';
                hangman[6][9] = '/';
            }

            if (times == 6) {
                hangman[5][12] = '\\';
                hangman[6][13] = '\\';
            }

            if (times == 7) {
                hangman[7][7] = '-';
                hangman[7][8] = '-';
            }

            if (times == 8) {
                hangman[7][14] = '-';
                hangman[7][15] = '-';
                printHangman();
                return;
            }

            printHangman();
        }
    }

    private boolean gameWon() {
        if (correctList.length() == 0) {
            return true;
        }

        return false;
    }

    private void gameOver() {
//        if (wrongList == null){
//            System.out.println("sadsadadaas");
//        }
        if (wrongList.size() == 8) {
            //System.out.println(wrongList.size());
            System.out.println("You have lost the game!!!");
        } else {
            System.out.println("You win!!!!!");
        }


        wrongList = null;
        correctList = null;
        choseWord = null;
        dpWord = null;

    }

    private void printHangman() {
        for (int i = 0; i < hangman.length; i++) {
            System.out.println(String.valueOf(hangman[i]));
        }
    }

    void playGame() {

        chooseWord();
        StringBuilder sb = new StringBuilder(choseWord);
        correctList = sb.toString();
        dpWord = new char[choseWord.length()];
        for (int i = 0; i < choseWord.length(); i++) {
            dpWord[i] = '-';
        }

        System.out.println("Welcome to the Hangman game.");
        System.out.println(String.valueOf(dpWord));
        System.out.println("Please guess a letter: ");
        Scanner reader = new Scanner(System.in);


        while (!gameWon()) {
            String letter = reader.next();
            if (letter.length() > 1) {
                System.out.println("Please enter valid letter");
            }

            handleGuess(letter.charAt(0));
            //System.out.println(wrongList.size());
            if (wrongList.size() == 8) {

                break;
            }
        }


        gameOver();
    }

    private void displayWord() {
        System.out.println(String.valueOf(dpWord));
    }
}
