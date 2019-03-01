package org.bt.javashop.view.Authentication;


import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class AdminAuthView extends GridPane {
    private AdminAuthFields adminAuthFields;
    public AdminAuthFields getadminAuthFields(){return adminAuthFields;}

    public AdminAuthView(){

        adminAuthFields = new AdminAuthFields();
        this.setStyle("-fx-background-color: #ff4500;");

        VBox rootContainer = new VBox(adminAuthFields);
        this.setVgap(170);
        this.setAlignment(Pos.TOP_CENTER);
        this.setPrefSize(500, 500);

        rootContainer.setSpacing(20);
        rootContainer.setPrefSize(600, 300);
        rootContainer.setBorder(new Border(new BorderStroke(Color.web("#C4C8CA"), BorderStrokeStyle.SOLID, null,
                new BorderWidths(2))));

        this.add(rootContainer, 1, 1);
    }

    public AdminAuthFields getAdminAuthFields() {return this.adminAuthFields; }
}
