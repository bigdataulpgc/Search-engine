package controller;

import documentclasses.Document;
import document_builder.GutenbergDocumentBuilder;
import idmanagment.IdReferences;
import storage.FileSystemStore;
import id_treatment.DownloadedId;
import id_treatment.NotValidId;
import web_connection.GutenbergSource;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GutenbergTask implements Task {

    private static final Logger LOGGER = Logger.getLogger("scheduler.run");
    private static final NotValidId notValidId = new NotValidId();
    private static final DownloadedId downloadedId = new DownloadedId();
    private static final IdReferences idReferences = new IdReferences();
    private final FileSystemStore fileSystemStore;

    public GutenbergTask (){
        this.fileSystemStore = new FileSystemStore();
    }

    @Override
    public void run(int idInit, int iterations) {

        LOGGER.setLevel(Level.INFO);

        GutenbergSource gutenbergSource = new GutenbergSource();

        for(int id = idInit; id < idInit + iterations; id++) {
            if(downloadedId.isIdDownloaded(id)) continue;
            if(notValidId.isNotValidId(id)) continue;

            try {

                String text = gutenbergSource.bookLoader(id);
                Document document = new GutenbergDocumentBuilder(text, id).build();
                fileSystemStore.store(document, id);
                downloadedId.addDownloadedId(id);
                idReferences.add(id, document.getSourceId());
                //Thread.sleep(60000);

            } catch (Exception e) {
                notValidId.addNotValidId(id);
            }
        }
    }

}
