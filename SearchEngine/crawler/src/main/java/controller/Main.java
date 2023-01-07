package controller;


public class Main {

    public static void main(String[] args) throws Exception {

        Configuration configuration = new Configuration();

        Scheduler scheduler = configuration.readConfigurationFile();

        scheduler.generateTasks();
    }
}

