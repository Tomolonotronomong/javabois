package org.bt.javashop.controller;

import javafx.stage.Stage;
import org.bt.javashop.view.Checkout.CheckoutFields;
import org.bt.javashop.view.Checkout.CheckoutView;

public class CheckoutController {

    private CheckoutFields checkoutFields;
    private Stage stage;
    private ScreenController screenController;

    public CheckoutController(CheckoutView checkoutView, ScreenController screenController){
        this.checkoutFields = checkoutView.getCheckoutFields();
        this.screenController = screenController;
        this.attachHandlers();

    }

    private void attachHandlers(){ this.checkoutFields.addOrderHandler(e -> System.out.println("Order Placed"));
    }
}
