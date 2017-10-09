package com.ruchengxiao.assignment5;

public class Sundae extends IceCream{
    private String icecreamName;
    int cost;
    public Sundae(String icecream, int cost, String topping, int costOfTopping) {
        super(icecream, cost);
        this.cost = super.cost + costOfTopping;
        this.name = topping;
//        String str = topping + " Sundane with" + " ";
        icecreamName = icecream;
//        if (topping.length() + icecream.length() + 14 > DessertShoppe.maxOfItemName) {
//            this.name = str + "\n" + super.name;
//        } else {
//            this.name = str + " " + super.name;
//        }

    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //sb.append(this.name);
        String helper = this.name;
        StringBuilder temp1 = new StringBuilder();
        if (helper.length() > 25) {
            while (helper.length() > 25) {
                sb.append(helper.substring(0, 25) + "\n");
                helper = helper.substring(25, helper.length());
            }
            temp1.append(helper.substring(0, helper.length()) + " Sundae with");
        } else {
            temp1.append(helper + " Sundae with" + "\n");
        }
        sb.append(temp1.toString());

        String helper2 = icecreamName;
        StringBuilder temp2 = new StringBuilder();
        if (helper2.length() > 25) {
            for (int i = 0; helper2.length() > 25; i += 25) {
                sb.append(helper2.substring(0, 25) + "\n");
                helper2 = helper2.substring(25, helper2.length());
            }
            temp2.append(helper2.substring(0, helper.length()));
        } else {
            temp2.append(helper2);
        }


        while (temp2.length() < DessertShoppe.widthOfReceipt
                - DessertShoppe.cents2dollarsAndCentsmethod(this.cost).length()) {
            temp2.append(" ");
        }
        sb.append(temp2.toString());
        sb.append(DessertShoppe.cents2dollarsAndCentsmethod(this.cost));
        return sb.toString();
    }
}
