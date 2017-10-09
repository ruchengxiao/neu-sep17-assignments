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
        //sb.append(this.name);

        String helper = this.name;
        StringBuilder temp = new StringBuilder();
        if (helper.length() > 25) {
            while (helper.length() > 25) {
                sb.append(helper.substring(0, 25) + "\n");
                helper = helper.substring(25, helper.length());
            }
            temp.append(helper.substring(0, helper.length()));
        } else {
            temp.append(helper);
        }

        while (temp.length() < DessertShoppe.widthOfReceipt
                - DessertShoppe.cents2dollarsAndCentsmethod(getCost()).length()) {
            temp.append(" ");
        }

        sb.append(temp);
        sb.append(DessertShoppe.cents2dollarsAndCentsmethod(getCost()));
        sb.insert(0, str);
        return sb.toString();
    }
}
