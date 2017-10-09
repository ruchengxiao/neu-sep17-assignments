package com.ruchengxiao.assignment5;

public class Sundae extends IceCream{
    private String icecreamName;
    int cost;
    public Sundae(String icecream, int cost, String topping, int costOfTopping) {
        super(icecream, cost);
        this.cost = super.cost + costOfTopping;
        String str = topping + " Sundane with";
        icecreamName = icecream;
        if (topping.length() + icecream.length() + 14 > DessertShoppe.maxOfItemName) {
            this.name = str + "\n" + super.name;
        } else {
            this.name = str + " " + super.name;
        }

    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        int num = icecreamName.length();
        while (num < DessertShoppe.widthOfReceipt
                - DessertShoppe.cents2dollarsAndCentsmethod(this.cost).length()) {
            sb.append(" ");
            num++;
        }
        sb.append(DessertShoppe.cents2dollarsAndCentsmethod(this.cost));
        return sb.toString();
    }
}
