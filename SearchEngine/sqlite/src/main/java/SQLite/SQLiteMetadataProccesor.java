package SQLite;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLiteMetadataProccesor {

    private static final Pattern REGULAR_PATTERN = Pattern.compile("[A-Za-z]+( )[0-9]{1,2}, [0-9]{4}");
    private static final DateTimeFormatter FORMATTER1 = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
    private static final DateTimeFormatter FORMATTER2 = DateTimeFormatter.ofPattern("MMMM, yyyy", Locale.ENGLISH);


    private static final HashMap<String, Processor>
            processorMap =  new HashMap<>(){{
        put("Release Date", date -> {
            Matcher matcher = REGULAR_PATTERN.matcher(date);
           if(matcher.matches()) return LocalDate.parse(date, FORMATTER1);
           else return LocalDate.parse(date, FORMATTER2);
        });
        put("Posting Date", date -> {
            Matcher matcher = REGULAR_PATTERN.matcher(date);
            if(matcher.matches()) return LocalDate.parse(date, FORMATTER1);
            else return LocalDate.parse(date, FORMATTER2);
        });
        put("Authors", authors -> {
            StringBuilder result = new StringBuilder();
            authors = authors.replaceAll("\\[", "").replaceAll("]", "");
            for(String author: authors.split(", ")) result.append(author).append("\n");
            return result.toString();
        });

    }};

    public Object process(String variable, List<String> content){
        if(content.size() == 1) return processorMap.getOrDefault(variable, value -> value).process(content.get(0));
        else return processorMap.get(variable).process(content.toString());
    }

    interface Processor {
        Object process(String content);
    }
}
