package com.company;

import java.util.LinkedList;


public class Operator implements Runnable {
    private LinkedList<Client> clients = new LinkedList<>();
    private BankAccount account;
    private int waitCount;
    private String name;

    public Operator(String name, BankAccount bankAccount) {
        account = bankAccount;
        waitCount = 10;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (waitCount > 0) {
                if (clients.size() == 0) {
                    Thread.sleep(1000);
                    waitCount--;
                } else {
                    Client client = clients.pop();
                    int clientWait = 5;
                    if (client.getSum() < 0) {
                        while (account.getBalance() + client.getSum() < 0 && clientWait > 0) {
                            Thread.sleep(1000);
                            clientWait--;
                            System.out.println(client.getName() + " waiting " + clientWait);
                        }
                        if (account.getBalance() + client.getSum() > 0) {
                            account.decBalance(-1 * client.getSum());
                            System.out.println(name + "->" + client.getName() + ":" + account.getBalance() + " sum:" + client.getSum() + " time:" + client.getTime());
                            waitCount = 10;
                            Thread.sleep(client.getTime() * 1000);
                        } else {
                            System.out.println(client.getName() + "No money - no honey:" + account.getBalance() + ":" + client.getSum());
                        }
                    } else {
                        account.incBalance(client.getSum());
                        System.out.println(name + "->" + client.getName() + ":" + account.getBalance() + " sum:" + client.getSum() + " time:" + client.getTime());
                        waitCount = 10;
                        Thread.sleep(client.getTime() * 1000);
                    }

                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("No clients on " + name + ". Good bye!");
        System.out.println(account.getBalance());

    }

    public String getName() {
        return name;
    }

    public int getClintCount() {
        return clients.size();
    }

    public void addClient(Client client) {
        clients.add(client);
    }
}
