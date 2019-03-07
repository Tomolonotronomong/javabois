package org.bt.javashop.view.create;

import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class CreateAccountView extends GridPane {
    private CreateAccountFields createAccountFields;
    public CreateAccountFields getCreateAccountFields() {
        return createAccountFields;
    }

    public CreateAccountView(){
    	
    	
    	Text message_account_create = new Text("Create an Account");
        message_account_create.setX(50);
        message_account_create.setY(50);
        message_account_create.setFont(Font.font ("Arial", 50));

        createAccountFields = new CreateAccountFields();
        this.setStyle("-fx-background-color: #d3d3d3;");

        VBox rootContainer = new VBox(message_account_create, createAccountFields);
        this.setVgap(250);
        this.setAlignment(Pos.TOP_CENTER);
        this.setPrefSize(500, 500);

        rootContainer.setSpacing(20);
        rootContainer.setPrefSize(200, 200);
        rootContainer.setBorder(new Border(new BorderStroke(Color.web("#C4C8CA"), BorderStrokeStyle.SOLID, null,
                new BorderWidths(0))));

        this.add(rootContainer, 1, 1);
    }





}
