package program;

import classes.Document;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Controller {

    public void invertedIndexOf(InvertedIndex inverted_index, String[] document_list) throws IOException {

        InvertedIndexBuilder inverted_index_builder = new InvertedIndexBuilder(inverted_index);

        for (int i=0;i<document_list.length;i++) {
            DocumentReader document_reader = new DocumentReader(document_list[i]);
            Document document = document_reader.read_document();
            inverted_index_builder.build(document);
        }

        //new InvertedIndexStore(inverted_index).store();

    }
}
