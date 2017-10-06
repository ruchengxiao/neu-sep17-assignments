package com.ruchengxiao.assignment4;
//This is the solution for problem 2
class Tool {
    protected int strength;
    protected char type;

    public Tool(char type) {
        this.type = type;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }

}

class Paper extends Tool {

    public Paper(int strength) {
        super('p');
        setStrength(strength);
    }

    public boolean fight(Tool tool) {
        if (tool.getClass().equals(Rock.class)) {
            return 2 * strength > tool.strength;
        } else if (tool.getClass().equals(Scissors.class)){
            return !((Scissors) tool).fight(this);
        } else {
            return strength > tool.strength;
        }

    }
}

class Rock extends Tool {
    public Rock(int strength) {
        super('r');
        setStrength(strength);
    }

    public boolean fight(Tool tool) {
        if (tool.getClass().equals(Paper.class)) {
            return !((Paper) tool).fight(this);
        } else if (tool.getClass().equals(Scissors.class)){
            return 2 * strength > tool.strength;
        } else {
            return strength > tool.strength;
        }

    }
}

class Scissors extends Tool {
    public Scissors(int strength) {
        super('s');
        setStrength(strength);
    }

    public boolean fight(Tool tool) {
        if (tool.getClass().equals(Paper.class)) {
            return 2 * strength > tool.strength;
        } else if (tool.getClass().equals(Rock.class)){
            return !((Rock) tool).fight(this);
        } else {
            return strength > tool.strength;
        }

    }
}

class RockPaperScissorsGame{
    public static void main(String args[]){
        Scissors s = new Scissors(5);
        Paper p = new Paper(7);
        Rock r = new Rock(15);

        System.out.println(s.fight(p) + " , "+ p.fight(s) );
        System.out.println(p.fight(r) + " , "+ r.fight(p) );
        System.out.println(r.fight(s) + " , "+ s.fight(r) );

    }
}