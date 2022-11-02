package id_treatment;

import storage.FilePersister;

import java.io.*;
import java.util.*;

public class DownloadedId {

    private static final String PATH = ".\\crawler\\downloades_id_path.tsv";
    private Set<Integer> downloadedId;
    private FilePersister filePersister;

    public DownloadedId() {
        this.filePersister = new FilePersister(new File(PATH)).createDirectory();
        try {
            this.downloadedId = readLines(new File(PATH));
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

    public Set<Integer> getDownloadedId() {
        return downloadedId;
    }

    public void addDownloadedId (int id){
        downloadedId.add(id);
        filePersister.persist(String.valueOf(id) + "\t");
    }

    public boolean isIdDownloaded(int id){
        return downloadedId.contains(id);
    }
}
