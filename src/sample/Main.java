package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.local.service.ui.UiLocalService;
import sample.local.service.ui.UiLocalServiceImpl;


public class Main extends Application {

    private UiLocalService uiLocalService = new UiLocalServiceImpl();

    /**
     * Setup the stage for display
     * slideshow.fxml is read into the FXMLoader
     * The slideshow.fxml was created using javafx scene builder 2.0
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("slideshow.fxml"));
        stage.setTitle("Slide Show");
        stage.setScene(new Scene(parent));
        stage.show();
        uiLocalService.initializeButtons(parent);
    }

    public static void main(String[] args) {
        launch(args);
    }


}
