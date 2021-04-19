package sample.local.service.fileLocalService;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class FileLocalServiceImplTest extends ApplicationTest {

    List<File> files;
    FileLocalService fileLocalService = new FileLocalServiceImpl();

    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
    }

    @Before
    public void setUp() throws Exception {
        files = new ArrayList<>();
        files.add(new File("/src/sample/resources/images/bb.jpg"));
        files.add(new File("/src/sample/resources/images/aa.jpg"));
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testFilesToImagesTrue() {
        List<Image> images = fileLocalService.filesToImages(files);
        assertEquals(2, images.size());
    }

    @Test
    public void testFilesToImagesFalse() {
        List<Image> images = fileLocalService.filesToImages(files);
        assertNotSame(3, images.size());
    }
}