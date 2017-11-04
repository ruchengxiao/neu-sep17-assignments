package com.ruchengxiao.project2;

public class Card {
    private int num;
    private int suit;

    public Card(int num, int suit) {
        this.num = num;
        this.suit = suit;
    }

    public int getNum() {
        return num;
    }

    public int getSuit() {
        return suit;
    }

    public void display() {
        String res = "";
        switch (suit) {
            case 0:
                res = "clubs";
                break;
            case 1:
                res = "diamonds";
                break;
            case 2:
                res = "hearts";
                break;
            case 3:
                res = "spades";
                break;
        }

        switch (num) {

            case 2:
                res = 2 + " of " + res;
                break;
            case 3:
                res = 3 + " of " + res;
                break;
            case 4:
                res = 4 + " of " + res;
                break;
            case 5:
                res = 5 + " of " + res;
                break;
            case 6:
                res = 6 + " of " + res;
                break;
            case 7:
                res = 7 + " of " + res;
                break;
            case 8:
                res = 8 + " of " + res;
                break;
            case 9:
                res = 9 + " of " + res;
                break;
            case 10:
                res = 10 + " of " + res;
                break;
            case 11:
                res = "Jack" + " of " + res;
                break;
            case 12:
                res = "Queen" + " of " + res;
                break;
            case 13:
                res = "King" + " of " + res;
                break;
            case 14:
                res = "Ace" + " of " + res;
                break;
        }

        System.out.println(res);
    }
}
