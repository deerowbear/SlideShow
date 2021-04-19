package sample.local.service.fileLocalService;

import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import sample.local.service.comparators.FileNameComparator;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileLocalServiceImpl implements FileLocalService {

    /**
     * Convenience method to convert files to javafx images
     * @param files
     * @return List<Images></>
     *
     */
    @Override
    public List<Image> filesToImages(List<File> files) {
        List<Image> images = new ArrayList<>();
        for(File file : files) {
            images.add(new Image(file.toURI().toString()));
        }
        return images;
    }

    /**
     * Method to configure a file chooser to enforce that jpgs are all that can be selected
     * @param fileChooser
     */
    @Override
    public void configureFileChooser(FileChooser fileChooser) {
        fileChooser.setTitle("Select images");
        fileChooser.setInitialDirectory(
                new File("C:/Users/maryc/SlideShow/src/sample/resources/images")
        );
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG", "*.jpg"));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPEG", "*.jpeg"));
    }

    /**
     * Convenience to sort files by file name.
     *
     * @param files
     * @return
     */
    public List<File> sort(List<File> files) {
        FileNameComparator comparator = new FileNameComparator();
        comparator.setAscending(Boolean.TRUE);
        List<File> modifiableList = new ArrayList<File>(files);
        Collections.sort(modifiableList , comparator);
        return modifiableList;
    }

}
