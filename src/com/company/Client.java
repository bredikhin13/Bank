package com.company;

import java.util.Random;

public class Client {
    private int sum;
    private int time;
    private String name;

    public int getSum() {
        return sum;
    }

    public int getTime() {
        return time;
    }

    public String getName() {
        return name;
    }

    public Client(String name){
        Random random = new Random();
        sum = random.nextInt(200)-100;
        time = random.nextInt(7);
        this.name = name;
    }
}
