package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        ArrayList<Operator> operators = new ArrayList<>();
        operators.add(new Operator("Operator1",bankAccount));
        operators.add(new Operator("Operator2",bankAccount));
        operators.add(new Operator("Operator3",bankAccount));
        for (Operator operator : operators) {
            Thread thread = new Thread(operator);
            thread.start();
        }
        ClientQueue clientQueue = new ClientQueue(1,operators);
        Thread thread = new Thread(clientQueue);
        thread.start();
    }
}
