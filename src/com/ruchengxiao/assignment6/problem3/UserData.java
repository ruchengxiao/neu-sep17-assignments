package com.ruchengxiao.assignment6.problem3;

import java.util.ArrayList;
import java.util.List;

class UserData {
    private User user;
    private String password;
    private long availableBalance;
    private List<String> recentTransaction;

    UserData(User user, String password) {
        this.user = user;
        this.password = password;
        recentTransaction = new ArrayList<>();
    }

    public List<String> getRecentTransaction() {
        return recentTransaction;
    }

    public User getUser() {
        return user;
    }

    public long getAvailableBalance() {
        return availableBalance;
    }

    public String getPassword() {
        return password;
    }

    public void setRecentTransaction(String recentTransaction) {
        this.recentTransaction.add(recentTransaction);
    }

    public void setAvailableBalance(long availableBalance) {
        this.availableBalance = availableBalance;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public void setUser(User user) {
//        this.user = user;
//    }
}
