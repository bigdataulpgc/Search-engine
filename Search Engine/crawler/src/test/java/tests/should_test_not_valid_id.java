package tests;

import id_treatment.NotValidId;
import org.junit.Test;

import java.io.IOException;

public class should_test_not_valid_id {

    @Test
    public void testNotValidId() throws IOException {
        NotValidId notValidId = new NotValidId();

        for(int i: notValidId.getNotValidId()){
            System.out.println(i);
        }
    }
}
