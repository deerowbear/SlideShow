package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.local.service.fileLocalService.FileLocalService;
import sample.local.service.fileLocalService.FileLocalServiceImpl;
import sample.local.service.ui.UiLocalService;
import sample.local.service.ui.UiLocalServiceImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class SlideShowController {
    public ImageView imageView;
    public Label fileNameLabel;
    final FileChooser fileChooser = new FileChooser();

    private FileLocalService fileLocalService = new FileLocalServiceImpl();
    private UiLocalService uiLocalService = new UiLocalServiceImpl();

    private List<File> files = new ArrayList<>();
    private List<Image> images;
    private Iterator<Image> imageIterator;
    private Timeline timeline;

    boolean isPaused = Boolean.FALSE;

    /**
     * Method to pause the timeline when the user selects the pause method
     * @param actionEvent
     */
    public void pause(ActionEvent actionEvent) {
        Parent parent = ((Node) actionEvent.getSource()).getParent();
        if(!isPaused) {
            timeline.pause();
            uiLocalService.setButtonTextById(parent, "pause", "Play");
            isPaused = Boolean.TRUE;
        }else{
            timeline.play();
            uiLocalService.setButtonTextById(parent, "pause", "Pause");
            isPaused = Boolean.FALSE;
        }
    }


    /**
     * Method to restart the timeline from the begining when restart button is pressed
     * @param actionEvent
     */
    public void restart(ActionEvent actionEvent) {
        /*this.timeline = null;
        imageIterator = images.iterator();
        this.createTimeLine();*/
        timeline.playFromStart();
    }

    /**
     * Method to create a slide show and play it when selected
     * @param actionEvent
     */
    public void createSlideShow(ActionEvent actionEvent) {
        Parent parent = ((Node) actionEvent.getSource()).getParent();
        uiLocalService.setDisabledButtonById(parent, "restart", Boolean.FALSE);
        uiLocalService.setDisabledButtonById(parent, "pause", Boolean.FALSE);
        uiLocalService.setDisabledButtonById(parent, "createSlideShow", Boolean.TRUE);
        this.createTimeLine();
    }

    /**
     * Method to create a browse menu that the user can select images with
     * @param actionEvent
     */
    public void selectFiles(ActionEvent actionEvent) {
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        Parent parent = ((Node) actionEvent.getSource()).getParent();
        fileLocalService.configureFileChooser(fileChooser);
        this.files =  fileLocalService.sort(fileChooser.showOpenMultipleDialog(stage));
        uiLocalService.setDisabledButtonById(parent, "createSlideShow", Boolean.FALSE);
        if (files != null) {
            if(timeline != null) {
                timeline.pause();
            }

            images = fileLocalService.filesToImages(files);
            imageIterator = images.iterator();
            imageView.setPreserveRatio(true);
            uiLocalService.setDisabledButtonById(parent, "restart", Boolean.TRUE);
            uiLocalService.setDisabledButtonById(parent, "pause", Boolean.TRUE);
        }
    }

    /**
     * Create a timeline that will cycle through the images and set a label with the file name
     */
    private void createTimeLine() {
        timeline = new Timeline(
                new KeyFrame(
                        Duration.ZERO,
                        e -> {
                            imageView.setImage(imageIterator.next());
                            String fileName = imageView.getImage().impl_getUrl().substring(imageView.getImage().impl_getUrl().lastIndexOf("/") + 1);
                            fileNameLabel.setText(fileName);
                        }
                ),
                new KeyFrame(Duration.seconds(3))
        );
        timeline.setCycleCount(images.size());
        timeline.setOnFinished(event -> {
            imageIterator = images.iterator();
            timeline.playFromStart();
        });
        timeline.play();
    }


}
