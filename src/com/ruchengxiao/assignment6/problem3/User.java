package com.ruchengxiao.assignment6.problem3;

public class User {
    private String name;
    private int age;
    private String address;
    private String phoneNumber;
    private String bankAccountNumber;



    User(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
