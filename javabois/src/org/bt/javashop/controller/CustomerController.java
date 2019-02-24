package org.bt.javashop.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import org.bt.javashop.model.Order;
import org.bt.javashop.view.CustomerView;

import java.io.*;

@SuppressWarnings("Duplicates")
public class CustomerController {

    private Order order;
    private CustomerView customerView;

    public CustomerController(CustomerView customerView, Order order) {
        this.order = order;
        this.customerView = customerView;
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
    }

    private class SaveMenuHandler implements EventHandler<ActionEvent> {

        public void handle(ActionEvent e) {
            //save the data org.bt.javashop.stock
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("registerObj.dat"));) {

                oos.writeObject(order);
                oos.flush();

                alertDialogBuilder(Alert.AlertType.INFORMATION, "Information Dialog", "Save success", "Order saved to registerObj.dat");
            }
            catch (IOException ioExcep){
                System.out.println("Error saving");
            }
        }
    }

    private class LoadMenuHandler implements EventHandler<ActionEvent> {

        public void handle(ActionEvent e) {
            //load in the data org.bt.javashop.stock
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("registerObj.dat"));) {

                order = (Order) ois.readObject();

                alertDialogBuilder(Alert.AlertType.INFORMATION, "Information Dialog", "Load success", "Order loaded from registerObj.dat");
            }
            catch (IOException ioExcep){
                System.out.println("Error loading");
            }
            catch (ClassNotFoundException c) {
                System.out.println("Class Not found");
            }

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
