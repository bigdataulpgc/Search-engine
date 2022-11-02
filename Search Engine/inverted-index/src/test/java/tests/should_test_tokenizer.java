package tests;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import utils.Tokenizer;

public class should_test_tokenizer {

    @Test
    public void simple_punctuation_marks_tokenizer_test() {
        Tokenizer tokenizer = new Tokenizer();
        String[] words = tokenizer.tokenize("hola, cómo; estás? palabra");
        String[] resultado = {"hola", "cómo", "estás", "palabra"};
        Assertions.assertThat(words).isEqualTo(resultado);
    }

    @Test
    public void simple_number_tokenizer_test() {
        Tokenizer tokenizer = new Tokenizer();
        String[] words = tokenizer.tokenize("problem 1 2 3");
        String[] resultado = {"problem"};
        Assertions.assertThat(words).isEqualTo(resultado);
    }

    @Test
    public void complex_punctuation_marks_tokenizer_test() {
        Tokenizer tokenizer = new Tokenizer();
        String[] words = tokenizer.tokenize("That's imposible! Are you sure about that? Probably, he's going to tell you about that \t" +
                "problem: 1, 2, 3. ");
        String[] resultado = {"thats", "imposible", "are", "you", "sure", "about", "that", "probably", "hes", "going", "to", "tell", "you", "about", "that", "problem"};
        Assertions.assertThat(words).isEqualTo(resultado);
    }
}
