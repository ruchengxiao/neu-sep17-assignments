package com.ruchengxiao.assignment8;

import java.io.IOException;
import java.util.Scanner;
//1th problem
public class FileCounter { // score 3

    private int characterCount, wordCount, lineCount;

    public FileCounter() {
        characterCount = 0;
        wordCount = 0;
        lineCount = 0;
    }

    /**
     * Processes an input source and adds its character, word, and line
     * counts to the respective variables.
     *
     * @param in the scanner to process
     */
    public void read(Scanner in) throws IOException {
        StringBuilder sb = new StringBuilder();
        String buffer = "";
        while (in.hasNextLine()) {
            System.out.println(in.hasNextLine());
            sb.append(in.nextLine());
            sb.append("\n");
            lineCount++;
        }


        String str = sb.toString();
        characterCount = str.length() - 1;
        System.out.println(str.substring(0, str.length()));
        boolean isWhiteSpace = true;
        for (char c : str.toCharArray()) {
            if (c == ' ' || c == '\n' || c == '\t') {
                isWhiteSpace = true;
            } else if (isWhiteSpace) {
                wordCount++;
                isWhiteSpace = false;
            }
        }
    }

    public int getCharacterCount() {
         return characterCount;
    }

    public int getWordCount() {
         return wordCount;
    }

    public int getLineCount() {
         return lineCount;
    }
}
