package org.bt.javashop.view.customer;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import org.bt.javashop.view.ProductListPane;
import org.bt.javashop.view.RegisterMenuBar;

public class CustomerView extends BorderPane {

    private ProductListPane stock;
    private ProductListPane cart;
    private CustomerButtonPane customerButtons;

    public RegisterMenuBar getMenuBar() {
        return menuBar;
    }

    private RegisterMenuBar menuBar;

    public ProductListPane getStock() {
        return stock;
    }

    public ProductListPane getCart() {
        return cart;
    }

    public CustomerButtonPane getCustomerButtons() {
        return customerButtons;
    }


    public CustomerView(){
        this.setStyle("-fx-background-color: #87cefa;");

        stock = new ProductListPane();
        cart = new ProductListPane();
        customerButtons = new CustomerButtonPane();
        menuBar = new RegisterMenuBar();

        VBox topContainer = new VBox(stock);
        topContainer.setSpacing(20); //spacing between inputPane and buttonPane
        topContainer.setPadding(new Insets(0,0,20,0));

        BorderPane rootContainer = new BorderPane();
        rootContainer.setTop(topContainer);
        rootContainer.setCenter(cart);
        rootContainer.setBottom(customerButtons);
        rootContainer.setPadding(new Insets(20,20,20,20));
        this.setTop(menuBar);
        this.setCenter(rootContainer);
    }

}
