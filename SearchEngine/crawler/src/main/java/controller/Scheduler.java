package controller;

import java.util.HashMap;
import java.util.Map;

public class Scheduler {

    private static final Map<String, Task> sourceMap = new HashMap<>(){{
       put("Gutenberg", new GutenbergTask());
    }};
    private long delay;
    private int idInit;
    private int iterations;
    private String source;

    public Scheduler(long delay, int idInit, int iterations, String source) {
        this.delay = delay;
        this.idInit = idInit;
        this.iterations = iterations;
        this.source = source;
    }

    public void generateTasks() throws Exception {

        Task task = sourceMap.get(source);
        Thread.sleep(delay);
        task.run(idInit, iterations);

    }
}
