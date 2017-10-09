package com.ruchengxiao.assignment5;

public class DessertShoppe {
    static final String name = "M & M Dessert Shoppe";
    static final double taxRate = 0.065;
    static final int maxOfItemName = 30;
    static final int widthOfReceipt= 35;

    public static String cents2dollarsAndCentsmethod(int cents) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            sb.insert(0,cents % 10);
            cents /= 10;
        }

        sb.insert(0,".");

        while (cents > 0) {
            sb.insert(0, cents % 10);
            cents /= 10;
        }
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("        " + name);
        sb.append("\n        ");
        for (int i = 0; i < name.length(); i++) {
            sb.append("-");
        }

        return sb.toString();
    }
}
