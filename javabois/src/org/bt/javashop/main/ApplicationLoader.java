
package org.bt.javashop.main;

import org.bt.javashop.controller.AdminController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.bt.javashop.controller.CustomerController;
import org.bt.javashop.controller.LoginController;
import org.bt.javashop.model.Order;
import org.bt.javashop.model.Stock;
import org.bt.javashop.view.AdminStockView;
import org.bt.javashop.view.CustomerView;
import org.bt.javashop.view.LoginView;

public class ApplicationLoader extends Application {

	private AdminStockView adminView;
	private CustomerView customerView;
	private LoginView loginView;

	@Override
	public void init() {
		//creates stuff for admin page
		Stock model = new Stock();
		adminView = new AdminStockView();
		new AdminController(adminView, model);

		//creates stuff for customer page
		Order order = new Order();
		customerView = new CustomerView();
		new CustomerController(customerView, order);

		//Login Screen components
		loginView = new LoginView();

	}
	
	@Override
	public void start(Stage stage) throws Exception {
		new LoginController(loginView, stage, adminView, customerView);
		stage.setTitle("Javabois");
		stage.setScene(new Scene(customerView)); //TODO fix login
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
