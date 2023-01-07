package api.operations;

public class ErrorOutput implements Output {

    private String message;

    public ErrorOutput(String message) {
        this.message = message;
    }
}
