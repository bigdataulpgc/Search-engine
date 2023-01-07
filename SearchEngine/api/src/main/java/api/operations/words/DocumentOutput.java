package api.operations.words;

import api.operations.Output;
import documentclasses.Metadata;

import java.util.HashSet;
import java.util.Set;

public class DocumentOutput implements Output {

    private Set<Metadata> books;
    private Set<String> words;

    public DocumentOutput(){
        this.books = new HashSet<>();
        this.words = new HashSet<>();
    }

    public DocumentOutput addBooks(Set<Metadata> books){
        this.books = books;
        return this;
    }

    public DocumentOutput addWords(Set<String> words){
        this.words = words;
        return this;
    }
}
