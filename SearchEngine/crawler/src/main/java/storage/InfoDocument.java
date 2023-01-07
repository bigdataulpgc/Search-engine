package storage;

import java.util.Date;

public class InfoDocument {

    private int id;
    private String path;
    private Date date;

    public InfoDocument setId(int id) {
        this.id = id;
        this.setPath(id);
        return this;
    }

    public InfoDocument setPath(int id) {
        this.path = "https://www.gutenberg.org/files/" + id + "/" + id + "-0.txt";
        return this;
    }

    public InfoDocument setPath(String path) {
        this.path = path;
        return this;
    }

    public InfoDocument setDate(Date date) {
        this.date = date;
        return this;
    }

    public String toString(){
        return "Document id: " + id + "\n" +
                "Source: " + path + "\n" +
                "Moment of download: " + date.toString() + "\n";
    }
}
