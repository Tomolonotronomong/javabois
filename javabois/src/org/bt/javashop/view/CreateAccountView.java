package org.bt.javashop.view;

import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class CreateAccountView extends GridPane {
    private CreateAccountFields createAccountFields;
    public CreateAccountFields getCreateAccountFields() {
        return createAccountFields;
    }

    public CreateAccountView(){

        createAccountFields = new CreateAccountFields();
        this.setStyle("-fx-background-color: #87cefa;");

        VBox rootContainer = new VBox(createAccountFields);
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
