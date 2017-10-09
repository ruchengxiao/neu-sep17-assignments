package com.ruchengxiao.assignment5;

public class Candy extends DessertItem {
    double weight;
    int pricePerPound;
    public Candy(String name, double weight, int pricePerPound) {
        super(name);
        this.weight = weight;
        this.pricePerPound = pricePerPound;
    }
    @Override
    public int getCost() {
        double cost = weight * pricePerPound;
        if (Math.abs(Math.ceil(cost) - cost) <= Math.abs(Math.floor(cost) - cost)) {
            return (int) Math.ceil(cost);
        } else {
            return (int) Math.floor(cost);
        }
    }

    @Override
    public String toString() {
        String formatWeight = String.format("%.2f", this.weight);
        String str = formatWeight + " " + "lbs." + " @ " + this.pricePerPound + " " + "/lb." + "\n";
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
