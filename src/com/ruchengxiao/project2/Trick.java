package com.ruchengxiao.project2;

public class Trick extends GroupOfCards{
    private int winner;
    private Card winningCard;
    private boolean hearts = false;
    private boolean queen = false;

    public Trick(int players) {
        super(2 * players - 1);

    }

    public int getWinner() {
        return winner;
    }

    public Card getWinningCard() {
        return winningCard;
    }

    public boolean getHearts() {
        return hearts;
    }

    public boolean getQueen() {
        return queen;
    }

    public void update(int playerNum, Card card) {
        if (isWinner(card)) {
            this.winner = playerNum;
            this.winningCard = card;
        }

        if (card.getSuit() == 2) {
            this.hearts = true;
        }

        if (card.getNum() == 13 && card.getNum() == 3) {
            this.queen = true;
        }

    }

    public boolean isWinner(Card card) {
        if (winningCard == null) {
            return true;
        }

        if (card.getSuit() == winningCard.getSuit()
                && card.getNum() > winningCard.getNum()) {

            return true;
        }

        return false;
    }

}
