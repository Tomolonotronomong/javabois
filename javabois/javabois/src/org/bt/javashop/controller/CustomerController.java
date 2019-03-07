package org.bt.javashop.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import org.bt.javashop.model.Order;
import org.bt.javashop.model.Stock;
import org.bt.javashop.view.customer.CustomerView;

@SuppressWarnings("Duplicates")
public class CustomerController {

    private Order order;
    private Stock stock;
    private CustomerView customerView;
    private ScreenController screenController;

    public CustomerController(CustomerView customerView, Order order, ScreenController screenController, Stock stock) {
        this.order = order;
        this.customerView = customerView;
        this.screenController = screenController;
        this.stock = stock;
        this.attachEventHandlers();

    }

    private void attachEventHandlers() {
        customerView.getMenuBar().addLoadHandler(new LoadMenuHandler());
        customerView.getMenuBar().addSaveHandler(new SaveMenuHandler());
        customerView.getMenuBar().addExitHandler(e -> System.exit(0));
        customerView.getMenuBar().addAboutHandler(e -> this.alertDialogBuilder(Alert.AlertType.INFORMATION, "Information Dialog", null, "Order MVC app v2.0"));
        customerView.getMenuBar().addIndividSelectHandler(e -> this.alertDialogBuilder(Alert.AlertType.CONFIRMATION, "Name Selected", null, "You selected " +
                customerView.getCart().getSelectedItem()));
        customerView.getMenuBar().addMultiSelectHandler(e -> this.alertDialogBuilder(Alert.AlertType.CONFIRMATION, "Name Selecteds", null, "You selected " +
                customerView.getCart().getSelectedItems()));
        customerView.getCustomerButtons().addCheckoutHandler(e -> this.screenController.activate("checkoutView"));
    }

    private class SaveMenuHandler implements EventHandler<ActionEvent> {

        public void handle(ActionEvent e) {
           DatabaseController database = new FileController("database.dat");
        }
    }

    private class LoadMenuHandler implements EventHandler<ActionEvent> {

        public void handle(ActionEvent e) {
            DatabaseController database = new FileController("database.dat");
            stock = (Stock) database.readData();
            System.out.println("Loaded products");
            //TODO fix
            customerView.getStock().addProduct(stock.getStock().get(0).getProduct());

        }
    }

    //helper method to build dialogs
    private void alertDialogBuilder(Alert.AlertType type, String title, String header, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

}
