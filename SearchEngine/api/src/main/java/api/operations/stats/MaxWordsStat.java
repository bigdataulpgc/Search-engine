package api.operations.stats;

import api.operations.ErrorOutput;
import api.operations.Output;
import api.service.parameter.Parameters;
import idmanagment.IdReferences;
import utils.StopWords;
import utils.Tokenizer;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MaxWordsStat implements Stat{
    
    private static final String FILE_PARAMETER = "file";
    private static final String NUM_PARAMETER = "num";
    private static final Tokenizer TOKENIZER = new Tokenizer();
    private static final StopWords STOP_WORDS = new StopWords();
    private static final IdReferences ID_REFERENCES = new IdReferences();
    private static final String PATH = "/home/search-engine/disk/datalake/documents";

    @Override
    public Output execute(Parameters parameters) {

        String uuid = getId(parameters);
        if (uuid == null) return new ErrorOutput("Book required not in the database");
        String path = getPath(uuid);
        String[] text = readFile(new File(path));
        Map<String, Integer> words = countWords(text);
        return generateOutput(filter(words, parameters.parameters().get(NUM_PARAMETER)));
    }

    private static String getId(Parameters parameters) {
        return ID_REFERENCES.get(Integer.parseInt(parameters.parameters().get(FILE_PARAMETER)));
    }


    private static Map<String, Integer> countWords(String[] text) {
        Map<String, Integer> words = new HashMap<>();
        for (String word: text){
            if (isSpamWord(word)) continue;
            if (words.containsKey(word)) words.put(word, words.get(word) + 1);
            else words.put(word, 1);
        }
        return words;
    }

    private static boolean isSpamWord(String word) {
        return word.equals("") || STOP_WORDS.containWord(word);
    }

    private static String getPath(String fileName) {
        String path = "";
        for(File files: new File(PATH).listFiles()){
            for(File file: files.listFiles()){
                if (file.getName().equals(fileName)){
                    path = PATH + "/" + files.getName() + "/" + file.getName() + "/" + file.getName() + ".txt";
                }
            }
        }
        return path;
    }

    public String[] readFile(File file) {
        StringBuilder text = new StringBuilder();

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())
                text.append(scanner.nextLine()).append("\n");
        } catch (Exception ignored) {}

        return TOKENIZER.tokenize(text.toString());
    }

    private HashMap<String, Integer> filter(Map<String, Integer> words, String maxWords) {
        return words.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .limit(Integer.parseInt(maxWords))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    private Output generateOutput(Map<String, Integer> words) {
        StatOutput response = new StatOutput();
        for(String value: words.keySet()) response.addResult(value, words.get(value));
        return response;
    }
}
