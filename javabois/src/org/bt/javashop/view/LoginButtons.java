package org.bt.javashop.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class LoginButtons extends HBox {

    private Button admin;
    private Button customer;
    private Button about;

    public Button getAdmin() {
        return admin;
    }

    public Button getCustomer() {
        return customer;
    }

    public Button getAbout() { return about; }



    public LoginButtons(){
        admin = new Button("Admin");
        customer = new Button("Customer");
        about = new Button("About");

        this.setAlignment(Pos.BASELINE_CENTER);
        this.setLayoutX(200);
        this.setLayoutY(200);
        this.setSpacing(15);

        this.getChildren().addAll(admin, customer, about);

        for (Node n : this.getChildren()) {
            ((Button) n).setPrefSize(75, 35); //set preferred size for each button
        }

    }

    public void addCustomerHandler(EventHandler<ActionEvent> handler) {
        customer.setOnAction(handler);
    }

    public void addAdminHandler(EventHandler<ActionEvent> handler) {
        admin.setOnAction(handler);
    }

    public void addAboutHandler(EventHandler<ActionEvent> handler) {
        about.setOnAction(handler);
    }
}
