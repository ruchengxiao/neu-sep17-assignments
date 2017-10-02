// score 2 + extra credit 0.5
package com.ruchengxiao.assignment2;
/*
* This is the forth problem
* */
public class Pizza {
    String type;
    double unitPrice;
    int loyaltyPoints;

    public Pizza() {
        this.type = "Normal";
        this.unitPrice = 5.0;
        this.loyaltyPoints = 5;
    }

    public Pizza(String type) { // though you are printing to console, this constructor creates an object without any initialization of data
        if (type == "Pepperoni") {
            this.unitPrice = 6.0;
            this.loyaltyPoints = 6;
            return;
        }

        if (type == "Mushroom") {
            this.unitPrice = 7.0;
            this.loyaltyPoints = 7;
            return;
        }

        if (type == "Pesto") {
            this.unitPrice = 7.5;
            this.loyaltyPoints = 8;
            return;
        }

        if (type == "Arugula") {
            this.unitPrice = 7.5;
            this.loyaltyPoints = 8;
            return;
        }

        if (type == "Roasted Vegetable") {
            this.unitPrice = 7;
            this.loyaltyPoints = 7;
            return;
        }

        if (type == "3 Cheese") {
            this.unitPrice = 7.5;
            this.loyaltyPoints = 8;
            return;
        }

        System.out.println("Sorry, this pizza is not available in our store.");
    }


    public Pizza(String type, double unitPrice, int loyaltyPoints) {
        this.type = type;
        this.unitPrice = unitPrice;
        this.loyaltyPoints = loyaltyPoints;
    }
}
