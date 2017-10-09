package com.ruchengxiao.assignment5;

public class IceCream extends DessertItem{
    int cost;
    public IceCream(String name, int cost) {
        super(name);
        this.cost = cost;
    }


    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);

        while (sb.length() < DessertShoppe.widthOfReceipt
                             - DessertShoppe.cents2dollarsAndCentsmethod(this.cost).length()) {
            sb.append(" ");
        }
        sb.append(DessertShoppe.cents2dollarsAndCentsmethod(this.cost));
        return sb.toString();
    }
}
