import java.util.Timer;

public class Scheduler {

    private long delay;
    private long period;
    private String source;

    public Scheduler(long delay, long period, String source) {
        this.delay = delay;
        this.period = period;
        this.source = source;
        Timer time = new Timer();
        FinalTask task = new FinalTask();
        time.schedule(task, this.delay, this.period);
    };
}
