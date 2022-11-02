package id_treatment;

import storage.FilePersister;

import java.io.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class NotValidId {

    private static final String PATH = ".\\crawler\\not_valid_id_path.tsv";
    private Set<Integer> notValidId;
    private FilePersister filePersister;

    public NotValidId() {
        this.filePersister = new FilePersister(new File(PATH));
        try {
            this.notValidId = readLines(new File(PATH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Set<Integer> readLines(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Set<Integer> set = new HashSet<>();
        String linea = bufferedReader.readLine();
        if (Objects.equals(null, linea)) return new HashSet<>();
        for(String i: linea.split("\t")){
            set.add(Integer.parseInt(i));
        }
        return set;
    }

    public Set<Integer> getNotValidId() {
        return notValidId;
    }

    public void addNotValidId (int id){
        notValidId.add(id);
        filePersister.persist(id + "\t");
    }

    public boolean isNotValidId(int id){
        return notValidId.contains(id);
    }
}
