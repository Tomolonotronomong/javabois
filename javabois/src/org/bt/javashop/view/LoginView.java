package org.bt.javashop.view;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class LoginView extends BorderPane {

    public LoginButtons getButtons() {
        return buttons;
    }

    private LoginButtons buttons;

    public LoginView(){
        buttons = new LoginButtons();
        this.setStyle("-fx-background-color: #415D78;");
        VBox topContainer = new VBox(buttons);
        topContainer.setSpacing(20); //spacing between inputPane and buttonPane
        topContainer.setPadding(new Insets(0,0,20,0));

        BorderPane rootContainer = new BorderPane();
        rootContainer.setTop(topContainer);
        this.setCenter(rootContainer);

    }



}
