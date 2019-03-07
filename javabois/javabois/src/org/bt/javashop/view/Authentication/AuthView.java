package org.bt.javashop.view.Authentication;

import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import org.bt.javashop.view.Authentication.AuthFields;


public class AuthView extends GridPane{
    private AuthFields authFields;
    public AuthFields getauthFields(){return authFields; }

    public AuthView(){

        authFields= new AuthFields();
        this.setStyle("-fx-background-color:#d3d3d3; ");
        
        Text message_customer = new Text("Customer Login");
        message_customer.setX(50);
        message_customer.setY(50);
        message_customer.setFont(Font.font ("Arial", 50));

        VBox rootContainer = new VBox(message_customer, authFields);
        this.setVgap(250);
        this.setAlignment(Pos.TOP_CENTER);
        this.setPrefSize(500, 500);

        rootContainer.setSpacing(20);
        rootContainer.setPrefSize(200, 200);
        rootContainer.setBorder(new Border(new BorderStroke(Color.web("#C4C8CA"), BorderStrokeStyle.SOLID, null,
                new BorderWidths(0))));

        this.add(rootContainer, 1, 1);

    }


    public AuthFields getAuthFields() {
     return this.authFields;
    }
}
