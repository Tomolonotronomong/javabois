package org.bt.javashop.view;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.awt.*;

public class LoginView extends BorderPane {

    public LoginButtons getButtons() {
        return buttons;
    }

    private LoginButtons buttons;

    public LoginView(){
        buttons = new LoginButtons();
        this.setStyle("-fx-background-color: #87cefa;");
        VBox topContainer = new VBox(buttons);

        topContainer.setSpacing(20); //spacing between inputPane and buttonPane
        topContainer.setPadding(new Insets(0,0,20,0));

        BorderPane rootContainer = new BorderPane();
        rootContainer.setTop(topContainer);
        this.setCenter(rootContainer);

        // Main Title
        Text title = new Text("This is a text sample");
        title.setFont(Font.font ("Verdana", 20));
        title.setX(50);
        title.setY(50);

        Label label = new Label("a label");




    }



}
