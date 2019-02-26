package org.bt.javashop.controller;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import org.bt.javashop.model.LineItem;
import org.bt.javashop.model.Product;
import org.bt.javashop.model.Stock;
import org.bt.javashop.view.*;


@SuppressWarnings("Duplicates")
public class AdminController {

	//fields to be used throughout the class
	private ProductInputPane productInputPane;
	private AdminButtonPane adminButtonPane;
	private ProductListPane productListPane;
	private RegisterMenuBar registerMenuBar;
	private Stock stock;

	public AdminController(AdminStockView view, Stock stock) {
		this.stock = stock;
		//this is silly
		productInputPane = view.getProductPane();
		adminButtonPane = view.getButtonPane();
		productListPane = view.getViewPane();
		registerMenuBar = view.getMenuBar();

		this.attachEventHandlers();
		this.attachBindings();
	}

	private void attachEventHandlers() {
		//attaching event handlers - some done as lambda expressions and some as inner classes
		adminButtonPane.addAddHandler(new AddHandler());
		adminButtonPane.addClearHandler(e -> productInputPane.clear());
		adminButtonPane.addRemoveHandler(e -> productListPane.removeSelectedNames());
		registerMenuBar.addLoadHandler(new LoadMenuHandler());
		registerMenuBar.addSaveHandler(new SaveMenuHandler());
		registerMenuBar.addExitHandler(e -> System.exit(0));
		registerMenuBar.addAboutHandler(e -> this.alertDialogBuilder(AlertType.INFORMATION, "Information Dialog",
				null, "Order MVC app v2.0"));
		registerMenuBar.addIndividSelectHandler(e -> this.alertDialogBuilder(AlertType.CONFIRMATION, "Name Selected",
				null, "You selected " + productListPane.getSelectedItem()));
		registerMenuBar.addMultiSelectHandler(e -> this.alertDialogBuilder(AlertType.CONFIRMATION, "Name Selecteds",
				null, "You selected " + productListPane.getSelectedItems()));
	}
	
	/* this method attaches bindings in the org.bt.javashop.view, e.g. for validation */
	private void attachBindings() {
		//attaches a binding such that the submit button in the org.bt.javashop.view will be disabled whenever the contents of the ListView is empty
		adminButtonPane.submitBtnDisableBind(Bindings.isEmpty(productListPane.getContents()));
		//attaches a binding such that the add button in the org.bt.javashop.view will be disabled whenever either of the text fields in the ProductInputPane are empty
		adminButtonPane.addBtnDisableBind(productInputPane.isEitherFieldEmpty());
	}


	private class AddHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent e) {	
			//retrieves name from org.bt.javashop.view
			Product n = productInputPane.getProductInput();


			//check input not empty
			if(n.getProductCode().equals("") || n.getDescription().equals("")) {
				//output error
				alertDialogBuilder(AlertType.ERROR, "Error Dialog", null, "Need to input a Product!");

			} else {
				productListPane.addProduct(n);
				LineItem lineItem = new LineItem(n, 1); //tactical fix
				stock.getStock().add(lineItem);
				productInputPane.clear();
			}
		}
	}


	private class SaveMenuHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent e) {
			DatabaseController database = new DatabaseController("database.dat");
			database.writeData(stock);
		}
	}

	private class LoadMenuHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent e) {
			DatabaseController database = new DatabaseController("database.dat");
			stock = (Stock) database.readData();
		}
	}

	//helper method to build dialogs
	private void alertDialogBuilder(AlertType type, String title, String header, String content) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.showAndWait();
	}

}
