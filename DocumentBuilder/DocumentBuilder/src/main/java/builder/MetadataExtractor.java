package builder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class MetadataExtractor {

    public String text;
    public Metadata metadata;

    public MetadataExtractor(String text) throws InvocationTargetException, IllegalAccessException {
        this.text = text;
        this.metadata = new Metadata();
        for (Method method: this.getClass().getDeclaredMethods())
            System.out.println(method);
    }

    public Metadata getMetadata() {
        return this.metadata;
    }

    public void extractTitle(){

    }

    public void extractAuthors(){

    }

    public void extractReleaseDate(){

    }

    public void extractPostingDate(){

    }

    public void extractLanguage(){

    }
}
