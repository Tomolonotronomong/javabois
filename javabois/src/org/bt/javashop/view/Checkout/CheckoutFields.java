package org.bt.javashop.view.Checkout;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class CheckoutFields extends VBox {

    private RadioButton rb1;
    private RadioButton rb2;
    private TextField address1;
    private TextField address2;
    private TextField address3;
    private TextField postcode;
    private Button order;







    public CheckoutFields(){

        rb1 = new RadioButton("Home Delivery");
        rb2 = new RadioButton("Collection");
        address1 = new TextField("Address1");
        address2 = new TextField("Address2");
        address3 = new TextField("Address3");
        postcode = new TextField("Postcode");
        order = new Button("Place Order");

        this.setAlignment(Pos.BASELINE_CENTER);
        this.setLayoutX(200);
        this.setLayoutY(200);
        this.getChildren().addAll(rb1, rb2, address1, address2, address3, postcode, order);

    }
    public void addOrderHandler(EventHandler<ActionEvent> handler) { order.setOnAction(handler); }
}
