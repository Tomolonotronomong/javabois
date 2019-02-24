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

    public Button getAdmin() {
        return admin;
    }

    public Button getCustomer() {
        return customer;
    }



    public LoginButtons(){
        admin = new Button("Admin");
        customer = new Button("Customer");

        this.setAlignment(Pos.CENTER);
        this.setSpacing(15);

        this.getChildren().addAll(admin, customer);

        for (Node n : this.getChildren()) {
            ((Button) n).setPrefSize(70, 30); //set preferred size for each button
        }

    }

    public void addCustomerHandler(EventHandler<ActionEvent> handler) {
        customer.setOnAction(handler);
    }

    public void addAdminHandler(EventHandler<ActionEvent> handler) {
        admin.setOnAction(handler);
    }
}
