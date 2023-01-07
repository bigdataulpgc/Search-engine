package controller;

import java.util.Timer;

public class Main {

    public static void main(String[] args){

        InvertedIndexTask task = new InvertedIndexTask();
        Timer timer = new Timer();
        Integer seconds = 60;

        timer.scheduleAtFixedRate(task, 0, 1000 * seconds);
    }
}
