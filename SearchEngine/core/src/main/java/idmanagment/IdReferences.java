package idmanagment;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import persistence.FilePersister;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;

public class IdReferences {

    private static final String PATH = "/home/search-engine/disk/id/idReferences/id_references.json";
    private References reference;
    private FilePersister persister;

    public IdReferences(){
        this.persister = new FilePersister(new File(PATH));
        try {
            this.load();
        } catch (IOException e) {
            reference(new References());
        }
    }

    public void add(int idGutenberg, String uuid){
        reference.references().put(uuid, idGutenberg);
        save();
    }

    public Integer get(String uuid){
        return reference.references().get(uuid);
    }

    public String get(int id) {
        String uuidResponse = null;
        for(String uuid: reference.references().keySet())
            if (reference.references().get(uuid) == id) {
                uuidResponse = uuid;
                break;
            }
        return uuidResponse;
    }

    public void save(){
        String referencesSerielized = serialize();
        persister.persist(referencesSerielized, false);

    }

    private String serialize() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(reference);
    }

    public void load() throws IOException {
        String StringReferences = readReference();
        reference(new Gson().fromJson(StringReferences, References.class));
    }

    private static String readReference() throws IOException {
        return Files.readString(new File(PATH).toPath());
    }

    public HashMap<String, Integer> reference() {
        return reference.references();
    }

    public void reference(References newReference) {
        this.reference = newReference;
    }

    private static class References{
        private final HashMap<String, Integer> references;

        public References(){
            this.references = new HashMap<>();
        }

        public HashMap<String, Integer> references() {
            return references;
        }
    }


}
