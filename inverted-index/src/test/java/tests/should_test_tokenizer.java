package tests;
import org.junit.Test;
import program.Tokenizer;
import java.io.IOException;

public class should_test_tokenizer {

    @Test
    public void tokenizer_test() throws IOException {
        Tokenizer tokenizer = new Tokenizer();
        String[] words = tokenizer.tokenize("hola, cómo estás?");
        for(String i: words){
            System.out.println(i);
        }
    }
}
