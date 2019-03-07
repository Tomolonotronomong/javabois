package org.bt.javashop.view.Authentication;


import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class AdminAuthView extends GridPane {
    private AdminAuthFields adminAuthFields;
    public AdminAuthFields getadminAuthFields(){return adminAuthFields;}

    public AdminAuthView(){

        adminAuthFields = new AdminAuthFields();
        this.setStyle("-fx-background-color: #d3d3d3;");
        
        Text message_admin = new Text("Administrator Login");
        message_admin.setX(50);
        message_admin.setY(50);
        message_admin.setFont(Font.font ("Arial", 50));

        
        VBox rootContainer = new VBox(message_admin, adminAuthFields);
        this.setVgap(250);
        this.setAlignment(Pos.TOP_CENTER);
        this.setPrefSize(500, 500);

        rootContainer.setSpacing(20);
        rootContainer.setPrefSize(200, 200);
        rootContainer.setBorder(new Border(new BorderStroke(Color.web("#C4C8CA"), BorderStrokeStyle.SOLID, null,
                new BorderWidths(0))));

        this.add(rootContainer, 1, 1);
    }
    

    public AdminAuthFields getAdminAuthFields() {return this.adminAuthFields; }
}
