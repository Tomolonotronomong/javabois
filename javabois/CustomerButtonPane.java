package org.bt.javashop.view.about;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class AboutButtonPane extends HBox {

    private Button add;
    private Button remove;
    private Button checkout;
    private Button clear;

    public CustomerButtonPane(){

        this.setAlignment(Pos.CENTER);
        this.setSpacing(15);

        add = new Button("Add");
        clear = new Button("Clear");
        remove = new Button("Remove");
        checkout = new Button("Checkout");

        this.getChildren().addAll(add, remove, checkout, clear);
        for (Node n : this.getChildren()) {
            ((Button) n).setPrefSize(70, 30); //set preferred size for each button
        }

    }

    public void addAddHandler(EventHandler<ActionEvent> handler) {
        add.setOnAction(handler);
    }

    public void addClearHandler(EventHandler<ActionEvent> handler) {
        clear.setOnAction(handler);
    }

    public void addRemoveHandler(EventHandler<ActionEvent> handler) {
        remove.setOnAction(handler);
    }

    public void addCheckoutHandler(EventHandler<ActionEvent> handler) {
        checkout.setOnAction(handler);
    }

}
