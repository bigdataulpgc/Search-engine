package utils;

public class Tokenizer {

    public String[] tokenize(String line) {
        line = cleanSymbols(line);
        line = cleanTabulation(line);
        return line.trim().toLowerCase().split(" ");
    }

    private static String cleanTabulation(String line) {
        return line.replaceAll("[\t\\x0B\f]", "");
    }

    private static String cleanSymbols(String line) {
        return line.replaceAll("((?![A-Za-z áéíóú]).)", "");
    }
}