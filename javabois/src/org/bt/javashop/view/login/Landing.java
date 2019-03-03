package org.bt.javashop.view.login;

import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Landing extends GridPane {
    private LoginButtons buttons;
    public LoginButtons getButtons() {
        return buttons;
    }


    public Landing(){
        buttons = new LoginButtons();
        this.setStyle("-fx-background-color: #87cefa;");
        Text message = new Text("B - Bay");
        message.setX(50);
        message.setY(50);
        message.setFont(Font.font ("Verdana", 50));
        VBox rootContainer = new VBox(message, buttons);
        this.setVgap(170);
        this.setAlignment(Pos.TOP_CENTER);
        this.setPrefSize(500, 500);

        rootContainer.setSpacing(20);
        rootContainer.setPrefSize(600, 300);
        rootContainer.setBorder(new Border(new BorderStroke(Color.web("#C4C8CA"), BorderStrokeStyle.SOLID, null,
                new BorderWidths(2))));

        this.add(rootContainer, 1, 1);
    }

}
