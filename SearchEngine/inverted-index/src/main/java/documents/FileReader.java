package documents;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public String read(File file) throws FileNotFoundException {
        StringBuilder text = new StringBuilder();

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine())
            text.append(scanner.nextLine() + "\n");

        return text.toString();
    }
}
