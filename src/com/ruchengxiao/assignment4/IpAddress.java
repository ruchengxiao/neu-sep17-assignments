package com.ruchengxiao.assignment4;

import java.util.Arrays;

public class IpAddress {
    String dottedDecimal;
    int[] fourOctets;

    public String getDottedDecimal() {
        return dottedDecimal;
    }

    public IpAddress(String dottedDecimal) {
        this.dottedDecimal = dottedDecimal;
        fourOctets = new int[4];
        String[] newStr = dottedDecimal.split("\\.");
        for (int i = 0; i < newStr.length; i++) {
            fourOctets[i] = Integer.parseInt(newStr[i]);
        }
    }

    public int getOctet(int position) {
        return fourOctets[position - 1];
    }

    public static void main(String[] args) {

        IpAddress ip = new IpAddress("216.27.6.136");
        System.out.println(ip.getDottedDecimal());
        System.out.println(ip.getOctet(4));
        System.out.println(ip.getOctet(1));
        System.out.println(ip.getOctet(3));
        System.out.println(ip.getOctet(2));
    }

}
