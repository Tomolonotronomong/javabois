package org.bt.javashop.view.Checkout;

import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import org.bt.javashop.view.Checkout.CheckoutFields;

public class CheckoutView extends GridPane {
    private CheckoutFields checkoutFields;

    public CheckoutFields getCheckoutFields() { return checkoutFields; }

    public CheckoutView(){

        checkoutFields = new CheckoutFields();
        this.setStyle("-fx-background-color:#87cefa; ");

        VBox rootContainer = new VBox(checkoutFields);
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
