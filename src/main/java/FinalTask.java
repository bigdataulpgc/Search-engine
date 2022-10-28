import java.util.TimerTask;

public class FinalTask extends TimerTask {

    public FinalTask() {
    }

    @Override
    public void run() {
        System.out.println("Se lanzó la tarea.");
    }
}
