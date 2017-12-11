/* Good Work
 * Score 10 + extra credit 2; Total score 10
 */
package com.ruchengxiao.assignment6.problem3;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Atm {
    long availableAmountInMachine; // should be private
    long transactionFee;
    List<UserData> userData;

    Atm(long availableAmountInMachine, long transactionFee) {
        userData = new ArrayList<>();
        this.availableAmountInMachine = availableAmountInMachine;
        this.transactionFee = transactionFee;
    }

    public void start() {
        System.out.println("Are you a new user or a current user? If you are new user please enter "
                + "1, " + "or enter " + "2");
        Scanner reader = new Scanner(System.in);

        while (true) {
            String str = reader.next();
            if (str.equals("1")) {
                System.out.println("Please enter your Bank Account Number:");
                String bankAccountNumber = reader.next();
                System.out.println("Please enter your password:");
                String password = reader.next();
                createNewUser(bankAccountNumber, password);
                break;
            } else if (str.equals("2")) {
                while (true) {
                    System.out.println("Do you forget your password ? Enter " +
                            "\"Yes\" or \"No\"");
                    String answer = reader.next();
                    if (answer.toLowerCase().equals("no")) {
                        //login
                        while(true) {
                            System.out.println("Please enter your bank account number:");
                            String phoneNumber = reader.next();
                            System.out.println("Please enter your password:");
                            String password = reader.next();
                            if (login(phoneNumber, password)) {
                                System.out.println("Login successful!");
                                function(reader, phoneNumber);
                                break;
                            } else {
                                System.out.println("Login failed.");
                                while (true) {
                                    System.out.println("Do you want to login again? " + "Enter " +
                                            "\"Yes\" or \"No\"");
                                    String answer1 = reader.next();
                                    if (answer1.toLowerCase().equals("yes")) {
                                        break;
                                    } else if (answer1.toLowerCase().equals("no")) {
                                        return;
                                    } else {
                                        System.out.println("What you enter is invalid, please enter again.");
                                    }
                                }
                            }
                        }

                        break;
                    } else if (answer.toLowerCase().equals("yes")) {
                        //forget password
                        System.out.println("We should verify your information to help you reset "
                                + "the password.");
                        while (true) {
                            //change password
                            System.out.println("Please enter your name:");
                            String name = reader.next();
                            System.out.println("Please enter your age:");
                            String age = reader.next();
                            System.out.println("Please enter your phone number:");
                            String phoneNumber = reader.next();

                            if (verifyIdentity(name, Integer.parseInt(age), phoneNumber)) {
                                System.out.println("Tell me your new password ");
                                String newPassword = reader.next();
                                changePassword(phoneNumber, newPassword);
                                break;
                            } else {
                                System.out.println("Reset failed.");
                                while (true) {
                                    System.out.println("Do you want to reset password again? "
                                            + "Enter " + "\"Yes\" or \"No\"");
                                    String answer1 = reader.next();
                                    if (answer1.toLowerCase().equals("yes")) {
                                        break;
                                    } else if (answer1.toLowerCase().equals("no")) {
                                        return;
                                    } else {
                                        System.out.println("What you enter is invalid, please enter again.");
                                    }
                                }
                            }
                        }
                        break;
                    } else {
                        System.out.println("What you enter is invalid");
                    }
                }
                break;
            } else {
                System.out.println("What you enter is invalid, please enter again.");
            }
        }

    }

    private void function(Scanner reader, String phoneNumber) {
        System.out.println("Choose a option with its number");
        System.out.println("1: Available Balance");
        System.out.println("2: Withdrawal");
        System.out.println("3: Deposit");
        System.out.println("4: Recent Transactions");
        System.out.println("5: Change Password");
        System.out.println("6: Exit");

        String option = null;
        while (true) {
            while (true) {
                option = reader.next();
                if (option.matches("[0-6]")) {
                    switch (Integer.parseInt(option)) {
                        case 1:
                            System.out.println("Balance: " + availableBalance(phoneNumber));
                            break;
                        case 2:
                            System.out.println("How much do you want to withdraw");
                            String amountWithdrawl = reader.next();
                            int amountNumber1 = Integer.parseInt(amountWithdrawl);
                            withDrawl(phoneNumber, amountNumber1);
                            break;
                        case 3:
                            System.out.println("How much do you want to deposit");
                            String amountDeposit = reader.next();
                            int amountNumber2 = Integer.parseInt(amountDeposit);
                            deposit(phoneNumber, amountNumber2);
                            break;
                        case 4:
                            recentTransactions(phoneNumber);
                            break;
                        case 5:
                            System.out.println("Tell me your new password");
                            String newPassword = reader.next();
                            changePassword(phoneNumber, newPassword);
                            break;
                        case 6:
                            return;
                    }
                    break;
                } else {
                    System.out.println("Please enter the number between 1 to 6");
                }
            }

            System.out.println("What else do you want to do?");
        }


    }

    void createNewUser(String bankAccountNumber, String password) {
        userData.add(new UserData(new User(bankAccountNumber), password));
    }


    boolean login(String bankAccountNumber, String password) {
        for (UserData u : userData) {
            if (u.getUser().getBankAccountNumber().equals(bankAccountNumber)) {
                if (u.getPassword().equals(password)) {
                    return true;
                } else {
                    System.out.println("Your password is wrong");
                    return false;
                }
            }
        }

        System.out.println("Can not find your phone number");
        return false;
    }

//    private void forgetPassword(String name, int age, String phoneNumber, String newPassword) {
//        if (verifyIdentity(name, age, phoneNumber)) {
//            changePassword(phoneNumber, newPassword);
//            System.out.println("");
//            return true;
//        }
//
//        return false;
//    }

    boolean verifyIdentity(String name, int age, String phoneNumber) {
        for (UserData u : userData) {
            if (u.getUser().getName().equals(name)) {
                if (u.getUser().getAge() == age && u.getUser().getPhoneNumber() == phoneNumber) {
                    return true;
                }

                break;
            }
        }

        System.out.println("Verify failed!!!");
        return false;

    }

    void changePassword(String bankAccountNumber, String newPassword) {
        for (UserData u : userData) {
            if (u.getUser().getBankAccountNumber().equals(bankAccountNumber)) {
                u.setPassword(newPassword);
                System.out.println("Change successful!!");
                return;
            }
        }

    }



    long availableBalance(String bankAccountNumber) {
        for (UserData u : userData) {
            if (u.getUser().getBankAccountNumber().equals(bankAccountNumber)) {
                return u.getAvailableBalance();
            }
        }

        return 0;
    }

    void withDrawl(String bankAccountNumber, long amount) {
        for (UserData u : userData) {
            if (u.getUser().getBankAccountNumber().equals(bankAccountNumber)) {
                if (this.availableAmountInMachine + this.transactionFee < amount) {
                    System.out.println("The money in this machine is not enough.");
                    break;
                }

                u.setAvailableBalance(u.getAvailableBalance() - amount - this.transactionFee);
                u.setRecentTransaction("WithDrawl" + " - " + amount);
                this.availableAmountInMachine -= amount + this.transactionFee;
                break;
            }
        }
    }

    void deposit(String bankAccountNumber, long amount) {
        for (UserData u : userData) {
            if (u.getUser().getBankAccountNumber().equals(bankAccountNumber)) {
                u.setAvailableBalance(u.getAvailableBalance() + amount - this.transactionFee);
                u.setRecentTransaction("Deposit" + " - " + amount);
                //System.out.println(u.getRecentTransaction());
                this.availableAmountInMachine += amount + this.transactionFee;
                break;
            }
        }

    }

    List<String> recentTransactions(String bankAccountNumber) {
        List<String> result = new ArrayList<>();
        for (UserData u : userData) {
            if (u.getUser().getBankAccountNumber().equals(bankAccountNumber)) {
                if (u.getRecentTransaction().size() >= 10) {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(u.getRecentTransaction().
                                            get(u.getRecentTransaction().size() - 1 - i));
                    }
                } else {
                    for (int i = u.getRecentTransaction().size() - 1; i >= 0; i--) {
                        System.out.println(u.getRecentTransaction().get(i));
                    }
                }

                result = u.getRecentTransaction();
                return result;
            }
        }

        return result;
    }
}
