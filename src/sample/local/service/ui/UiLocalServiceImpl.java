package sample.local.service.ui;

import javafx.scene.Parent;
import javafx.scene.control.Button;

public class UiLocalServiceImpl implements UiLocalService{


    /**
     * Method to set three of the four buttons to disabled
     * @param parent
     */
    public void initializeButtons(Parent parent) {
        this.setDisabledButtonById(parent, "createSlideShow", Boolean.TRUE);
        this.setDisabledButtonById(parent, "pause", Boolean.TRUE);
        this.setDisabledButtonById(parent, "restart", Boolean.TRUE);
    }

    /**
     * Iterate through all the button that are children of the parent and find the id of the button that
     * you would like to disable
     *
     * @param parent
     * @param id
     * @param enabled
     */
    public void setDisabledButtonById(Parent parent, String id, boolean enabled) {
        for (int i = 0; i < parent.getChildrenUnmodifiable().size(); i++) {
            if (parent.getChildrenUnmodifiable().get(i) instanceof Button) {
                Button button = (Button) parent.getChildrenUnmodifiable().get(i);
                if(button.getId().equalsIgnoreCase(id)) {
                    button.setDisable(enabled);
                    break;
                }
            }
        }
    }

    /**
     * Method to find a child button and change the text of the button when it is found by id
     * @param parent
     * @param id
     * @param text
     */
    public void setButtonTextById(Parent parent, String id, String text) {
        for (int i = 0; i < parent.getChildrenUnmodifiable().size(); i++) {
            if (parent.getChildrenUnmodifiable().get(i) instanceof Button) {
                Button button = (Button) parent.getChildrenUnmodifiable().get(i);
                if(button.getId().equalsIgnoreCase(id)) {
                    button.setText(text);
                    break;
                }
            }
        }
    }



}
