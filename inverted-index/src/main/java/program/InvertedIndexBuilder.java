package program;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import classes.Document;

public class InvertedIndexBuilder {

    InvertedIndex invertedIndex;

    public InvertedIndexBuilder(InvertedIndex invertedIndex){
        this.invertedIndex = invertedIndex;
    }

    String[] stop_words = {",", "w"};

    public void build(Document document) throws IOException {

        Tokenizer tokenizer = new Tokenizer();
        int n_line = 0;
        String [] list_words = null;

        BufferedReader br = new BufferedReader(new FileReader(document.getContent()));
        String line = br.readLine();

        while(line != null) {
            n_line += 1;
            list_words = tokenizer.tokenize(line);
            for (String word : list_words) {

                //if (!stop_words.contain(word) & word.length() != 0) {
                //    invertedIndex.addWord(word, document.getMetadata().getId(), n_line);
                //}

            }
            line = br.readLine();
        }
    }
}
