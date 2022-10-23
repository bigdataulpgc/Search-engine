package builder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;


public class MetadataExtractor {

    public static DateFormat FORMAT_WITH_DAY = new SimpleDateFormat("MMMMd,yyyy", Locale.ENGLISH);
    public static DateFormat FORMAT_WITHOUT_DAY = new SimpleDateFormat("MMMM,yyyy", Locale.ENGLISH);
    public String metadataText;
    public Metadata metadata;


    public MetadataExtractor(String text) throws InvocationTargetException, IllegalAccessException {
        this.metadata = new Metadata();
        this.metadataText = text.split("\\*")[0];
        for (Method method: this.getClass().getDeclaredMethods())
            method.invoke(this);

    }

    public Metadata getMetadata() {
        return this.metadata;
    }

    public void extractTitle(){
        String[] metadataArray = this.metadataText.split(":");
        for(int i = 0; i < metadataArray.length; i++){
            if(metadataArray[i].replaceAll("\n", "").matches(".*Title.*")){
                StringBuilder title = new StringBuilder();
                for(String titlePart: metadataArray[i+1].split("\n")){
                    if(titlePart.equals("")) break;
                    title.append(titlePart.trim()).append(" ");
                }
                this.metadata.setTitle(title.toString().trim());
                break;
            }
        }
    }

    public void extractAuthors(){
        String[] metadataArray = this.metadataText.split(":");
        for(int i = 0; i < metadataArray.length; i++) {
            if (metadataArray[i].replaceAll("\n", "").matches(".*Author.*")) {
                for(String author: metadataArray[i+1].split("\n")){
                    if(author.equals("")) break;
                    this.metadata.addAuthors(author.trim());
                }
                break;
            }
        }
    }

    public void extractReleaseDate() throws ParseException {
        String[] metadataArray = this.metadataText.split(":");
        for(int i = 0; i < metadataArray.length; i++){
            if(metadataArray[i].replaceAll("\n", "").matches(".*Release Date.*")){
                String[] dateParts = metadataArray[i+1].split(" ");
                if (dateParts[2].equals(",")) this.metadata.setReleaseDate(FORMAT_WITHOUT_DAY
                        .parse(dateParts[1] + dateParts[2] + dateParts[3]));
                else this.metadata.setReleaseDate(FORMAT_WITH_DAY
                        .parse(dateParts[1] + dateParts[2] + dateParts[3]));
                break;
            }
        }
    }

    public void extractPostingDate() throws ParseException {
        String[] metadataArray = this.metadataText.split(":");
        for(int i = 0; i < metadataArray.length; i++){
            if(metadataArray[i].replaceAll("\n", "").matches(".*Posting Date.*")){
                String[] dateParts = metadataArray[i+1].split(" ");
                if (dateParts[2].equals(",")) this.metadata.setReleaseDate(FORMAT_WITHOUT_DAY
                        .parse(dateParts[1] + dateParts[2] + dateParts[3]));
                else this.metadata.setReleaseDate(FORMAT_WITH_DAY
                        .parse(dateParts[1] + dateParts[2] + dateParts[3]));
                break;
            }
        }
    }

    public void extractLanguage(){
        String[] metadataArray = this.metadataText.split(":");
        for(int i = 0; i < metadataArray.length; i++){
            if(metadataArray[i].replaceAll("\n", "").matches(".*Language.*")){
                this.metadata.setLanguage(metadataArray[i+1].split("\n")[0].trim());
                break;
            }
        }
    }
}
