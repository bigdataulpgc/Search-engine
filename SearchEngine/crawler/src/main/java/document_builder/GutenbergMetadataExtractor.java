package document_builder;

import documentclasses.Metadata;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class GutenbergMetadataExtractor implements MetadataExtractor{

    private static final Pattern PATTERN = Pattern.compile("[A-Za-z]+( )*[0-9]{0,2}, [0-9]{4}");
    private static final Map<String, AttributeExtractor> extractorMap = new HashMap<>(){{
        put("Authors", content -> List.of(content.split(",")));
        put("Illustrators", content -> List.of(content.split(",")));
        put("Release Date", content -> {
            Matcher matcher = PATTERN.matcher(content);
            matcher.find();
            return List.of(matcher.group());
        });
        put("Posting Date", content -> {
            Matcher matcher = PATTERN.matcher(content);
            matcher.find();
            return List.of(matcher.group());
        });
    }};

    private final String content;
    private String currentMetadata;
    private String currentValue;
    Map<String, List<String>> map = new HashMap<>();

    public GutenbergMetadataExtractor(String content) {
        this.content = content;
    }

    @Override
    public Metadata extractMetadata() {
        Stream.of(content.split("\n")).forEach(this::processLine);
        if (currentMetadata != null) saveCurrentMetadata();
        return new Metadata(this.map);

    }

    private void processLine(String line) {
        String[] splitLine = line.split(": ");
        if (isMetadataStarting(splitLine)){
            if (currentMetadata != null) saveCurrentMetadata();
            currentMetadata = splitLine[0];
            currentValue = splitLine[1].replaceAll("\r", "");
        } else {
            if(extractorMap.containsKey(currentMetadata)) currentValue += "," + line.trim();
            else currentValue += " " + line.trim();
        }
    }

    private static boolean isMetadataStarting(String[] splitLine) {
        return splitLine.length > 1;
    }

    private void saveCurrentMetadata() {
        currentValue = currentValue.trim();
        map.put(currentMetadata, extractorMap.getOrDefault(currentMetadata, List::of).extract(currentValue));
    }

    interface AttributeExtractor {
        List<String> extract(String value);
    }
}
