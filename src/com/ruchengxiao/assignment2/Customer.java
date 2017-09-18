package com.ruchengxiao.assignment2;

import java.util.HashMap;

/*
* This is the fifth assignment
* */
public class Customer {
    String name;
    HashMap<Pizza, Integer> pizzasOrdered;

    public static void main(String[] args) {
        Customer shawn = new Customer("Shawn");
        shawn.order("Pepperoni" , 1);
        shawn.order("Mushroom", 2);
        shawn.order("Pesto", 3);
        double sum = shawn.totalMoneySpent();
        System.out.println(sum);
    }

    private double totalMoneySpent() {
        double sum = 0.0;
        for (Pizza pizza: pizzasOrdered.keySet()) {
            sum += pizza.unitPrice * pizzasOrdered.get(pizza);
        }

        return sum;
    }

    public Customer(String name) {
        this.name = name;
        this.pizzasOrdered = new HashMap<>();
    }

    public void order(String pizzaName, int number) {
        pizzasOrdered.put(new Pizza(pizzaName), number);
    }
    /*
    *I would like use HashMap to store the pizza name and number of each kind of pizza.
    *The key of HashMap is Pizza object which I have written at the forth problem.
    * The value is  number of each kind of pizza.
    * */

 }
