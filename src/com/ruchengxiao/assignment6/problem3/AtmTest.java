package com.ruchengxiao.assignment6.problem3;

import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class AtmTest {
    public static void main(String[] args) {
        Atm test = new Atm(1000, 10);

        User user = new User("123");
        user.setPhoneNumber("2067396912");
        user.setAge(28);
        user.setName("Shawn");
        UserData userData = new UserData(user, "123456789");
        test.userData.add(userData);
        //test.start();

        String bankAccountNumber = "123456789";
        String password = "123456789";
        testCreateNewUser(test, bankAccountNumber, password);
        bankAccountNumber = "123456789";
        password = "123456789";
        testLogin(test, bankAccountNumber, password);
        String name = "Shawn";
        String age = "28";
        String phoneNumber = "2067396912";
        String newPassword = "987654321";
        testForgetPassword(test, name, age, bankAccountNumber, phoneNumber, newPassword);
        long amount = 10000;
        testDeposit(test, bankAccountNumber, amount);
        amount = 1000;
        testWithdrawl(test, bankAccountNumber, amount);
        testRecentTransactions(test, bankAccountNumber);
        newPassword = "0987654321";
        testChangePassword(test, bankAccountNumber, newPassword);

        System.out.println("\n\nCongratulations, all tests have been passed");
    }

    @Test
    public static void testCreateNewUser(Atm test, String bankAccountNumber, String password) {
        test.createNewUser(bankAccountNumber, password);
        UserData output = test.userData.get(test.userData.size() - 1);
        //System.out.println(test.userData.get(test.userData.size() - 1).getPassword());
        UserData expectedOutput = new UserData(new User(bankAccountNumber), password);
        Assertions.assertEquals(expectedOutput.getUser().getBankAccountNumber(),
                                output.getUser().getBankAccountNumber());
        Assertions.assertEquals(expectedOutput.getPassword(), output.getPassword());
    }

    @Test
    public static void testLogin(Atm test, String bankAccountNumber, String password) {
        boolean output = test.login(bankAccountNumber, password);
        boolean expectedOutput = true;
        Assertions.assertEquals(expectedOutput, output);
    }

    @Test
    public static void testForgetPassword(Atm test, String name, String age, String bankAccountNumber,
                                          String phoneNumber, String newPassword) {
        boolean output1 = test.verifyIdentity(name, Integer.parseInt(age), phoneNumber);
        boolean expectedOutput1 = true;
        Assertions.assertEquals(expectedOutput1, output1);

        test.changePassword(bankAccountNumber, newPassword);
        String output2 = "";
        for (UserData userData : test.userData) {
            if (userData.getUser().getBankAccountNumber().equals(bankAccountNumber)) {
                output2 = userData.getPassword();
                break;
            }
        }
        String expectedOutput2 = "987654321";
        Assertions.assertEquals(expectedOutput2, output2);
    }

    @Test
    public static void testChangePassword(Atm test, String bankAccountNumber, String newPassword) {
        test.changePassword(bankAccountNumber, newPassword);
        String output = "";
        for (UserData userData : test.userData) {
            if (userData.getUser().getBankAccountNumber().equals(bankAccountNumber)) {
                output = userData.getPassword();
                break;
            }
        }
        String expectedOutput = "0987654321";
        Assertions.assertEquals(expectedOutput, output);
    }
    @Test
    public static void testDeposit(Atm test, String bankAccountNumber, long amount) {
        test.deposit(bankAccountNumber, amount);
        testAvailableBalance(test, bankAccountNumber, 9990);
    }
    @Test
    public static void testWithdrawl(Atm test, String bankAccountNumber, long amount) {
        test.withDrawl(bankAccountNumber, amount);
        testAvailableBalance(test, bankAccountNumber, 9000);
    }

    @Test
    public static void testRecentTransactions(Atm test, String bankAccountNumber) {
        List<String> output = test.recentTransactions(bankAccountNumber);
        List<String> expectedOutput = new ArrayList<>();
        expectedOutput.add("Deposit" + " - " + 10000);
        expectedOutput.add("WithDrawl" + " - " + 1000);
        for (int i = 0; i < expectedOutput.size(); i++) {
            Assertions.assertEquals(expectedOutput.get(i), output.get(i));
        }

    }
    @Test
    public static void testAvailableBalance(Atm test, String bankAccountNumber, long amount) {
        long output = test.availableBalance(bankAccountNumber);
        long expectedOutput = amount;
        System.out.println(output);
        Assertions.assertEquals(expectedOutput, output);
    }

}
