package com.ruchengxiao.assignment5;


public class Cookie extends DessertItem {
    int number;
    int pricePerDozen;
    public Cookie(String name,int number, int pricePerDozen) {
        super("Cookie");
        this.number = number;
        this.pricePerDozen = pricePerDozen;
    }
    @Override
    public int getCost() {
        double cost = number * pricePerDozen / 12;
        if (Math.abs(Math.ceil(cost) - cost) <= Math.abs(Math.floor(cost) - cost)) {
            return (int) Math.ceil(cost);
        } else {
            return (int) Math.floor(cost);
        }
    }

    @Override
    public String toString() {

        String str = this.number + " " + "@" + " " + this.pricePerDozen + " " + "/lb." + "\n";
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        while (sb.length() < DessertShoppe.widthOfReceipt
                - DessertShoppe.cents2dollarsAndCentsmethod(getCost()).length()) {
            sb.append(" ");
        }

        sb.append(DessertShoppe.cents2dollarsAndCentsmethod(getCost()));
        sb.insert(0, str);
        return sb.toString();
    }
}
