package org.bt.javashop.controller;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import org.bt.javashop.model.Product;
import org.bt.javashop.model.Stock;
import org.bt.javashop.view.*;

import java.io.*;


@SuppressWarnings("Duplicates")
public class AdminController {

	//fields to be used throughout the class
	private ProductInputPane productInputPane;
	private AdminButtonPane adminButtonPane;
	private ProductListPane productListPane;
	private RegisterMenuBar registerMenuBar;
	private Stock stock;

	public AdminController(AdminStockView view, Stock stock) {
		//initialise org.bt.javashop.stock and org.bt.javashop.view fields
		this.stock = stock;

		productInputPane = view.getProductPane();
		adminButtonPane = view.getButtonPane();
		productListPane = view.getViewPane();
		registerMenuBar = view.getMenuBar();

		//attach event handlers to org.bt.javashop.view using private helper method
		this.attachEventHandlers();	
		
		//attach bindings within org.bt.javashop.view using private helper method
		this.attachBindings();
	}

	private void attachEventHandlers() {
		//attaching event handlers - some done as lambda expressions and some as inner classes
		adminButtonPane.addAddHandler(new AddHandler());
		adminButtonPane.addClearHandler(e -> productInputPane.clear());
		adminButtonPane.addRemoveHandler(e -> productListPane.removeSelectedNames());
		adminButtonPane.addSubmitHandler(new SubmitHandler());

		registerMenuBar.addLoadHandler(new LoadMenuHandler());
		registerMenuBar.addSaveHandler(new SaveMenuHandler());
		registerMenuBar.addExitHandler(e -> System.exit(0));
		registerMenuBar.addAboutHandler(e -> this.alertDialogBuilder(AlertType.INFORMATION, "Information Dialog", null, "Order MVC app v2.0"));
		registerMenuBar.addIndividSelectHandler(e -> this.alertDialogBuilder(AlertType.CONFIRMATION, "Name Selected", null, "You selected " + productListPane.getSelectedItem()));
		registerMenuBar.addMultiSelectHandler(e -> this.alertDialogBuilder(AlertType.CONFIRMATION, "Name Selecteds", null, "You selected " + productListPane.getSelectedItems()));
	}
	
	/* this method attaches bindings in the org.bt.javashop.view, e.g. for validation */
	private void attachBindings() {
		//attaches a binding such that the submit button in the org.bt.javashop.view will be disabled whenever the contents of the ListView is empty
		adminButtonPane.submitBtnDisableBind(Bindings.isEmpty(productListPane.getContents()));
		
		//attaches a binding such that the add button in the org.bt.javashop.view will be disabled whenever either of the text fields in the ProductInputPane are empty
		adminButtonPane.addBtnDisableBind(productInputPane.isEitherFieldEmpty());
	}

	private class SubmitHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			//TODO
		}
	}

	private class AddHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent e) {	
			//retrieves name from org.bt.javashop.view
			Product n = productInputPane.getProductInput();

			//check input not empty
			if(n.getProductCode().equals("") || n.getDescription().equals("")) {
				//output error
				alertDialogBuilder(AlertType.ERROR, "Error Dialog", null, "Need to input both first and family name!");

			} else {
				//adds it to the list org.bt.javashop.view
				productListPane.addProduct(n);

				//resets name panel in org.bt.javashop.view
				productInputPane.clear();
			}
		}
	}

	//private class SubmitHandler implements EventHandler<ActionEvent> {

	//	public void handle(ActionEvent e) {
			//add contents of the listview to the org.bt.javashop.stock and then clear it
	//		productListPane.getContents().forEach(n -> org.bt.javashop.stock.add(n));
	//		productListPane.clearNames();
	//	}
	// }


	private class SaveMenuHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent e) {
			//save the data org.bt.javashop.stock
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("registerObj.dat"));) {

				oos.writeObject(stock);
				oos.flush();

				alertDialogBuilder(AlertType.INFORMATION, "Information Dialog", "Save success", "Order saved to registerObj.dat");
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

				stock = (Stock) ois.readObject();

				alertDialogBuilder(AlertType.INFORMATION, "Information Dialog", "Load success", "Order loaded from registerObj.dat");
			}
			catch (IOException ioExcep){
				System.out.println("Error loading");
			}
			catch (ClassNotFoundException c) {
				System.out.println("Class Not found");
			}

			//refresh the org.bt.javashop.view with the names loaded back into the org.bt.javashop.stock
			//productListPane.clearNames();
			//org.bt.javashop.stock.forEach(productListPane.getContents()::add); //equivalent to n -> productListPane.getContents().add(n)
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
