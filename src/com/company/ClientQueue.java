package com.company;

import java.util.ArrayList;
import java.util.Random;

public class ClientQueue implements Runnable{
    int timeSpan;
    static final int clientCount = 10;
    ArrayList<Operator> operators;
    public ClientQueue(int time, ArrayList<Operator> list){
        timeSpan = time;
        operators = list;
    }
    @Override
    public void run() {
        Operator operator = operators.get(0);
        Random random = new Random();
        for (int i = 0; i < clientCount; i++) {
            Client client = new Client("client"+i);
            for(Operator op:operators){
                if(op.getClientCount()<operator.getClientCount()){
                    operator = op;
                }
            }
            operator.addClient(client);

            try {
                Thread.sleep((random.nextInt(timeSpan)+1)*1000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
