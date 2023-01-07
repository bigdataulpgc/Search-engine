package api.service;


import api.operations.stats.StatsController;
import api.operations.words.DocumentSearcher;

public class Main {

    public static void main(String[] args) {

        GutenbergApiRest gutenbergApiRest = new GutenbergApiRest();
        gutenbergApiRest.addResponse("documents", new DocumentSearcher());
        gutenbergApiRest.addResponse("stats", new StatsController());
        gutenbergApiRest.start();

    }
}