package benchmarking;
import documentclasses.Document;
import documents.DocumentDeserialize;
import documents.IndexedId;
import inverted_index.implementation.MapInvertedIndex;
import org.openjdk.jmh.annotations.*;
import controller.Controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class inverted_index_benchmark {

    public static final IndexedId indexedId = new IndexedId();
    public static DocumentDeserialize documentDeserialize = new DocumentDeserialize(indexedId);
    public static MapInvertedIndex invertedIndex = new MapInvertedIndex();
    public static Controller controller = new Controller(indexedId);
    public static List<Document> documents;

    static {
        documents = documentDeserialize.getDocuments();
    }

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 3, time = 1)
    @Warmup(iterations = 3, time = 1)
    public static void index_1_book() {
        int n_documents = 2;
        List<Document> documentList = new ArrayList<>();
        for (int i = 1; i < n_documents; i++){
            documentList.add(documents.get(i));
        }
        controller.invertedIndexOf(invertedIndex, documentList);
    }

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 3, time = 1)
    @Warmup(iterations = 3, time = 1)
    public static void index_5_book() {
        int n_documents = 5;
        List<Document> documentList = new ArrayList<>();
        for (int i = 1; i < n_documents; i++){
            documentList.add(documents.get(i));
        }
        controller.invertedIndexOf(invertedIndex, documentList);
    }

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 3, time = 1)
    @Warmup(iterations = 3, time = 1)
    public static void index_10_book() {
        int n_documents = 10;
        List<Document> documentList = new ArrayList<>();
        for (int i = 1; i < n_documents; i++){
            documentList.add(documents.get(i));
        }
        controller.invertedIndexOf(invertedIndex, documentList);
    }

    @Benchmark
    @Fork(value = 1)
    @Measurement(iterations = 3, time = 1)
    @Warmup(iterations = 3, time = 1)
    public static void index_20_book() {
        int n_documents = 20;
        List<Document> documentList = new ArrayList<>();
        for (int i = 1; i < n_documents; i++){
            documentList.add(documents.get(i));
        }
        controller.invertedIndexOf(invertedIndex, documentList);
    }


}

