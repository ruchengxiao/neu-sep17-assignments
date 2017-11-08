package com.ruchengxiao.assignment7;

public class ReverseHello extends Thread{
    int num;
    ReverseHello(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        if (num == 0) {
            return;
        }

        System.out.println("Hello from Thread " + num + "" );
        ReverseHello newTread = new ReverseHello(num - 1);
        newTread.start();
    }

    public static void main(String[] args) {
        ReverseHello test = new ReverseHello(50);
        test.start();
    }
}

