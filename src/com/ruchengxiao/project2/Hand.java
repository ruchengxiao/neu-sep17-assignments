package com.ruchengxiao.project2;

public class Hand extends GroupOfCards{
    public final int NUM;
    private int shortest = 0;
    int number = 0;

    public Hand(int playerNum, int numberOfCards) {
        super(numberOfCards);
        this.NUM = playerNum;
    }

    public void sort() {
        for (int unsorted = getCurrentSize(); unsorted >= 1; unsorted--) {
            int max = Integer.MIN_VALUE;
            int temp = 0;
            for (int index = 0; index < unsorted; index++) {
                if (max < getCard(index).getSuit() * 13 + getCard(index).getNum()){
                    temp = index;
                }
            }

            addCard(removeCard(temp));
        }
    }

    public void setShortest() {
        int clubs = findCount(0);
        int minCount = clubs;
        shortest = 0;
        int diamonds = findCount(1);
        if (diamonds <= minCount) {
            shortest = 1;
        }

        int spades = findCount(3);
        if (spades <= minCount && find(12, 3) == -1 &&
                find(13, 3) == -1 && find(14, 3) == -1) {
            shortest = 3;
        }
    }

    public int getShortest() {
        return shortest;
    }


    public Card playACard(Game game, Trick trick) {
        int index = 0;
        int suit = 0;
        if (trick.getCurrentSize() != 0) {
            suit = trick.getWinningCard().getSuit();
        }
        Card winningCard = trick.getWinningCard();
        if (trick.getCurrentSize() == 0) {
            index = findHighest(shortest);
            if (index == -1) {
                int temp = 0;
                while (index == -1 && temp <= 3) {
                    index = findLowest(game);
                    temp++;
                }
            }
        }
        else if (trick.getCurrentSize() == game.PLAYERS - 1) {
                boolean temp = true;
                for (int i = 0; i < trick.getCurrentSize(); i++) {
                    if (trick.getCard(i).getSuit() == 2
                            || ((trick.getCard(i).getNum() == 12
                            && trick.getCard(i).getSuit() == 3))) {
                        temp = false;
                    }
                }

                if (temp) {
                    index = findHighest(suit);
                }

                if (index == -1) {
                    index = findHighest();
                }
        }
        else if ((trick.getCurrentSize() == game.PLAYERS - 1)
                && !trick.getHearts() && !trick.getQueen()
                && (index = findLastHigh(suit)) >= 0);
        else if ((index = findHighestBelow(winningCard)) >= 0);
        else if ((index = findMiddleHigh(game, suit)) >= 0);
        else if ((index = find(12, 3)) >= 0); // queen of Spades
        else if ((index = find(14, 3)) >= 0); // Ace of Spades
        else if ((index = find(13, 3)) >= 0); // King of Spades
        else if ((index = findHighest(2)) >= 0); // heart
        else {
            index = findHighest();
        }

        //index = (int) (Math.random() * getCurrentSize());
        //System.out.println(" sdfsadasdsadassddsa" + getCurrentSize());
        Card result = getCard(index);

        //System.out.println(NUM + "           " + getCurrentSize());
        if (result == null) {
            //System.out.println("fucjfucjdsdj" + "           " + index + "   " + getCurrentSize());
        }

        trick.update(NUM, result);
        game.updateHeartsAndQueen(result);
        removeCard(index);
        setShortest();
        //System.out.println(getCurrentSize());
        //System.out.println(NUM + "        " + index);
        return result;
    }

    public int findLowest(int suit) {
        int min = Integer.MAX_VALUE;
        int result = -1;
        for (int i = 0; i < getCurrentSize(); i++) {
            if (getCard(i).getSuit() == suit) {
                if (min > getCard(i).getNum()){
                    min = getCard(i).getNum();
                    result = i;
                }
            }
        }

        //System.out.println("findLowest:  " + getCard(result).getSuit());
        return result;
    }

    private int findCount(int suit) {
        int count = 0;
        for (int i = 0; i < getCurrentSize(); i++) {
            if (getCard(i).getSuit() == suit) {
                count++;
            }
        }


        return count;
    }

    private int find(int num, int suit) {
        for (int i = 0; i < getCurrentSize(); i++) {
            if (getCard(i).getNum() == num && getCard(i).getSuit() == suit) {
                return i;
            }
        }

        return -1;
    }

    private int findHighest(int suit) {
        int max = Integer.MIN_VALUE;
        int result = -1;
        for (int i = 0; i < getCurrentSize(); i++) {
            if (getCard(i).getSuit() == suit) {
                if (max <= getCard(i).getNum()){
                    max = getCard(i).getNum();
                    result = i;
                }

            }
        }

        //System.out.println("findHighest:  " + result);
        return result;
    }

    private int findLowest(Game game) {
        int min = Integer.MAX_VALUE;
        int result = -1;
        for (int i = 0; i < getCurrentSize(); i++) {
            if (min >= getCard(i).getNum() && getCard(i).getSuit() != 2) {
                min = getCard(i).getNum();
                result = i;
            }
        }

        if (result == -1) {
            if (game.getHearts()) {
                for (int i = 0; i < getCurrentSize(); i++) {
                    if (min >= getCard(i).getNum()) {
                        min = getCard(i).getNum();
                        result = i;
                    }
                }
            }
        }

        //System.out.println("findLowest:  " + result);
        return result;
    }

    private int findLastHigh(int suit) {
        int index = findHighest(suit);
        if (getCard(index).getNum() == 12 && getCard(index).getSuit() == 3) {
            for (int i = 0; i < getCurrentSize(); i++) {
                if (getCard(i).getNum() != 12
                        && getCard(i).getSuit() == 3) {
                    int min = Integer.MAX_VALUE;
                    for (int j = 0; j < getCurrentSize(); j++) {
                        if (min > getCard(j).getNum() && getCard(j).getNum() < 12) {
                            min = getCard(j).getNum();
                            index = j;
                        }

                    }
                    return index;
                }
            }
        }

        System.out.println("findLastHigh:  " + index);
        return index;
    }

    private int findHighestBelow(Card winningCard) {
        int result = -1;
        for (int i = 0; i < getCurrentSize() - 1; i++) {
            if (getCard(i).getSuit() == winningCard.getSuit()
                    && getCard(i).getNum() < winningCard.getNum()) {
                if (getCard(i + 1).getSuit() == getCard(i).getSuit()) {
                    result =  i;
                }

                break;
            }
        }
        //System.out.println("findHighestBelow:    "  + result);
        return -1;
    }

    private int findMiddleHigh(Game game, int suit) {
        int index = findHighest(suit);
        if (index == -1) {
            return index;
        }
        if (getCard(index).getSuit() == 3 && game.getQueenOfSpades()) {
            index = -1;
            int max = Integer.MIN_VALUE;
            for (int i = 0;i < getCurrentSize(); i++) {
                if (getCard(i).getSuit() == 3) {
                    if (max < getCard(i).getNum() && getCard(i).getNum() < 11) {
                        max = getCard(i).getNum();
                        index = i;
                    }
                }
            }
        }
        //System.out.println("findMiddleHigh:    "  + index);
        return index;
    }

    private int findHighest() {
        int max = Integer.MIN_VALUE;
        int result = 0;
        for (int i = 0; i < getCurrentSize(); i++) {
            if (max < getCard(i).getNum()) {
                max = getCard(i).getNum();
                result = i;
            }
        }
        //System.out.println("findHighest:    "  + result);
        return result;
    }



}
