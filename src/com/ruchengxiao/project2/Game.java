package com.ruchengxiao.project2;


public class Game {
    public final int PLAYERS;
    private Deck deck;
    private Hand[] players;
    private Trick[] tricks;
    private int numberOfTricks = 0;
    private boolean hearts = false;
    private boolean queenOfSpades = false;

    public Game(int numberOfPlayers) {
        this.PLAYERS = numberOfPlayers;
        players = new Hand[PLAYERS];
        deck = new Deck();
        this.numberOfTricks = deck.TOTAL_CARDS / PLAYERS;
        for (int i = 0; i < players.length; i++) {
            players[i] = new Hand(i, this.numberOfTricks);
        }

        tricks = new Trick[this.numberOfTricks];

    }

    public int getNumberOfTricks() {
        return numberOfTricks;
    }

    public boolean getHearts() {
        return hearts;
    }

    public boolean getQueenOfSpades() {
        return queenOfSpades;
    }

    public void playAGame() {
        deck.shuffle();
        int cardsLeft = deck.TOTAL_CARDS % PLAYERS;
        int playerNum = 0;
        Card card = null;
        System.out.println("Output - first part: ");
        System.out.println();
        System.out.println();
        for (int i = 0; i < tricks.length; i++) {
            for (int j = 0;j < players.length; j++) {
                players[j].addCard(deck.dealCard());
            }
        }


        for (int i = 0; i < PLAYERS; i++) {
            players[i].sort();
            players[i].setShortest();
            System.out.println("        player " + i + " shortest = " + players[i].getShortest());
            for (int j = 0; j < players[i].getCurrentSize(); j++) {
                players[i].getCard(j).display();
                if (players[i].getCard(j).getNum() == 2
                        && players[i].getCard(j).getSuit() == 0) {
                    playerNum = i;
                }
            }
        }

        System.out.println("\n\n\n\n");

        for (int i = 0; i < tricks.length; i++) {
            tricks[i] = new Trick(PLAYERS * 2 - 1);
            if (i == 0) {
                System.out.println("Output - second part: ");
                System.out.println();
                System.out.println();
                for (int m = 0; m < playerNum; m++) {

                    if (players[m].findLowest(0) != -1) {
                        int index = players[m].findLowest(0);
                        if (players[m].getCard(index).getNum() == 2) {
                            card = players[m].getCard(players[m].findLowest(0));
                            players[m].removeCard(m);
                            break;
                        }
                    }
                }

                if (card == null) {
                    card = players[(int) Math.random() * playerNum].getCard(1);
                }
                tricks[i].update(playerNum, card);
                tricks[i].addCard(card);
                System.out.print("player " + playerNum + "        ");
                card.display();
                playerNum = (playerNum + 1) % PLAYERS;

                tricks[i].addCard(card);

                for (int j = 1; j < PLAYERS; j++) {
                    card = players[playerNum].playACard(this,tricks[i]);

                    System.out.print("player "+ playerNum + "        ");
                    card.display();
                    tricks[i].addCard(card);
                    playerNum = (playerNum + 1) % PLAYERS;
                }

                for(int k = 0; k < cardsLeft; k++){
                    Card cardLeft = deck.dealCard();
                    updateHeartsAndQueen(cardLeft);
                    tricks[i].addCard(cardLeft);
                    System.out.print("undelt card" + "        " );
                    cardLeft.display();
                    tricks[i].addCard(card);
                }

            } else {
                System.out.println();
                System.out.println();
                for (int j = 0; j < PLAYERS; j++) {
                    card = players[playerNum].playACard(this, tricks[i]);
                    System.out.print("player " + playerNum + "        ");
                    card.display();
                    tricks[i].addCard(card);
                    playerNum = (playerNum + 1) % PLAYERS;
                }


            }

            playerNum = tricks[i].getWinner();
            numberOfTricks++;
        }

        for (int i = 0; i < PLAYERS; i++) {
            System.out.println("Player " + i + " "
                                + "score = " + computePoints(i));
        }
        System.out.println("Play another game (y/n)? ");

    }

    public void updateHeartsAndQueen(Card card) {
        if (!hearts && card.getSuit() == 2) {
            System.out.println("Hearts is now broken");
            hearts = true;
        }

        if (card.getSuit() == 3 && card.getNum() == 12) {
            queenOfSpades = true;
        }
    }

    private int computePoints(int playerNum) {
        int result = 0;
        for (int i = 0 ; i < tricks.length; i++) {
            if (tricks[i].getWinner() == playerNum) {
                for (int j = 0; j < tricks[i].getCurrentSize(); j++) {
                    if (tricks[i].getCard(j).getNum() == 12
                            && tricks[i].getCard(j).getSuit() == 3) {
                        result += 13;
                    }

                    if (tricks[i].getCard(j).getSuit() == 2) {
                        result += 1;
                    }
                }
            }
        }

        return result;
    }
}
