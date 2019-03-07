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
        this.setStyle("-fx-background-color: #d3d3d3;");
        Text message = new Text("Online Shopping Centre");
        message.setX(50);
        message.setY(50);
        message.setFont(Font.font ("Arial", 50));
        VBox rootContainer = new VBox(message, buttons);
        this.setVgap(170);
        this.setAlignment(Pos.TOP_CENTER);
        this.setPrefSize(400, 600);

        rootContainer.setSpacing(20);
        rootContainer.setPrefSize(600, 300);
        rootContainer.setBorder(new Border(new BorderStroke(Color.web("#C4C8CA"), BorderStrokeStyle.SOLID, null,
                new BorderWidths(0))));

        this.add(rootContainer, 1, 1);
    }

}
