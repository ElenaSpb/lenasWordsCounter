package services;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class FileServiceTest {

    @Test
    public void getContent() {
        try {

            String res = FileService.getContent("C:\\sample.txt");
            Assert.assertFalse(res.isEmpty());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}