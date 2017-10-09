package com.ruchengxiao.assignment5;

import java.util.ArrayList;
import java.util.List;

public class Checkout {
    List<DessertItem> dessertItems;
    private int sum;

    public Checkout() {
        dessertItems = new ArrayList<>();
    }

    public int numberOfItems() {
        return dessertItems.size();
    }

    public void enterItem(DessertItem item) {
        dessertItems.add(item);
    }

    public void clear() {
        dessertItems.clear();
    }

    public int totalCost() {
        sum = 0;
        for (int i = 0; i < dessertItems.size(); i++) {
            sum += dessertItems.get(i).getCost();
        }

        return sum;
    }

    public int totalTax() {
        double tax = sum * DessertShoppe.taxRate;
        if (Math.abs(Math.ceil(tax) - tax) <= Math.abs(Math.floor(tax) - tax)) {
            return (int) Math.ceil(tax);
        } else {
            return (int) Math.floor(tax);
        }
    }

    @Override
    public String toString() {
        DessertShoppe dessertShoppe = new DessertShoppe();
        StringBuilder sb = new StringBuilder();
        sb.append(dessertShoppe);
        sb.append("\n");
        for (DessertItem item : dessertItems) {
            sb.append("\n" + item);
        }

        sb.append("\n\n");
        StringBuilder sb1 = new StringBuilder();
        sb1.append("Tax");
        while (sb1.length() < DessertShoppe.widthOfReceipt
                - DessertShoppe.cents2dollarsAndCentsmethod(totalTax()).length()) {
            sb1.append(" ");
        }

        sb1.append(DessertShoppe.cents2dollarsAndCentsmethod(totalTax()));
        sb.append(sb1.toString());
        sb.append("\n");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Total Cost");
        while (sb2.length() < DessertShoppe.widthOfReceipt
                - DessertShoppe.cents2dollarsAndCentsmethod(totalTax() + totalCost()).length()) {
            sb2.append(" ");
        }


        sb.append(sb2);
        sb.append(DessertShoppe.cents2dollarsAndCentsmethod(totalTax() + totalCost()));
        sb.append("\n");
        return sb.toString();
    }
}
