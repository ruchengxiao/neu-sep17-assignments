package com.ruchengxiao.project2;

import org.testng.annotations.Test;

public class GroupOfCards {
    private Card[] cards;
    private int currentSize = 0;

    public GroupOfCards(int number) {
        cards = new Card[number];
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public Card getCard(int i) {
        return cards[i];
    }

    public void addCard(Card card) {
        cards[currentSize] = card;
        currentSize++;
    }

    public Card removeCard(int index) {
        Card temp = cards[index];
        for (int i = index; i < currentSize - 1; i++) {
            cards[i] = cards[i + 1];
        }

        currentSize--;
        cards[currentSize] = null;
        return temp;
    }

    @Test
    public void display() {
        cards = new Card[32];
        addCard(new Card(2, 1));
        addCard(new Card(3, 1));
        addCard(new Card(4, 1));
        addCard(new Card(5, 1));
        addCard(new Card(6, 1));
        addCard(new Card(7 ,1));
        removeCard(3);
        addCard(new Card(5, 2));
        System.out.println(cards[3].getNum());
        System.out.println(cards[4].getNum());

    }

    public static void main(String[] args) {
        GroupOfCards test = new GroupOfCards(52);
        test.display();
    }

}
