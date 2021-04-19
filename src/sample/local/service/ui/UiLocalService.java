package sample.local.service.ui;

import javafx.scene.Parent;

public interface UiLocalService {

    public void initializeButtons(Parent parent);

    public void setDisabledButtonById(Parent parent, String Id, boolean enabled);

    public void setButtonTextById(Parent parent, String id, String text);
}
