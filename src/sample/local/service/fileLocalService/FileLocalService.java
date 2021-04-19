package sample.local.service.fileLocalService;

import javafx.scene.image.Image;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.List;

public interface FileLocalService {

    public List<Image> filesToImages(List<File> files);

    public void configureFileChooser(final FileChooser fileChooser);

    public List<File> sort(List<File> files);

}
