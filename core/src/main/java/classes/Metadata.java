package classes;

import java.util.ArrayList;
import java.util.Date;

public class Metadata {

    private int id;
    private ArrayList<String> authors;
    private String title;
    private Date releaseDate;
    private Date postingDate;
    private String language;

    public Metadata(){
        this.authors = new ArrayList<String>();
    }
    public int getId() {
        return id;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public Date getPostingDate() {
        return postingDate;
    }

    public String getLanguage() {
        return language;
    }

    public Metadata setId(int id) {
        this.id = id;
        return this;
    }

    public Metadata addAuthors(String author) {
        this.authors.add(author);
        return this;
    }

    public Metadata setTitle(String title) {
        this.title = title;
        return this;
    }

    public Metadata setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public Metadata setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
        return this;
    }

    public Metadata setLanguage(String language) {
        this.language = language;
        return this;
    }
}
