package api.operations.stats;

import api.operations.Output;
import api.service.parameter.Parameters;
import documentclasses.Metadata;
import utils.StopWords;
import utils.Tokenizer;
import utils.database.QueryDatabase;
import utils.database.QueryMetadataDatabase;
import java.util.*;
import java.util.stream.Collectors;

public class TitleWords implements Stat {

    private static final String STAT_PARAMETER = "numberWords";
    private static final Tokenizer TOKENIZER = new Tokenizer();

    private static final StopWords STOP_WORDS = new StopWords();
    private static final QueryDatabase QUERY_DATABASE = new QueryMetadataDatabase("/home/search-engine/disk/datamart/SQLite/gutenbergMetadata.db");

    @Override
    public Output execute(Parameters parameters) {
        Set<Metadata> books = new HashSet<>(QUERY_DATABASE.query("all", null));

        Map<String, Integer> words = new HashMap<>();

        for(Metadata metadata: books)
            process(words, metadata.getMetadata().get("title").get(0));

        words = filter(words, parameters.parameters().get(STAT_PARAMETER));

        return generateOutput(words);
    }

    private Map<String, Integer> filter(Map<String, Integer> words, String maxWords) {
        return words.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .limit(Integer.parseInt(maxWords))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    private void process(Map<String, Integer> words, String title) {
        for(String word: TOKENIZER.tokenize(title)){
            if(isWordNull(word)) continue;
            if(isStopWord(word)) continue;
            if(isWordOnMap(words, word)) words.put(word, words.get(word) + 1);
            else words.put(word, 1);
        }
    }

    private boolean isStopWord(String word) {
        return STOP_WORDS.containWord(word);
    }

    private static boolean isWordNull(String word) {
        return word.equals("");
    }

    private static boolean isWordOnMap(Map<String, Integer> words, String word) {
        return words.containsKey(word);
    }

    private Output generateOutput(Map<String, Integer> words) {
        StatOutput response = new StatOutput();
        words.keySet().forEach(word -> response.addResult(word, words.get(word)));
        return response;
    }
}
