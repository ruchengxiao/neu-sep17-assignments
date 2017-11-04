package com.ruchengxiao.project2;

public class Deck extends GroupOfCards{
    public final int TOTAL_CARDS;

    public Deck() {
        super(52);
        TOTAL_CARDS = 52;
        for (int i = 2; i <= 14; i++) {
            for (int j = 0; j <= 3; j++) {
                addCard(new Card(i, j));
            }
        }
    }

    public void shuffle() {
        for (int unshuffled = getCurrentSize(); unshuffled >= 1; unshuffled--) {
            int temp = (int) (Math.random() * getCurrentSize());
            addCard(removeCard(temp));
        }
    }

    public Card dealCard() {
        return removeCard(0);
    }
}
