package program;

public class Tokenizer {

    public String[] tokenize(String line){

        String punctuation = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

        for(int punct=0; punct<punctuation.length(); punct++){
            line = line.replace(String.valueOf(punctuation.charAt(punct)), "");
        }

        return line.strip().toLowerCase().split(" ");
    }
}
