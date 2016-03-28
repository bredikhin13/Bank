package com.company;

public class BankAccount {
    private int balance;

    public BankAccount(){
        balance = 10;
    }
    public int getBalance() {
        return balance;
    }

    public void incBalance(int x){
        balance+=x;
    }

    public void decBalance(int x){
        balance-=x;
    }


}
