package com.ruchengxiao.assignment5;


public class Cookie extends DessertItem {
    int number;
    int pricePerDozen;
    public Cookie(String name,int number, int pricePerDozen) {
        super(name);
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

        String str = this.number + " " + "@" + " " + this.pricePerDozen + " " + "/dz." + "\n";
        StringBuilder sb = new StringBuilder();
        //sb.append(this.name);
        String helper = this.name;
        StringBuilder temp = new StringBuilder();
        if (helper.length() > 25) {
            for (int i = 0; helper.length() > 25;) {
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
