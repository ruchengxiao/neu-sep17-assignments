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
                             - DessertShoppe.cents2dollarsAndCentsmethod(this.cost).length()) {
            temp.append(" ");

        }

        sb.append(temp);
        sb.append(DessertShoppe.cents2dollarsAndCentsmethod(this.cost));
        return sb.toString();
    }
}
